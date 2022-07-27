<template>
  <div>
    <div v-if="listStatus">
      <div class="main-content__top">
        <div class="main-content__title">
          <h4>Registro Simplificado dos Atendimentos</h4>
        </div>
      </div>
      <div class="main-content__body">
        <b-container fluid class="bv-example-row pl-0">
          <BreadCrumb />
          <b-row>
            <b-col lg="10" md="9" sm="8" class="pr-0">
              <b-input-group>
                <InputSearch
                  id="searchHousehold"
                  v-model="filter"
                  :isValidSearch="null"
                  placeholder="Informe o nome do membro da família"
                  :maxlength="45"
                  :autofocus="true"
                  @keydown.enter.prevent="getByHousehold"
                />
                <b-input-group-append is-text class="cursor-pointer">
                  <BaseIcon
                    icon="search"
                    @click.stop="getByHousehold"
                    :animation="loading ? 'throb' : null"
                  />
                </b-input-group-append>
              </b-input-group>
            </b-col>
            <b-col lg="2" md="3" sm="4" class="text-right">
              <BaseButtonIcon
                type="button"
                id="newSimpleServiceRegistry"
                buttonName="Novo"
                variant="info"
                icon="plus-circle"
                @click.stop="showNewObject()"
                :to="{ name: 'SimpleServiceRegistryNew' }"
              />
            </b-col>
          </b-row>
          <b-overlay :show="loading" rounded="sm">
            <div v-if="!items">
              <div class="mt-2">
                <h5>Nenhum registro encontrado!</h5>
              </div>
            </div>
            <template v-else>
              <b-list-group class="mt-2">
                <b-list-group-item
                  v-for="item in items"
                  :key="item.id"
                  class="flex-column align-items-start mt-1"
                  @click.stop.once="showViewObject(item)"
                  :to="{
                    name: 'SimpleServiceRegistryView',
                    params: { id: +item.id }
                  }"
                >
                  <div class="d-flex w-100 justify-content-between">
                    <h5 class="mb-1 font-weight-bold">
                      {{ item.fullnameHousehold }}
                    </h5>
                    <small>{{ item.interviewDate | maskDate }}</small>
                  </div>
                  <p class="mb-1">
                    {{ item.dateOfBirth | maskDate }} - {{ item.genre }} -
                    {{ maritalStatusDescription }}
                    {{ workInformationDescription }}
                  </p>
                  <small
                    >{{ item.description }} - {{ item.fullnameUser }}</small
                  >
                </b-list-group-item>
              </b-list-group>
            </template>
          </b-overlay>
          <Pagination
            v-model="currentPage"
            :perPage="perPage"
            :totalRows="totalRows"
            :minRows="perPage"
          />
        </b-container>
      </div>
    </div>
    <template v-if="newStatus">
      <new-simple-service-registry
        :newObject="newObject"
        v-model="newStatus"
      ></new-simple-service-registry>
    </template>
    <template v-if="viewStatus">
      <view-simple-service-registry
        :viewObject="viewObject"
        v-model="viewStatus"
      ></view-simple-service-registry>
    </template>
  </div>
</template>

<script>
import SimpleServiceRegistryService from '@/services/SimpleServiceRegistryService'
import pageOperations from '@/mixins/pageOperations'
import maritalStatus from '@/models/maritalStatus'
import NewSimpleServiceRegistry from './SimpleServiceRegistryNew'
import ViewSimpleServiceRegistry from './SimpleServiceRegistryView'
import EventBus from '@/services/EventBus'

export default {
  name: 'SimpleServiceRegistry',
  components: {
    NewSimpleServiceRegistry,
    ViewSimpleServiceRegistry
  },
  mixins: [pageOperations],
  data() {
    return {
      maritalStatus,
      filter: '',
      loading: true,
      currentPage: 1,
      perPage: 5,
      totalRows: null,
      items: [],
      maritalStatusDescription: '',
      workInformationDescription: ''
    }
  },
  beforeRouteEnter(to, from, next) {
    if (to.name !== 'SimpleServiceRegistry') {
      next({ name: 'SimpleServiceRegistry', params: { page: 1 } })
    }
    next()
  },
  created() {
    this.getSingleRegistriesIdentification()
  },
  mounted() {
    EventBus.$on(this.$route.meta.eventBus, () => {
      this.newObject = null
      this.viewObject = null
      this.listStatus = true
      this.getSingleRegistriesIdentification()
    })
  },
  beforeDestroy() {
    EventBus.$off(this.$route.meta.eventBus)
  },
  methods: {
    async getSingleRegistriesIdentification() {
      this.loading = true
      const response = await SimpleServiceRegistryService.getAll(
        this.currentPage
      )
      const { content, totalElements } = response.data

      this.items = content
      this.totalRows = totalElements
      setTimeout(() => (this.loading = false), 1000)
    },
    async getByHousehold() {
      this.loading = true
      const response = await SimpleServiceRegistryService.getByHousehold(
        this.filter
      )
      const { content, totalElements } = response.data

      this.items = content
      this.totalRows = totalElements
      setTimeout(() => (this.loading = false), 1000)
    },
    setMaritalStatusDescriptionAndWorkInformationDescription() {
      this.items.forEach(element => {
        for (const i of this.maritalStatus) {
          if (element.maritalStatus === i.id) {
            this.maritalStatusDescription = i.description
          }
        }

        if (element.retired === 2) {
          this.workInformationDescription = ' - Aposentado'
        }
      })
    }
  },
  watch: {
    currentPage(newValue) {
      this.getSingleRegistriesIdentification()
      this.$router.push({
        name: this.$route.name,
        params: { page: newValue }
      })
    },
    filter(newValue) {
      if (newValue === '') {
        this.getSingleRegistriesIdentification()
      }
    },
    items(newValue) {
      if (newValue) {
        this.setMaritalStatusDescriptionAndWorkInformationDescription()
      }
    }
  }
}
</script>
