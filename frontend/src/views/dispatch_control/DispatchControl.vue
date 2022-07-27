<template>
  <div>
    <div v-if="listStatus">
      <div class="main-content__top">
        <div class="main-content__title">
          <h4>
            Controle dos Encaminhamentos Realizados no Processo de
            Acompanhamento Familiar
          </h4>
        </div>
      </div>
      <div class="main-content__body">
        <b-container fluid class="bv-example-row pl-0">
          <BreadCrumb />
          <b-row>
            <b-col lg="10" md="9" sm="8" class="pr-0">
              <b-input-group>
                <InputSearch
                  id="searchReferral"
                  v-model="filter"
                  :isValidSearch="null"
                  placeholder="Informe o nome do membro familiar"
                  :maxlength="45"
                  :autofocus="true"
                  @keydown.enter.prevent="getAllReferrals"
                />
                <b-input-group-append is-text class="cursor-pointer">
                  <BaseIcon
                    icon="search"
                    @click.stop="getAllReferrals"
                    :animation="loading ? 'throb' : null"
                  />
                </b-input-group-append>
              </b-input-group>
            </b-col>
            <b-col lg="2" md="3" sm="4" class="text-right">
              <BaseButtonIcon
                type="button"
                id="newReferral"
                buttonName="Novo"
                variant="info"
                icon="plus-circle"
                @click.stop="showNewObject()"
                :to="{ name: 'DispatchControlNew' }"
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
                    name: 'DispatchControlView',
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
      <new-dispatch-control :newObject="newObject" v-model="newStatus">
      </new-dispatch-control>
    </template>
    <template v-if="viewStatus">
      <view-dispatch-control :viewObject="viewObject" v-model="viewStatus">
      </view-dispatch-control>
    </template>
  </div>
</template>

<script>
import NewDispatchControl from './DispatchControlNew'
import ViewDispatchControl from './DispatchControlView'
import pageOperations from '@/mixins/pageOperations'
import EventBus from '@/services/EventBus'

export default {
  name: 'DispatchControl',
  mixins: [pageOperations],
  components: { NewDispatchControl, ViewDispatchControl },
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
    if (to.name !== 'DispatchControl') {
      next({ name: 'DispatchControl', params: { page: 1 } })
    }
    next()
  },
  created() {
    this.getAllReferrals()
  },
  mounted() {
    EventBus.$on(this.$route.meta.eventBus, () => {
      this.newObject = null
      this.listStatus = true
      this.getAllReferrals()
    })
  },
  beforeDestroy() {
    EventBus.$off(this.$route.meta.eventBus)
  },
  methods: {
    getAllReferrals() {
      this.items = null
      setTimeout(() => (this.loading = false), 1000)
      //TODO
    },
    getAllReferralsByFamilyReference() {
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
        this.getAllReferrals()
      }
    },
    items(newValue) {
      if (newValue) {
        this.getAllReferralsByFamilyReference()
      }
    }
  }
}
</script>
