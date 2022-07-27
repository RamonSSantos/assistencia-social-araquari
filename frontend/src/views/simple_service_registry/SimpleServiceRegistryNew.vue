<template :visible="visible">
  <div v-if="newObject">
    <div class="main-content__top">
      <div class="main-content__title">
        <h4>Registro Simplificado do Atendimento</h4>
      </div>
    </div>
    <div class="main-content__body">
      <b-container fluid class="bv-example-row pl-0">
        <BreadCrumb />
        <b-row>
          <b-col lg="6" md="6" sm="12">
            <InputDataList
              id="subdepartments"
              datalist="subdepartmentList"
              label="Equipamento:"
              v-model="subdepartmentDescription"
              :sizes="subdepartments"
              placeholder="Selecione o equipamento"
              :required="true"
              :disabled="disabled"
              :autofocus="true"
            />
          </b-col>
          <b-col lg="6" md="6" sm="12">
            <InputText
              id="iduser"
              label="Técnico Responsável:"
              v-model="userInformation.fullname"
              :maxlength="80"
              :required="false"
              :disabled="!disabled"
            />
          </b-col>
        </b-row>
        <div v-if="subdepartmentSelected !== 0">
          <SubdepartmentForm
            :subdepartment="subdepartmentSelected"
            :newObject="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </div>
      </b-container>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import SubdepartmentService from '@/services/SubdepartmentService'
import pageVisibility from '@/mixins/pageVisibility'

export default {
  name: 'SimpleServiceRegistryNew',
  mixins: [pageVisibility],
  data() {
    return {
      subdepartmentDescription: null,
      subdepartments: [],
      subdepartmentSelected: 0,
      userInformation: {
        id: null,
        fullname: ''
      },
      disabled: false
    }
  },
  created() {
    this.showUserInformation()
    this.getSubdepartments()
  },
  methods: {
    ...mapActions('auth', ['ActionGetUser']),
    async showUserInformation() {
      const response = await this.ActionGetUser()
      this.userInformation.id = response[0]
      this.userInformation.fullname = response[1]
    },
    async getSubdepartments() {
      const response = await SubdepartmentService.getAll(1)
      const { content } = response.data

      this.subdepartments = content
    }
  },
  watch: {
    subdepartmentDescription(newValue) {
      this.subdepartmentSelected = 0
      for (let i of this.subdepartments) {
        if (i.description === newValue) {
          this.subdepartmentSelected = i
        }
      }
    }
  }
}
</script>
