<template>
  <div v-if="object" role="tablist">
    <b-card
      v-for="item in simplifiedServiceItems"
      :key="item.id"
      no-body
      class="mb-1"
    >
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block v-b-toggle="`accordion-'${item.id}`" variant="dark">
          {{ item.title }}
        </b-button>
      </b-card-header>
      <b-collapse
        :id="`accordion-'${String(item.id)}`"
        accordion="simplified-service"
        role="tabpanel"
        :visible="item.visible"
      >
        <b-card-body>
          <div v-if="item.id === 1">
            <FamilyReferenceIdentificationForm
              :object="object"
              :visible="true"
              :disabled="disabled"
            />
          </div>
          <template v-else-if="item.id === 2">
            <FamilyAddressForm
              :object="object"
              :visible="true"
              :disabled="disabled"
            />
          </template>
          <template v-else-if="item.id === 3">
            <WorkInformationForm
              :object="object"
              :visible="true"
              :disabled="disabled"
            />
          </template>
          <template v-else-if="item.id === 4">
            <SingleRegistryForm
              :object="object"
              :visible="true"
              :disabled="disabled"
            />
          </template>
          <template v-else-if="item.id === 5">
            <PropertyCharacteristicSimplifiedForm
              :object="object"
              :visible="true"
              :disabled="disabled"
            />
          </template>
          <template v-else-if="item.id === 6">
            <FamilyCompositionTable
              :object="object"
              :visible="true"
              :disabled="disabled"
            />
          </template>
          <template v-else-if="item.id === 7">
            <SocialProgramsForm
              :object="object"
              :visible="true"
              :disabled="disabled"
            />
          </template>
          <template v-else-if="item.id === 8">
            <HealthConditionForm
              :object="object"
              :visible="true"
              :disabled="disabled"
            />
          </template>
          <template v-else-if="item.id === 9">
            <ServiceReportForm
              :object="object"
              :visible="true"
              :disabled="disabled"
            />
          </template>
        </b-card-body>
      </b-collapse>
    </b-card>
  </div>
</template>

<script>
import collapse from '@/mixins/collapse'
import simplifiedServiceItems from '@/models/simplifiedServiceItems'

export default {
  name: 'FamilyInformationCollapse',
  mixins: [collapse],
  data() {
    return {
      simplifiedServiceItems
    }
  }
}
</script>
