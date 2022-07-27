<template>
  <b-modal
    ref="editSubdepartment"
    v-bind="$attrs"
    :visible="visible"
    title="Editar Equipamento"
    @hidden="hideModal"
    @change="changeModal"
  >
    <b-overlay :show="loading">
      <template v-if="editModal">
        <b-form>
          <InputText
            id="description"
            label="Nome:"
            v-model="editedSubdepartment.description"
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
            :idDatalist.sync="editedSubdepartment.department.id"
            :sizes="departments"
            placeholder="Selecione o setor"
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
        id="editSubdepartment"
        buttonName="Editar"
        variant="outline-info"
        :disabled="disableButton"
        @click.stop.once="updateSubdepartment"
      />
    </template>
  </b-modal>
</template>

<script>
import SubdepartmentService from '@/services/SubdepartmentService'
import modalVisibility from '@/mixins/modalVisibility'
import EventBus from '@/services/EventBus'

export default {
  name: 'SubdepartmentEdit',
  mixins: [modalVisibility],
  props: {
    departments: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      editedSubdepartment: {
        description: null,
        department: {
          id: null
        }
      },
      departmentDescription: '',
      isValidSubdepartmentDescription: null,
      loading: false
    }
  },
  computed: {
    disableButton: {
      get() {
        return this.isValidSubdepartmentDescription === false ||
          this.editedSubdepartment.department.id === null ||
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
    async updateSubdepartment() {
      this.disableButton = true
      this.loading = true
      this.editedSubdepartment.department.description = this.department
      try {
        const response = await SubdepartmentService.edit(
          this.editedSubdepartment
        )

        const notification = {
          type: 'info',
          message: response.data
        }
        this.$store.dispatch('notification/add', notification, { root: true })
        setTimeout(() => {
          this.loading = false
          this.$refs['editSubdepartment'].hide()
          this.resetForm()
        }, 2000)
      } catch {
        this.loading = false
      }
    },
    resetForm() {
      this.editedSubdepartment.description = null
      this.editedSubdepartment.department.id = null
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
  },
  watch: {
    editModal(newValue) {
      this.editedSubdepartment = Object.assign({}, newValue)
      this.departmentDescription = newValue.department.description
    }
  }
}
</script>

<style scoped>
label {
  margin-bottom: 0;
}
</style>
