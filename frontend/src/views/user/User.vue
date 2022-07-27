<template>
  <div>
    <div class="main-content__top">
      <div class="main-content__title">
        <h4>Lista de Usuários</h4>
      </div>
    </div>
    <div class="main-content__body">
      <b-container fluid class="bv-example-row pl-0">
        <BreadCrumb />
        <b-row>
          <b-col lg="10" md="9" sm="8" class="pr-0">
            <b-input-group>
              <InputSearch
                id="searchUser"
                v-model="filter"
                :isValidSearch="null"
                placeholder="Informe o nome do usuário"
                :maxlength="45"
                :autofocus="true"
                @keydown.enter.prevent="getUsers"
              />
              <b-input-group-append is-text class="cursor-pointer">
                <BaseIcon
                  icon="search"
                  @click.stop="getUsers"
                  :animation="isBusy ? 'throb' : null"
                />
              </b-input-group-append>
            </b-input-group>
          </b-col>
          <b-col lg="2" md="3" sm="4" class="text-right">
            <BaseButtonIcon
              type="button"
              id="newUser"
              buttonName="Novo"
              variant="info"
              icon="plus-circle"
              @click.stop="showNewObject()"
              :to="{ name: 'UserNew' }"
            />
          </b-col>
        </b-row>
        <b-table
          responsive
          striped
          ref="userTable"
          hover
          :show-empty="showEmpty"
          :busy.sync="isBusy"
          :items="getUsers"
          :fields="fields"
          :sort-by.sync="sortBy"
          :sort-asc.sync="sortAsc"
          :current-page="currentPage"
          :per-page="perPage"
          :filter="filter"
          head-variant="dark"
          class="mt-3"
        >
          <template v-slot:cell(cpf)="data">
            {{ data.item.cpf | maskCpf }}
          </template>
          <template v-slot:cell(status)="data">
            <div v-if="data.item.status === 1">
              <BaseIcon icon="circle-fill" variant="success" fontScale="1.25" />
            </div>
            <template v-else>
              <BaseIcon icon="circle-fill" variant="danger" fontScale="1.25" />
            </template>
          </template>
          <template v-slot:cell(actions)="data">
            <b-link
              @click.stop="showViewObject(data.item)"
              :to="{ name: 'UserView', params: { id: +data.item.id } }"
            >
              <BaseIcon icon="eye-fill" fontScale="1.5" class="mr-1" />
            </b-link>
            <b-link
              @click.stop="showEditObject(data.item)"
              :to="{ name: 'UserEdit', params: { id: +data.item.id } }"
            >
              <BaseIcon icon="pencil-square" fontScale="1.5" class="ml-1" />
            </b-link>
          </template>
          <template v-slot:empty>
            <h5>Nenhum usuário encontrado!</h5>
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
    <new-user
      v-model="newStatus"
      :profiles="profiles"
      :lastPage="this.currentPage"
    ></new-user>
    <view-user
      :viewModal="viewObject"
      v-model="viewStatus"
      :lastPage="this.currentPage"
    ></view-user>
    <edit-user
      :editModal="editObject"
      v-model="editStatus"
      :profiles="profiles"
      :lastPage="this.currentPage"
    ></edit-user>
  </div>
</template>

<script>
import ProfileService from '@/services/ProfileService'
import UserService from '@/services/UserService'
import NewUser from './UserNew'
import ViewUser from './UserView'
import EditUser from './UserEdit'
import modalOperations from '@/mixins/modalOperations'
import tableConfiguration from '@/mixins/tableConfiguration'
import EventBus from '@/services/EventBus'

export default {
  name: 'User',
  components: {
    NewUser,
    ViewUser,
    EditUser
  },
  mixins: [modalOperations, tableConfiguration],
  data() {
    return {
      loading: true,
      profiles: [],
      fields: [
        {
          key: 'fullname',
          label: 'Nome completo',
          class: 'text-center',
          sortable: true,
          sortByFormatted: true,
          filterByFormatted: true
        },
        { key: 'email', label: 'E-mail', class: 'text-center', sortable: true },
        { key: 'cpf', label: 'CPF', class: 'text-center' },
        {
          key: 'status',
          label: 'Status',
          class: 'text-center',
          sortable: true
        },
        {
          key: 'profile.description',
          label: 'Perfil',
          class: 'text-center',
          sortable: true
        },
        { key: 'actions', label: 'Ações', class: 'text-center' }
      ],
      sortBy: 'fullname'
    }
  },
  beforeRouteEnter(to, from, next) {
    if (to.name !== 'User') {
      next({ name: 'User', params: { page: 1 } })
    }
    next()
  },
  created() {
    this.getProfiles()
  },
  mounted() {
    EventBus.$on(this.$route.meta.eventBus, () => {
      this.$refs.userTable.refresh()
    })
  },
  beforeDestroy() {
    EventBus.$off(this.$route.meta.eventBus)
  },
  methods: {
    async getProfiles() {
      const response = await ProfileService.getAll()
      this.profiles = response.data
    },
    async getUsers() {
      if (this.filter === '') {
        const response = await UserService.getAll(this.currentPage)
        const { content, totalElements } = response.data

        this.totalRows = totalElements
        return content
      } else {
        const response = await UserService.getByUser(this.filter)
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
