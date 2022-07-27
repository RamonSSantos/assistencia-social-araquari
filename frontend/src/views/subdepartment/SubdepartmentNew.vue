<template>
  <b-modal
    ref="newSubdepartment"
    v-bind="$attrs"
    :visible="visible"
    title="Adicionar Equipamento"
    @hidden="hideModal"
    @change="changeModal"
  >
    <b-overlay :show="loading">
      <b-form>
        <InputText
          id="description"
          label="Nome:"
          v-model="newSubdepartment.description"
          :isValidText.sync="isValidSubdepartmentDescription"
          placeholder="Descrição"
          :maxlength="45"
          :minlength="4"
          :required="true"
          :disabled="false"
          :autofocus="true"
        />
        <InputDataList
          id="department"
          datalist="departmentList"
          label="Setor:"
          v-model="departmentDescription"
          :idDatalist.sync="newSubdepartment.department.id"
          :sizes="departments"
          placeholder="Selecione o setor"
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
        id="newSubdepartment"
        buttonName="Cadastrar"
        variant="outline-info"
        :disabled="disableButton"
        @click.stop.once="addSubdepartment"
      />
    </template>
  </b-modal>
</template>

<script>
import SubdepartmentService from '@/services/SubdepartmentService'
import modalVisibility from '@/mixins/modalVisibility'
import EventBus from '@/services/EventBus'

export default {
  name: 'SubdepartmentNew',
  mixins: [modalVisibility],
  props: {
    departments: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      newSubdepartment: {
        description: null,
        department: {
          id: null
        }
      },
      departmentDescription: null,
      isValidSubdepartmentDescription: null,
      loading: false
    }
  },
  computed: {
    disableButton: {
      get() {
        return this.isValidSubdepartmentDescription &&
          this.newSubdepartment.department.id &&
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
    async addSubdepartment() {
      this.disableButton = true
      this.loading = true
      try {
        const response = await SubdepartmentService.new(this.newSubdepartment)

        const notification = {
          type: 'info',
          message: response.data
        }
        this.$store.dispatch('notification/add', notification, { root: true })
        setTimeout(() => {
          this.loading = false
          this.$refs['newSubdepartment'].hide()
          this.resetForm()
        }, 2000)
      } catch {
        this.loading = false
      }
    },
    resetForm() {
      this.newSubdepartment.description = null
      this.newSubdepartment.department.id = null
      this.departmentDescription = null
      this.loading = false
    },
    hideModal() {
      EventBus.$emit(this.$route.meta.eventBus)
      this.$router.push({
        name: 'Subdepartment',
        params: { page: this.lastPage }
      })
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
