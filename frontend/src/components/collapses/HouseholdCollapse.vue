<template>
  <b-modal
    ref="household"
    v-bind="$attrs"
    :visible="visible"
    title="Membro da Família"
    size="lg"
    @hidden="hideModal"
    @change="changeModal"
    hide-footer
  >
    <div v-if="viewModal" role="tablist">
      <b-card
        v-for="item in householdInformations"
        :key="item.id"
        no-body
        class="mb-1"
      >
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block v-b-toggle="`accordion-'${item.id}`" variant="dark">{{
            item.title
          }}</b-button>
        </b-card-header>
        <b-collapse
          :id="`accordion-'${String(item.id)}`"
          accordion="simplified-service"
          role="tabpanel"
          :visible="item.visible"
        >
          <b-card-body>
            <div v-if="item.id === 1">
              <HouseholdIdentificationForm
                :object="object"
                :visible="true"
                :disabled="disabled"
              />
            </div>
            <template v-else-if="item.id === 2">
              <HouseholdCivilDocumentationForm
                :object="object"
                :visible="true"
                :disabled="disabled"
              />
            </template>
            <template v-else-if="item.id === 3">
              <HouseholdWorkInformationForm
                :object="object"
                :visible="true"
                :disabled="disabled"
              />
            </template>
            <template v-else-if="item.id === 4">
              <HouseholdRemunerationForm
                :object="object"
                :visible="true"
                :disabled="disabled"
              />
            </template>
            <template v-else-if="item.id === 5">
              <HouseholdEducationalInformationForm
                :object="object"
                :visible="visible"
                :disabled="disabled"
              />
            </template>
            <template v-else-if="item.id === 6">
              <HouseholdHealthConditionForm
                :object="object"
                :visible="visible"
                :disabled="disabled"
              />
            </template>
          </b-card-body>
        </b-collapse>
      </b-card>
    </div>
  </b-modal>
</template>

<script>
import modalVisibility from '@/mixins/modalVisibility'
import householdInformations from '@/models/householdInformations'
import EventBus from '@/services/EventBus'

export default {
  name: 'HouseholdCollapse',
  mixins: [modalVisibility],
  props: {
    disabled: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      householdInformations,
      object: []
    }
  },
  methods: {
    hideModal() {
      EventBus.$emit('refresh-table-households')
    }
  },
  watch: {
    viewModal(newValue) {
      this.object = Object.assign({}, newValue)
    }
  }
}
</script>
