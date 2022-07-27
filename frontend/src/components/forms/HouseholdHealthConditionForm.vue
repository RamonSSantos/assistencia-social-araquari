<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col>
        <BaseRadio
          id="householdHasDisability"
          label="Tem alguma deficiência permanente que limite as suas atividades habituais (como trabalhar, ir à escola, brincar, etc.)?"
          v-model="object.householdHasDisability"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row v-if="object.householdHasDisability === 1">
      <b-col>
        <BaseCheckbox
          id="householdDisabilityType"
          label="Tipo de deficiência: (Esta opção admite múltiplas opções)"
          v-model="householdHasDisabilityType"
          :checkbox="disabilityTypes"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row v-if="householdHasDisabilityType.length > 0">
      <b-col>
        <BaseCheckbox
          id="householdConstantCare"
          label="Em função dessa deficiência recebe cuidados permanentes de terceiros? (Esta opção admite múltiplas opções)"
          v-model="object.householdConstantCare"
          :checkbox="constantCareTypes"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="householdSeriousIllness"
          label="É portador de alguma doença grave?"
          v-model="object.householdSeriousIllness"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="householdPrescriptionMedication"
          label="Faz uso de remédios controlados (tarja preta) para transtornos mentais?"
          v-model="object.householdPrescriptionMedication"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="householdAlcoholic"
          label="Faz uso abusivo de álcool?"
          v-model="object.householdAlcoholic"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="householdDrugAddict"
          label="Faz uso abusivo de crack ou outras drogas (cocaína, maconha, etc)?"
          v-model="object.householdDrugAddict"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import singleAnswers from '@/models/singleAnswers'
import disabilityTypes from '@/models/disabilityTypes'
import constantCareTypes from '@/models/constantCareTypes'

export default {
  name: 'HouseholdHealthConditionForm',
  mixins: [baseComponent],
  data() {
    return {
      singleAnswers,
      disabilityTypes,
      constantCareTypes,
      householdHasDisabilityType: []
    }
  }
}
</script>
