<template :visible="visible">
  <div v-if="object">
    <h4>Membros da Família</h4>
    <b-row>
      <b-col>
        <b-input-group>
          <InputSearch
            id="searchHousehold"
            v-model="filter"
            :isValidSearch="null"
            placeholder="Informe o nome do membro da família"
            :maxlength="45"
            :autofocus="true"
          />
          <b-input-group-append is-text class="cursor-pointer">
            <BaseIcon
              icon="search"
              :variant="null"
              :animation="isBusy ? 'throb' : null"
            />
          </b-input-group-append>
        </b-input-group>
      </b-col>
      <b-col
        lg="2"
        md="3"
        sm="4"
        class="text-right"
        v-if="this.$route.name === 'SimpleServiceRegistryNew'"
      >
        <BaseButtonIcon
          type="button"
          id="newHousehold"
          buttonName="Novo"
          variant="info"
          icon="plus-circle"
          @click.stop="showNewObject()"
        />
      </b-col>
    </b-row>
    <b-table
      responsive
      striped
      hover
      ref="householdTable"
      :show-empty="showEmpty"
      :busy.sync="isBusy"
      :items="getHouseholds"
      :fields="fields"
      :sort-by.sync="sortBy"
      :sort-asc.sync="sortAsc"
      :current-page="currentPage"
      :per-page="perPage"
      :filter="filter"
      head-variant="dark"
      class="mt-3"
    >
      <template v-slot:cell(familyReferenceInteraction)>
        {{ familyReferenceInteractionDescription }}
      </template>
      <template v-slot:cell(dateOfBirth)="data">
        {{ data.item.dateOfBirth | maskDate }}
      </template>
      <template v-slot:cell(remuneration.type)>
        {{ remunerationTypeDescription }}
      </template>
      <template v-slot:cell(actions)="data">
        <b-link @click.stop="showViewObject(data.item)">
          <BaseIcon icon="eye-fill" fontScale="1.4" class="mr-1" />
        </b-link>
        <b-link @click.stop="showEditObject(data.item)">
          <BaseIcon icon="pencil-square" fontScale="1.4" class="ml-1" />
        </b-link>
        <b-link @click.stop="showDeleteObject(data.item)">
          <BaseIcon
            icon="x-square"
            variant="danger"
            fontScale="1.4"
            class="ml-1"
          />
        </b-link>
      </template>
      <template v-slot:empty>
        <h5>Nenhum membro da família encontrado!</h5>
      </template>
      <template v-slot:emptyfiltered>
        <h5>Nenhum membro da família encontrado!</h5>
      </template>
    </b-table>
    <Pagination
      v-model="currentPage"
      :perPage="perPage"
      :totalRows="totalRows"
    />
    <household-collapse
      v-model="newStatus"
      :viewModal="newObject"
      :disabled="false"
    ></household-collapse>
    <household-collapse
      v-model="viewStatus"
      :viewModal="viewObject"
      :disabled="true"
    ></household-collapse>
    <household-collapse
      v-model="editStatus"
      :viewModal="editObject"
      :disabled="false"
    ></household-collapse>
  </div>
</template>

<script>
import HouseholdService from '@/services/HouseholdService'
import HouseholdCollapse from '@/components/collapses/HouseholdCollapse'
import modalOperations from '@/mixins/modalOperations'
import tableConfiguration from '@/mixins/tableConfiguration'
import baseComponent from '@/mixins/baseComponent'
import familyReferenceInteractions from '@/models/familyReferenceInteractions'
import remunerationTypes from '@/models/remunerationTypes'
import EventBus from '@/services/EventBus'

export default {
  name: 'FamilyCompositionTable',
  components: {
    HouseholdCollapse
  },
  mixins: [modalOperations, tableConfiguration, baseComponent],
  data() {
    return {
      familyReferenceInteractions,
      remunerationTypes,
      familyReferenceInteractionDescription: '',
      remunerationTypeDescription: '',
      fields: [
        {
          key: 'fullname',
          label: 'Nome completo',
          class: 'text-center',
          sortable: true,
          sortByFormatted: true,
          filterByFormatted: true
        },
        {
          key: 'familyReferenceInteraction',
          label: 'Vínculo',
          class: 'text-center',
          sortable: true
        },
        {
          key: 'dateOfBirth',
          label: 'Data de Nascimento',
          class: 'text-center'
        },
        { key: 'genre', label: 'Sexo', class: 'text-center', sortable: true },
        {
          key: 'remuneration.type',
          label: 'Profissão',
          class: 'text-center',
          sortable: true
        },
        { key: 'actions', label: 'Ações', class: 'text-center' }
      ],
      sortBy: 'fullname'
    }
  },
  mounted() {
    EventBus.$on('refresh-table-households', () => {
      this.$refs.householdTable.refresh()
    })
  },
  beforeDestroy() {
    EventBus.$off('refresh-table-households')
  },
  methods: {
    async getHouseholds() {
      const response = await HouseholdService.getAll(this.currentPage)
      const { content, totalElements } = response.data

      this.totalRows = totalElements
      this.setFamilyReferenceInteractionAndRemunerationTypeDescriptions(content)
      return content
    },
    setFamilyReferenceInteractionAndRemunerationTypeDescriptions(household) {
      household.forEach(element => {
        for (const frt of this.familyReferenceInteractions) {
          if (element.familyReferenceInteraction === frt.id) {
            this.familyReferenceInteractionDescription = frt.description
          }
        }

        for (const rt of this.remunerationTypes) {
          if (element.remuneration.type === rt.id) {
            this.remunerationTypeDescription = rt.description
          }
        }
      })
    }
  }
}
</script>
