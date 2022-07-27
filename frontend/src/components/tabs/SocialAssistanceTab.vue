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
          <FamilyAddressDetailedForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 3">
          <FirstInterviewReasonForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 4">
          <FamilyCompositionTable
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
          <AgeProfileOfFamilyForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
          <FamilySpecificityForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 5">
          <PropertyCharacteristicForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 6">
          <EducationalVulnerabilityIdentificationForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
          <BolsaFamiliaProgrammeEducationForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 7">
          <FamilyIncomeForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 8">
          <FamilyHealthConditionForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
          <BolsaFamiliaProgrammeHealthForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 9">
          <AccessToEventualBenefitForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 10">
          <FamilyAndCommunityLivingForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 11">
          <ParticipationInSocialProgramsForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 12">
          <HistoricalOfViolenceSituationForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
          <MonitoringSocialAssistanceReferenceCentresForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
          <ViolenceSituationIdentifiedForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 13">
          <HistoricalOfCorrectionalMeasuresForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 14">
          <HistoricalOfFamilyBasedCareForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 15">
          <PlanningAndProgressOfFamilyMonitoringForm
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
  name: 'SocialAssistanceTab',
  mixins: [tabs]
}
</script>
