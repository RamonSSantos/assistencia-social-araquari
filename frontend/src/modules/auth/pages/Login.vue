<template>
  <div class="background">
    <b-container :style="formLogin">
      <b-img v-bind="logo" :src="url"></b-img>
      <b-form @reset="resetForm">
        <b-input-group class="mt-3">
          <b-input-group-prepend is-text>
            <BaseIcon icon="person-fill" :variant="null" />
          </b-input-group-prepend>
          <InputEmail
            id="loginEmail"
            ref="email"
            v-model="form.email"
            :isValidEmail.sync="isValidEmail"
            placeholder="E-mail"
            :maxlength="45"
            :required="true"
            :disabled="false"
          />
        </b-input-group>
        <b-input-group class="mt-1">
          <b-input-group-prepend is-text>
            <BaseIcon icon="lock-fill" :variant="null" />
          </b-input-group-prepend>
          <InputPassword
            id="loginPassword"
            v-model="form.password"
            :isValidPassword.sync="isValidPassword"
            placeholder="Senha"
            :maxlength="45"
            :required="true"
            :disabled="false"
            @keydown.enter.prevent="login"
          />
        </b-input-group>
        <BaseButton
          type="submit"
          id="authenticate"
          buttonName="Entrar"
          variant="info"
          :disabled="disableButton"
          :block="true"
          :buttonWithSpinner="true"
          :loadingSpinner="loading"
          class="mt-2"
          @click.stop.prevent="login"
        />
        <BaseButton
          type="reset"
          id="resetForm"
          buttonName="Limpar"
          variant="dark"
          :disabled="loading"
          :block="true"
          class="mt-1"
        />
        <b-link href="#" :style="recoverPassword">Esqueceu sua senha?</b-link>
      </b-form>
    </b-container>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'Login',
  data() {
    return {
      logo: {
        center: true,
        width: '300rem'
      },
      form: {
        email: null,
        password: null
      },
      url: require('@/assets/logo400x96.png'),
      formLogin: {
        backgroundColor: 'white',
        borderRadius: '0.5rem',
        opacity: '0.9',
        maxWidth: '25rem',
        margin: 'auto',
        padding: '1rem',
        position: 'absolute',
        left: '50%',
        top: '50%',
        transform: 'translate(-50%, -50%)'
      },
      recoverPassword: {
        marginTop: '1rem',
        display: 'flex',
        flexDirection: 'row-reverse',
        color: '#000000',
        fontSize: '0.9rem'
      },
      isValidEmail: false,
      isValidPassword: false,
      loading: false
    }
  },
  computed: {
    disableButton() {
      return !this.isValidEmail || !this.isValidPassword ? true : false
    }
  },
  mounted() {
    this.$refs.email.$refs.inputEmail.focus()
  },
  methods: {
    ...mapActions('auth', ['ActionDoLogin', 'ActionInvalidLogin']),
    async login() {
      if (!this.loginButton) {
        this.loading = true
        try {
          await this.ActionDoLogin(this.form)
          setTimeout(() => this.$router.push({ name: 'Home' }), 3000)
        } catch (err) {
          await this.ActionInvalidLogin(err)
          this.isValidEmail = null
          this.isValidPassword = null
        } finally {
          setTimeout(() => (this.loading = false), 3000)
        }
      }
    },
    resetForm() {
      this.form.email = null
      this.form.password = null
      this.$refs.email.$refs.inputEmail.focus()
    }
  }
}
</script>

<style scoped>
.background {
  background-image: url('../../../assets/background4800x3200.jpg');
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center center;
  height: calc(100vh - 0px);
}
</style>
