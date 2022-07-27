<template :visible="visible">
  <b-form v-if="object">
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="ageProfileOfFamilyGroup"
        label="Perfil Etário do Grupo Familiar"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col xl="3" sm="6">
            <InputNumber
              id="ageProfileOfFamilyZeroToSix"
              label="Pessoas de 0 a 6 anos"
              v-model="ageProfileOfFamily.zeroToSix"
              placeholder="Qtd. de Pessoas:"
              :maxlength="2"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col xl="3" sm="6">
            <InputNumber
              id="sevenToFourteen"
              label="Pessoas de 7 a 14 anos"
              v-model="ageProfileOfFamily.sevenToFourteen"
              placeholder="Qtd. de Pessoas:"
              :maxlength="2"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col xl="3" sm="6">
            <InputNumber
              id="ageProfileOfFamilyFifteenToSeventeen"
              label="Pessoas de 15 a 17 anos"
              v-model="ageProfileOfFamily.fifteenToSeventeen"
              placeholder="Qtd. de Pessoas:"
              :maxlength="2"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col xl="3" sm="6">
            <InputNumber
              id="eighteenToTwentyNine"
              label="Pessoas de 18 a 29 anos"
              v-model="ageProfileOfFamily.eighteenToTwentyNine"
              placeholder="Qtd. de Pessoas:"
              :maxlength="2"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col xl="3" sm="6">
            <InputNumber
              id="thirtyToFiftyNine"
              label="Pessoas de 30 a 59 anos"
              v-model="ageProfileOfFamily.thirtyToFiftyNine"
              placeholder="Qtd. de Pessoas:"
              :maxlength="2"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col xl="3" sm="6">
            <InputNumber
              id="sixtyToSixtyFour"
              label="Pessoas de 60 a 64 anos"
              v-model="ageProfileOfFamily.sixtyToSixtyFour"
              placeholder="Qtd. de Pessoas:"
              :maxlength="2"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col xl="3" sm="6">
            <InputNumber
              id="sixtyFiveToSixtyNine"
              label="Pessoas de 65 a 69 anos"
              v-model="ageProfileOfFamily.sixtyFiveToSixtyNine"
              placeholder="Qtd. de Pessoas:"
              :maxlength="2"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col xl="3" sm="6">
            <InputNumber
              id="seventyToPlus"
              label="Pessoas com 70 anos ou mais"
              v-model="ageProfileOfFamily.seventyToPlus"
              placeholder="Qtd. de Pessoas:"
              :maxlength="2"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'

export default {
  name: 'AgeProfileOfFamilyForm',
  mixins: [baseComponent],
  data() {
    return {
      ageProfileOfFamily: {
        zeroToSix: null,
        sevenToFourteen: null,
        fifteenToSeventeen: null,
        eighteenToTwentyNine: null,
        thirtyToFiftyNine: null,
        sixtyToSixtyFour: null,
        sixtyFiveToSixtyNine: null,
        seventyToPlus: null
      }
    }
  }
}
</script>
