<template>
  <b-modal
    ref="editUser"
    v-bind="$attrs"
    :visible="visible"
    title="Editar Usuário"
    @hidden="hideModal"
    @change="changeModal"
  >
    <b-overlay :show="loading">
      <template v-if="editModal">
        <b-form>
          <InputText
            id="fullname"
            label="Nome:"
            v-model="editedUser.fullname"
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
            v-model="editedUser.email"
            :isValidEmail.sync="isValidEmail"
            placeholder="meu@email.com"
            :maxlength="45"
            :required="true"
            :disabled="false"
          />
          <InputTextCpf
            id="cpf"
            label="CPF:"
            v-model="editedUser.cpf"
            :isValidCpf="isValidCpf"
            :required="false"
            :disabled="true"
          />
          <b-form-group label="Status:" label-for="status">
            <b-form-checkbox id="status" v-model="statusUser" switch
              >Ativo</b-form-checkbox
            >
          </b-form-group>
          <InputDataList
            id="profile"
            datalist="profileList"
            label="Perfil:"
            v-model="profileDescription"
            :idDatalist.sync="editedUser.profile.id"
            :sizes="profiles"
            placeholder="Selecione o perfil do usuário"
            :required="true"
            :disabled="false"
          />
        </b-form>
      </template>
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
        id="editUser"
        buttonName="Editar"
        variant="outline-info"
        :disabled="disableButton"
        @click.stop="updateUser"
      />
    </template>
  </b-modal>
</template>

<script>
import UserService from '@/services/UserService'
import modalVisibility from '@/mixins/modalVisibility'
import EventBus from '@/services/EventBus'

export default {
  name: 'UserEdit',
  mixins: [modalVisibility],
  props: {
    profiles: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      editedUser: {
        fullname: null,
        email: null,
        profile: {
          id: null
        }
      },
      isValidFullname: null,
      isValidEmail: null,
      isValidCpf: null,
      profileDescription: '',
      loading: false
    }
  },
  computed: {
    statusUser: {
      get() {
        return this.editedUser.status === 1 ? true : false
      },
      set(newStatus) {
        if (newStatus) {
          this.editedUser.status = '1'
        } else {
          this.editedUser.status = '2'
        }
        return newStatus
      }
    },
    disableButton: {
      get() {
        return this.isValidFullname === false ||
          this.isValidEmail === false ||
          this.editedUser.profile.id == null ||
          this.loading
          ? true
          : false
      },
      set(newValue) {
        return newValue
      }
    }
  },
  methods: {
    async updateUser() {
      this.disableButton = true
      this.loading = true
      this.unmaskCpf()
      try {
        const response = await UserService.edit(this.editedUser)

        const notification = {
          type: 'info',
          message: response.data
        }
        this.$store.dispatch('notification/add', notification, { root: true })
        setTimeout(() => {
          this.loading = false
          this.$refs['editUser'].hide()
          this.resetForm()
        }, 2000)
      } catch {
        this.loading = false
        this.isValidEmail = false
        this.$refs.email.$refs.inputEmail.select()
      }
    },
    unmaskCpf() {
      // eslint-disable-next-line
      this.editedUser.cpf = this.editedUser.cpf.replace(/(\.|\/|\-)/g, "");
    },
    resetForm() {
      this.editedUser.fullname = null
      this.editedUser.email = null
      this.editedUser.profile.id = null
      this.profileDescription = null
    },
    hideModal() {
      EventBus.$emit(this.$route.meta.eventBus)
      this.$router.push({ name: 'User', params: { page: this.lastPage } })
    }
  },
  watch: {
    editModal(newValue) {
      this.editedUser = Object.assign({}, newValue)
      this.profileDescription = newValue.profile.description
    }
  }
}
</script>

<style scoped>
label {
  margin-bottom: 0;
}
</style>
