<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="propertySituation"
          label="Tipo de residencia:"
          v-model="object.propertySituation"
          :radio="propertySituations"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="outsideWallCharacteristic"
          label="Material das paredes externas do domicílio:"
          v-model="object.outsideWallCharacteristic"
          :radio="outsideWallCharacteristics"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="electricity"
          label="Acesso a energia elétrica:"
          v-model="object.electricity"
          :radio="electricityTypes"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="hasWaterSupply"
          label="Possui água canalizada:"
          v-model="hasWaterSupply"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
        <div v-if="hasWaterSupply === 1">
          <BaseRadio
            id="waterSupply"
            label="Forma de abastecimento de água:"
            v-model="object.waterSupply"
            :radio="waterSupplySystems"
            :required="true"
            :disabled="disabled"
            :selected="0"
          />
        </div>
      </b-col>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="sanitarySewer"
          label="Escoamento sanitário:"
          v-model="object.sanitarySewer"
          :radio="sanitarySewerTypes"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="garbageCollection"
          label="Coleta de lixo:"
          v-model="object.garbageCollection"
          :radio="garbageCollectionTypes"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="4" sm="12">
        <InputNumber
          id="rooms"
          label="Qual o número total de cômodos do domicílio?"
          v-model="object.rooms"
          placeholder="Número"
          :maxlength="2"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="4" sm="12">
        <InputNumber
          id="bedrooms"
          label="Qual o número de cômodos utilizados como dormitório?"
          v-model="object.bedrooms"
          placeholder="Número"
          :maxlength="2"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="4" sm="12">
        <InputNumber
          id="averagePeoplePerBedroom"
          label="Qual o nº de pessoas do domicílio dividido pelo nº de dormitórios?"
          v-model="averagePeoplePerBedroom"
          placeholder="Número"
          :maxlength="2"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="8" sm="12">
        <BaseRadio
          id="accessibility"
          label="O domicílio possue acessibilidade para pessoas com dificuldades de locomoção?"
          v-model="object.accessibility"
          :radio="accessibilityTypes"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="4" sm="12">
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
      <b-col lg="6" sm="12">
        <BaseRadio
          id="riskAreaGeographic"
          label="O domicílio está localizado em área de difícil acesso geográfico?"
          v-model="object.riskAreaGeographic"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="riskAreaConflict"
          label="O domicílio está localizado em área com forte presença de conflito/violência?"
          v-model="object.riskAreaConflict"
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
import { propertySituations } from '@/models/propertySituations'
import { outsideWallCharacteristics } from '@/models/outsideWallCharacteristics'
import { electricityTypes } from '@/models/electricityTypes'
import singleAnswers from '@/models/singleAnswers'
import { waterSupplySystems } from '@/models/waterSupplySystems'
import { sanitarySewerTypes } from '@/models/sanitarySewerTypes'
import { garbageCollectionTypes } from '@/models/garbageCollectionTypes'
import accessibilityTypes from '@/models/accessibilityTypes'

export default {
  name: 'PropertyCharacteristicForm',
  mixins: [baseComponent],
  data() {
    return {
      propertySituations,
      outsideWallCharacteristics,
      electricityTypes,
      singleAnswers,
      waterSupplySystems,
      sanitarySewerTypes,
      garbageCollectionTypes,
      accessibilityTypes,
      hasWaterSupply: null,
      averagePeoplePerBedroom: null
    }
  }
}
</script>
