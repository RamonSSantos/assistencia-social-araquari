<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="4" sm="8">
        <BaseRadio
          id="propertySituation"
          label="Tipo de Residência:"
          v-model="object.propertySituation"
          :radio="propertySituationsDetailed"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="4" sm="4">
        <div v-if="object.propertySituation === 6">
          <InputText
            id="propertySituationDescription"
            label="Outra:"
            v-model="object.propertySituationDescription"
            placeholder="Descrição"
            :maxlength="45"
            :minlength="4"
            :required="true"
            :disabled="disabled"
          />
        </div>
      </b-col>
      <b-col lg="4" sm="12">
        <BaseTextarea
          id="propertyObservation"
          label="Observação:"
          v-model="object.propertyObservation"
          placeholder="Observação"
          :required="false"
          :disabled="disabled"
          :maxlength="150"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="4" sm="8">
        <BaseRadio
          id="buildingCharacteristic"
          label="Características da Construção:"
          v-model="object.buildingCharacteristic"
          :radio="buildingCharacteristics"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="4" sm="4">
        <div v-if="object.buildingCharacteristic === 4">
          <InputText
            id="buildingCharacteristicDescription"
            label="Outra:"
            v-model="object.buildingCharacteristicDescription"
            placeholder="Descrição"
            :maxlength="45"
            :minlength="4"
            :required="true"
            :disabled="disabled"
          />
        </div>
      </b-col>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="electricity"
          label="Energia Elétrica:"
          v-model="object.electricity"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
        <div v-if="object.electricity === 1">
          <InputMoney
            id="electricityPrice"
            label="Valor:"
            v-model="object.electricityPrice"
            :required="true"
            :maxlength="9"
            :disabled="disabled"
          />
        </div>
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="4" sm="8">
        <BaseRadio
          id="waterSupply"
          label="Forma de Abastecimento de Água:"
          v-model="object.waterSupply"
          :radio="waterSupplySystemsSimplified"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="4" sm="4">
        <InputMoney
          id="waterSupplyPrice"
          label="Valor:"
          v-model="object.waterSupplyPrice"
          :required="true"
          :maxlength="9"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="4" sm="12">
        <BaseTextarea
          id="buildingObservation"
          label="Observação:"
          v-model="object.buildingObservation"
          placeholder="Observação"
          :required="false"
          :disabled="disabled"
          :maxlength="150"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <BaseRadio
          id="riskAreaFlood"
          label="O domicílio está localizado em área de risco de desabamento ou alagamento?"
          v-model="object.riskAreaFlood"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import { propertySituationsDetailed } from '@/models/propertySituations'
import buildingCharacteristics from '@/models/buildingCharacteristics'
import singleAnswers from '@/models/singleAnswers'
import { waterSupplySystemsSimplified } from '@/models/waterSupplySystems'

export default {
  name: 'PropertyCharacteristicSimplifiedForm',
  mixins: [baseComponent],
  data() {
    return {
      propertySituationsDetailed,
      buildingCharacteristics,
      singleAnswers,
      waterSupplySystemsSimplified
    }
  }
}
</script>
