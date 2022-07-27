<template>
  <div>
    <div v-if="listStatus">
      <div class="main-content__top">
        <div class="main-content__title">
          <h4>Planejamento e Evolução do Acompanhamento Familiar</h4>
        </div>
      </div>
      <div class="main-content__body">
        <b-container fluid class="bv-example-row pl-0">
          <BreadCrumb />
          <b-row>
            <b-col lg="10" md="9" sm="8" class="pr-0">
              <b-input-group>
                <InputSearch
                  id="searchMonitoring"
                  v-model="filter"
                  :isValidSearch="null"
                  placeholder="Informe o nome do membro familiar"
                  :maxlength="45"
                  :autofocus="true"
                  @keydown.enter.prevent="getAllMonitoring"
                />
                <b-input-group-append is-text class="cursor-pointer">
                  <BaseIcon
                    icon="search"
                    @click.stop="getAllMonitoring"
                    :animation="loading ? 'throb' : null"
                  />
                </b-input-group-append>
              </b-input-group>
            </b-col>
            <b-col lg="2" md="3" sm="4" class="text-right">
              <BaseButtonIcon
                type="button"
                id="newMonitoring"
                buttonName="Novo"
                variant="info"
                icon="plus-circle"
                @click.stop="showNewObject()"
                :to="{ name: 'MonitoringNew' }"
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
                    name: 'MonitoringView',
                    params: { id: +item.id }
                  }"
                >
                  <!-- TODO -->
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
      <new-monitoring :newObject="newObject" v-model="newStatus">
      </new-monitoring>
    </template>
    <template v-if="viewStatus">
      <view-monitoring :viewObject="viewObject" v-model="viewStatus">
      </view-monitoring>
    </template>
  </div>
</template>

<script>
import NewMonitoring from './MonitoringNew'
import ViewMonitoring from './MonitoringView'
import pageOperations from '@/mixins/pageOperations'
import EventBus from '@/services/EventBus'

export default {
  name: 'Monitoring',
  mixins: [pageOperations],
  components: { NewMonitoring, ViewMonitoring },
  data() {
    return {
      loading: true,
      filter: '',
      currentPage: 1,
      perPage: 5,
      totalRows: null,
      items: []
    }
  },
  beforeRouteEnter(to, from, next) {
    if (to.name !== 'Monitoring') {
      next({ name: 'Monitoring', params: { page: 1 } })
    }
    next()
  },
  created() {
    this.getAllMonitoring()
  },
  mounted() {
    EventBus.$on(this.$route.meta.eventBus, () => {
      this.newObject = null
      this.listStatus = true
      this.getAllMonitoring()
    })
  },
  beforeDestroy() {
    EventBus.$off(this.$route.meta.eventBus)
  },
  methods: {
    getAllMonitoring() {
      this.items = null
      setTimeout(() => (this.loading = false), 1000)
      //TODO
    },
    getAllMonitoringByFamilyReference() {
      //TODO
    }
  },
  watch: {
    currentPage() {
      this.$router.push({
        name: this.$route.name,
        params: { page: this.currentPage }
      })
    },
    filter(newValue) {
      if (newValue === '') {
        this.getAllMonitoring()
      }
    },
    items(newValue) {
      if (newValue) {
        this.getAllMonitoringByFamilyReference()
      }
    }
  }
}
</script>
