<template>
  <div>
    <div v-if="listStatus">
      <div class="main-content__top">
        <div class="main-content__title">
          <h4>Lista de Referências Familiares</h4>
        </div>
      </div>
      <div class="main-content__body">
        <b-container fluid class="bv-example-row pl-0">
          <BreadCrumb />
          <b-row>
            <b-col>
              <b-input-group>
                <InputSearch
                  id="searchFamilyReference"
                  v-model="filter"
                  :isValidSearch="null"
                  placeholder="Informe o nome da referência familiar"
                  :maxlength="45"
                  :autofocus="true"
                  @keydown.enter.prevent="getFamilyReferences"
                />
                <b-input-group-append is-text class="cursor-pointer">
                  <BaseIcon
                    icon="search"
                    @click.stop="getFamilyReferences"
                    :animation="isBusy ? 'throb' : null"
                  />
                </b-input-group-append>
              </b-input-group>
            </b-col>
          </b-row>
          <b-table
            responsive
            striped
            hover
            :show-empty="showEmpty"
            :busy.sync="isBusy"
            :items="getFamilyReferences"
            :fields="fields"
            :sort-by.sync="sortBy"
            :sort-asc.sync="sortAsc"
            :current-page="currentPage"
            :per-page="perPage"
            :filter="filter"
            head-variant="dark"
            class="mt-3"
          >
            <template v-slot:cell(remuneration.type)>
              {{ workInformationDescription }}
            </template>
            <template v-slot:cell(civilDocumentation.maritalStatus)>
              {{ maritalStatusDescription }}
            </template>
            <template v-slot:cell(dateOfBirth)="data">
              {{ data.item.dateOfBirth | maskDate }}
            </template>
            <template v-slot:cell(actions)="data">
              <b-link
                @click.stop.once="showViewObject(data.item)"
                :to="{
                  name: 'FamilyReferenceView',
                  params: { id: +data.item.id }
                }"
              >
                <BaseIcon icon="eye-fill" fontScale="1.5" class="mr-1" />
              </b-link>
              <b-link
                @click.stop.once="showEditObject(data.item)"
                :to="{
                  name: 'FamilyReferenceEdit',
                  params: { id: +data.item.id }
                }"
              >
                <BaseIcon icon="pencil-square" fontScale="1.5" class="ml-1" />
              </b-link>
            </template>
            <template v-slot:empty>
              <h5>Nenhuma referência familiar encontrada!</h5>
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
    </div>
    <template v-if="viewStatus">
      <view-family-reference
        :viewObject="viewObject"
        v-model="viewStatus"
      ></view-family-reference>
    </template>
    <template v-if="editStatus">
      <edit-family-reference
        :editObject="editObject"
        v-model="editStatus"
      ></edit-family-reference>
    </template>
  </div>
</template>

<script>
import HouseholdService from '@/services/HouseholdService'
import pageOperations from '@/mixins/pageOperations'
import tableConfiguration from '@/mixins/tableConfiguration'
import races from '@/models/races'
import maritalStatus from '@/models/maritalStatus'
import remunerationTypes from '@/models/remunerationTypes'
import ViewFamilyReference from './FamilyReferenceView'
import EditFamilyReference from './FamilyReferenceEdit'
import EventBus from '@/services/EventBus'

export default {
  name: 'FamilyReference',
  components: {
    ViewFamilyReference,
    EditFamilyReference
  },
  mixins: [pageOperations, tableConfiguration],
  data() {
    return {
      loading: true,
      races,
      raceValue: null,
      maritalStatus,
      maritalStatusDescription: '',
      remunerationTypes,
      workInformationDescription: '',
      fields: [
        {
          key: 'fullname',
          label: 'Referência Familiar',
          class: 'text-center',
          sortable: true,
          sortByFormatted: true,
          filterByFormatted: true
        },
        {
          key: 'remuneration.type',
          label: 'Ocupação',
          class: 'text-center',
          sortable: true
        },
        {
          key: 'civilDocumentation.maritalStatus',
          label: 'Estado Civil',
          class: 'text-center',
          sortable: false
        },
        {
          key: 'dateOfBirth',
          label: 'Data de Nascimento',
          class: 'text-center',
          sortable: false
        },
        {
          key: 'genre',
          label: 'Sexo',
          class: 'text-center',
          sortable: true
        },
        { key: 'actions', label: 'Ações', class: 'text-center' }
      ],
      sortBy: 'fullname'
    }
  },
  beforeRouteEnter(to, from, next) {
    if (to.name !== 'FamilyReference') {
      next({ name: 'FamilyReference', params: { page: 1 } })
    }
    next()
  },
  mounted() {
    EventBus.$on(this.$route.meta.eventBus, () => {
      this.viewObject = null
      this.editObject = null
      this.listStatus = true
    })
  },
  beforeDestroy() {
    EventBus.$off(this.$route.meta.eventBus)
  },
  methods: {
    async getFamilyReferences() {
      if (this.filter === '') {
        const response = await HouseholdService.getAll(this.currentPage)
        const { content, totalElements } = response.data

        this.totalRows = totalElements
        this.setMaritalStatusDescriptionAndWorkInformationDescription(content)
        return content
      } else {
        const response = await HouseholdService.getByFamilyReferenceName(
          this.filter
        )

        this.totalRows = response.data.length
        this.setMaritalStatusDescriptionAndWorkInformationDescription(
          response.data
        )
        return response.data
      }
    },
    setMaritalStatusDescriptionAndWorkInformationDescription(household) {
      household.forEach(element => {
        for (const ms of this.maritalStatus) {
          if (element.civilDocumentation.maritalStatus === ms.id) {
            this.maritalStatusDescription = ms.description
          }
        }

        for (const wf of this.remunerationTypes) {
          if (element.remuneration.type === wf.id) {
            this.workInformationDescription = wf.description
          }
        }
      })
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
