<template>
  <div v-if="tabs">
    <b-tabs v-model="tabIndex" active-nav-item-class="font-weight-bold" card>
      <b-tab v-for="tab in tabs" :key="tab.id" :title="tab.title">
        <div v-if="tab.id === 1">
          <FamilyReferenceIdentificationForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </div>
        <template v-else-if="tab.id === 2">
          <FamilyAddressForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 3">
          <WorkInformationForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 4">
          <SingleRegistryForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 5">
          <PropertyCharacteristicSimplifiedForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 6">
          <FamilyCompositionTable
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 7">
          <SocialProgramsForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 8">
          <HealthConditionForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 9">
          <ServiceReportForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
      </b-tab>
    </b-tabs>
    <div class="text-center">
      <b-button-group class="mt-2">
        <BaseButton
          type="button"
          id="back"
          buttonName="Voltar"
          variant="secondary"
          @click="tabIndex--"
          :disabled="stateButtonBack"
          class="mr-1"
        />
        <BaseButton
          type="button"
          id="next"
          :buttonName="buttonName"
          :variant="variant"
          @click="tabIndex++"
          class="ml-1"
        />
      </b-button-group>
    </div>
  </div>
</template>

<script>
import tabs from '@/mixins/tabs'

export default {
  name: 'SimplifiedServiceTab',
  mixins: [tabs]
}
</script>
