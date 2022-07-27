<template>
  <b-modal
    ref="newUser"
    v-bind="$attrs"
    :visible="visible"
    title="Adicionar Usuário"
    @hidden="hideModal"
    @change="changeModal"
  >
    <b-overlay :show="loading">
      <b-form>
        <InputText
          id="fullname"
          label="Nome:"
          v-model="newUser.fullname"
          :isValidText.sync="isValidFullname"
          placeholder="Nome completo"
          :maxlength="45"
          :minlength="4"
          :required="true"
          :disabled="false"
          :autofocus="true"
        />
        <InputEmail
          id="email"
          ref="email"
          label="E-mail:"
          v-model="newUser.email"
          :isValidEmail.sync="isValidEmail"
          placeholder="meu@email.com"
          :maxlength="45"
          :required="true"
          :disabled="false"
        />
        <InputTextCpf
          id="cpf"
          ref="cpf"
          label="CPF:"
          v-model="cpfWithMask"
          :isValidCpf.sync="isValidCpf"
          placeholder="Exemplo: 123.456.789-00"
          :minlength="14"
          :maxlength="14"
          :required="true"
          :disabled="false"
        />
        <label for="password">Senha:</label>
        <b-input-group class="mb-3">
          <b-form-input
            id="password"
            v-model="newUser.password"
            type="password"
            @input="checkPassword"
            :state="fieldPassword"
            placeholder="Senha"
            autocomplete="off"
            class="mr-1"
            aria-describedby="input-live-help input-live-feedback"
            required
            trim
          >
          </b-form-input>
          <b-form-input
            id="passwordConfirmation"
            v-model="passwordConfirmation"
            type="password"
            @input="checkPasswordConfirmation"
            placeholder="Confirmar Senha"
            autocomplete="off"
            class="ml-1"
            required
            trim
          >
          </b-form-input>
          <b-form-invalid-feedback id="input-live-feedback">{{
            errorMessagePassword
          }}</b-form-invalid-feedback>
        </b-input-group>
        <InputDataList
          id="profile"
          datalist="profileList"
          label="Perfil:"
          v-model="profileDescription"
          :idDatalist.sync="newUser.profile.id"
          :sizes="profiles"
          placeholder="Selecione o perfil do usuário"
          :required="true"
          :disabled="false"
        />
      </b-form>
    </b-overlay>
    <template v-slot:modal-footer>
      <BaseButton
        type="reset"
        id="resetForm"
        buttonName="Limpar"
        variant="outline-secondary"
        @click.stop="resetForm"
      />
      <BaseButton
        type="submit"
        id="newUser"
        buttonName="Cadastrar"
        variant="outline-info"
        :disabled="disableButton"
        @click.stop="addUser"
      />
    </template>
  </b-modal>
</template>

<script>
import UserService from '@/services/UserService'
import modalVisibility from '@/mixins/modalVisibility'
import EventBus from '@/services/EventBus'

export default {
  name: 'UserNew',
  mixins: [modalVisibility],
  props: {
    profiles: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      newUser: {
        fullname: null,
        email: null,
        cpf: null,
        password: null,
        profile: {
          id: null
        }
      },
      loading: false,
      isValidFullname: null,
      cpfWithMask: null,
      passwordConfirmation: null,
      password_length: 0,
      contains_eight_characters: false,
      contains_number: false,
      contains_special_character: false,
      valid_password: false,
      valid_password_confirmation: false,
      errorMessagePassword: null,
      profileDescription: null,
      isValidCpf: null,
      isValidEmail: null
    }
  },
  computed: {
    fieldPassword() {
      return this.newUser.password === null || this.newUser.password === ''
        ? null
        : this.valid_password && this.valid_password_confirmation
        ? true
        : false
    },
    disableButton: {
      get() {
        return this.isValidFullname &&
          this.isValidEmail &&
          this.isValidCpf &&
          this.fieldPassword &&
          this.newUser.profile.id &&
          !this.loading
          ? false
          : true
      },
      set(newValue) {
        return newValue
      }
    }
  },
  methods: {
    checkPassword() {
      this.password_length = this.newUser.password.length
      // eslint-disable-next-line
			const format = /[ !@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/;

      if (this.password_length > 7) {
        this.contains_eight_characters = true
      } else {
        this.contains_eight_characters = false
      }

      // eslint-disable-next-line
      this.contains_number = /\d/.test(this.newUser.password);
      this.contains_special_character = format.test(this.newUser.password)

      if (
        this.contains_eight_characters &&
        this.contains_special_character &&
        this.contains_number
      ) {
        this.valid_password = true
        this.errorMessagePassword = null
        if (this.passwordConfirmation === null) {
          /* Não ocorre nada */
        } else {
          if (this.newUser.password === this.passwordConfirmation) {
            this.valid_password_confirmation = true
          } else {
            this.valid_password = false
            this.errorMessagePassword = 'As senhas não conferem!'
          }
        }
      } else {
        this.valid_password = false
        this.errorMessagePassword =
          'A senha deve conter 8 caracteres com letras, números e caracter especial!'
      }
    },
    checkPasswordConfirmation() {
      if (this.valid_password) {
        if (this.passwordConfirmation === this.newUser.password) {
          this.valid_password_confirmation = true
        } else {
          this.valid_password_confirmation = false
          this.errorMessagePassword = 'As senhas não conferem!'
        }
      } else {
        this.valid_password_confirmation = false
      }
    },
    async addUser() {
      this.disableButton = true
      this.loading = true
      this.unmaskCpf()
      try {
        const response = await UserService.new(this.newUser)

        const notification = {
          type: 'info',
          message: response.data
        }
        this.$store.dispatch('notification/add', notification, { root: true })
        setTimeout(() => {
          this.loading = false
          this.$refs['newUser'].hide()
          this.resetForm()
        }, 2000)
      } catch (err) {
        this.loading = false
        if (err.response.status === 409) {
          this.isValidCpf = false
          this.$refs.cpf.$refs.inputCpf.select()
        } else if (err.response.status === 400) {
          this.isValidEmail = false
          this.$refs.email.$refs.inputEmail.select()
        }
      }
    },
    unmaskCpf() {
      // eslint-disable-next-line
      this.newUser.cpf = this.cpfWithMask.replace(/(\.|\/|\-)/g, "");
    },
    resetForm() {
      this.cpfWithMask = null
      this.newUser.fullname = null
      this.newUser.email = null
      this.newUser.cpf = null
      this.newUser.password = null
      this.newUser.profile.id = null
      this.passwordConfirmation = null
      this.profileDescription = null
      this.loading = false
    },
    hideModal() {
      EventBus.$emit(this.$route.meta.eventBus)
      this.$router.push({ name: 'User', params: { page: this.lastPage } })
    }
  }
}
</script>

<style scoped>
label {
  margin-bottom: 0;
}

.modal-body {
  padding-top: 0;
}
</style>
