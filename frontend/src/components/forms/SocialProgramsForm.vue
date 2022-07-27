<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="3" sm="6">
        <BaseRadio
          id="bolsaFamiliaProgramme"
          label="Beneficiário PBF:"
          v-model="object.programType1"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
        <div v-if="object.programType1 === 1">
          <InputMoney
            id="bolsaFamiliaProgrammeValueReceived"
            label="Valor:"
            v-model="object.receivedValue1"
            :required="true"
            :maxlength="9"
            :disabled="disabled"
          />
        </div>
      </b-col>
      <b-col lg="3" sm="6">
        <BaseRadio
          id="continuousCashBenefit"
          label="Beneficiário BPC:"
          v-model="object.continuousCashBenefit"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="3" sm="6">
        <InputMoney
          id="familyGrossSalarySocialProgram"
          label="Renda total da família:"
          v-model="object.familyGrossSalarySocialProgram"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="3" sm="6">
        <InputMoney
          id="perCapitaIncome"
          label="Renda familiar per capita:"
          v-model="object.perCapitaIncome"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import singleAnswers from '@/models/singleAnswers'

export default {
  name: 'SocialProgramsForm',
  mixins: [baseComponent],
  data() {
    return {
      singleAnswers
    }
  }
}
</script>
