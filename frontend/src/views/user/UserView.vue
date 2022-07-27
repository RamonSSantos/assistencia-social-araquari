<template>
  <div>
    <b-modal
      :visible="visible"
      title="Visualizar Usuário"
      @hidden="hideModal"
      @change="changeModal"
    >
      <template v-if="viewModal">
        <b-form>
          <InputText
            id="fullname"
            label="Nome:"
            v-model="viewObject.fullname"
            :isValidText="null"
            :required="false"
            :disabled="true"
          />
          <InputEmail
            id="email"
            label="E-mail:"
            v-model="viewObject.email"
            :isValidEmail="null"
            :required="false"
            :disabled="true"
          />
          <InputTextCpf
            id="cpf"
            label="CPF:"
            v-model="viewObject.cpf"
            :isValidCpf="null"
            :required="false"
            :disabled="true"
          />
          <InputText
            id="userStatus"
            label="Status:"
            v-model="userStatus"
            :isValidText="null"
            :required="false"
            :disabled="true"
          />
          <InputText
            id="profile"
            label="Perfil:"
            v-model="viewObject.profile.description"
            :isValidText="null"
            :required="false"
            :disabled="true"
          />
        </b-form>
      </template>
      <template v-slot:modal-footer>
        <BaseButton
          type="button"
          id="editUser"
          buttonName="Editar"
          variant="info"
          @click.stop.once="showEditUserModal(viewObject)"
          :to="{ name: 'UserEdit', params: { id: +viewObject.id } }"
        />
      </template>
    </b-modal>
    <edit-user :editModal="editUserObject" v-model="editUserStatus"></edit-user>
  </div>
</template>

<script>
import EditUser from './UserEdit'
import modalVisibility from '@/mixins/modalVisibility'

export default {
  name: 'UserView',
  mixins: [modalVisibility],
  components: {
    EditUser
  },
  computed: {
    userStatus() {
      return this.viewObject.status === 1 ? 'Ativo' : 'Inativo'
    }
  },
  data() {
    return {
      viewObject: {
        fullname: '',
        email: '',
        cpf: '',
        status: 0,
        profile: {
          description: ''
        }
      },
      editUserStatus: false,
      editUserObject: null
    }
  },
  methods: {
    showEditUserModal(item) {
      this.editUserObject = item
      this.editUserStatus = true
      this.changeModal(false)
    },
    hideModal() {
      if (!this.editUserStatus) {
        this.$router.push({ name: 'User', params: { page: this.lastPage } })
      }
    }
  },
  watch: {
    viewModal(newValue) {
      this.viewObject = Object.assign({}, newValue)
    }
  }
}
</script>

<style scoped>
label {
  margin-bottom: 0;
}
</style>
