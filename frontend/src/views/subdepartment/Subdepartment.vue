<template>
  <div>
    <div class="main-content__top">
      <div class="main-content__title">
        <h4>Lista de Equipamentos</h4>
      </div>
    </div>
    <div class="main-content__body">
      <b-container fluid class="bv-example-row pl-0">
        <BreadCrumb />
        <b-row>
          <b-col lg="10" md="9" sm="8" class="pr-0">
            <b-input-group>
              <InputSearch
                id="searchSubdepartment"
                v-model="filter"
                :isValidSearch="null"
                placeholder="Informe o nome do equipamento"
                :maxlength="45"
                :autofocus="true"
                @keydown.enter.prevent="getSubdepartments"
              />
              <b-input-group-append is-text class="cursor-pointer">
                <BaseIcon
                  icon="search"
                  @click.stop="getSubdepartments"
                  :animation="isBusy ? 'throb' : null"
                />
              </b-input-group-append>
            </b-input-group>
          </b-col>
          <b-col lg="2" md="3" sm="4" class="text-right">
            <BaseButtonIcon
              type="button"
              id="newSubdepartment"
              buttonName="Novo"
              variant="info"
              icon="plus-circle"
              @click.stop="showNewObject()"
              :to="{ name: 'SubdepartmentNew' }"
            />
          </b-col>
        </b-row>
        <b-table
          responsive
          striped
          hover
          ref="subdepartmentTable"
          :show-empty="showEmpty"
          :busy.sync="isBusy"
          :items="getSubdepartments"
          :fields="fields"
          :sort-by.sync="sortBy"
          :sort-asc.sync="sortAsc"
          :current-page="currentPage"
          :per-page="perPage"
          :filter="filter"
          head-variant="dark"
          class="mt-3"
        >
          <template v-slot:cell(actions)="data">
            <b-link
              @click.stop="showEditObject(data.item)"
              :to="{
                name: 'SubdepartmentEdit',
                params: { id: +data.item.id }
              }"
            >
              <BaseIcon icon="pencil-square" fontScale="1.5" class="ml-1" />
            </b-link>
          </template>
          <template v-slot:empty>
            <h5>Nenhum equipamento encontrado!</h5>
          </template>
          <template v-slot:emptyfiltered>
            <h5>Nenhum usuário encontrado!</h5>
          </template>
          <template v-slot:table-busy>
            <div class="text-center text-danger my-2">
              <b-spinner class="align-middle"></b-spinner>
              <strong> Carregando...</strong>
            </div>
          </template>
        </b-table>
        <Pagination
          v-model="currentPage"
          :perPage="perPage"
          :totalRows="totalRows"
        />
      </b-container>
    </div>
    <new-subdepartment
      v-model="newStatus"
      :departments="departments"
      :lastPage="this.currentPage"
    ></new-subdepartment>
    <edit-subdepartment
      :editModal="editObject"
      v-model="editStatus"
      :departments="departments"
      :lastPage="this.currentPage"
    ></edit-subdepartment>
  </div>
</template>

<script>
import DepartmentService from '@/services/DepartmentService'
import SubdepartmentService from '@/services/SubdepartmentService'
import NewSubdepartment from './SubdepartmentNew'
import EditSubdepartment from './SubdepartmentEdit'
import modalOperations from '@/mixins/modalOperations'
import tableConfiguration from '@/mixins/tableConfiguration'
import EventBus from '@/services/EventBus'

export default {
  name: 'Subdepartment',
  components: {
    NewSubdepartment,
    EditSubdepartment
  },
  mixins: [modalOperations, tableConfiguration],
  data() {
    return {
      departments: [],
      fields: [
        {
          key: 'description',
          label: 'Equipamento',
          class: 'text-center',
          sortable: true,
          sortByFormatted: true,
          filterByFormatted: true
        },
        {
          key: 'department.description',
          label: 'Setor',
          class: 'text-center',
          sortable: true
        },
        { key: 'actions', label: 'Ações', class: 'text-center' }
      ],
      sortBy: 'description'
    }
  },
  beforeRouteEnter(to, from, next) {
    if (to.name !== 'Subdepartment') {
      next({ name: 'Subdepartment', params: { page: 1 } })
    }
    next()
  },
  created() {
    this.getDepartments()
  },
  mounted() {
    EventBus.$on(this.$route.meta.eventBus, () => {
      this.$refs.subdepartmentTable.refresh()
    })
  },
  beforeDestroy() {
    EventBus.$off(this.$route.meta.eventBus)
  },
  methods: {
    async getDepartments() {
      const response = await DepartmentService.getAll()
      this.departments = response.data
    },
    async getSubdepartments() {
      if (this.filter === '') {
        const response = await SubdepartmentService.getAll(this.currentPage)
        const { content, totalElements } = response.data

        this.totalRows = totalElements
        return content
      } else {
        const response = await SubdepartmentService.getBySubdepartment(
          this.filter
        )
        this.totalRows = response.data.length
        return response.data
      }
    }
  },
  watch: {
    currentPage() {
      this.$router.push({
        name: this.$route.name,
        params: { page: this.currentPage }
      })
    }
  }
}
</script>
