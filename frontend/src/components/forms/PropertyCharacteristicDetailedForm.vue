<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="locationProperty"
          label="O local onde está situado o seu domicílio tem, na maioria, características:"
          v-model="object.location"
          :radio="locations"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="propertySituation"
          label="Qual é a espécie do seu domicílio?"
          v-model="object.propertySituation"
          :radio="propertySituationsSimplified"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <div v-if="object.propertySituation === 1">
      <b-row>
        <b-col lg="6" sm="12">
          <InputNumber
            id="rooms"
            label="Quantos cômodos tem seu domicílio?"
            v-model="object.rooms"
            placeholder="Número"
            :maxlength="2"
            :required="false"
            :disabled="disabled"
          />
        </b-col>
        <b-col lg="6" sm="12">
          <InputNumber
            id="bedrooms"
            label="Quantos cômodos estão servindo, permanentemente, de dormitório para os moradores do seu domicílio?"
            v-model="object.bedrooms"
            placeholder="Número"
            :maxlength="2"
            :required="false"
            :disabled="disabled"
          />
        </b-col>
      </b-row>
      <b-row>
        <b-col lg="6" sm="12">
          <BaseRadio
            id="floorCharacteristic"
            label="Qual é o material predominante no piso do seu domicílio?"
            v-model="object.floorCharacteristic"
            :radio="floorCharacteristics"
            :required="true"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
        <b-col lg="6" sm="12">
          <BaseRadio
            id="outsideWallCharacteristic"
            label="Qual é o material predominante na construção das paredes externas do seu domicílio?"
            v-model="object.outsideWallCharacteristic"
            :radio="outsideWallCharacteristics"
            :required="true"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
      </b-row>
      <b-row>
        <b-col lg="6" sm="12">
          <BaseRadio
            id="hasWaterSupply"
            label="O seu domicílio tem água canalizada para, pelo menos, um cômodo?"
            v-model="hasWaterSupply"
            :radio="singleAnswers"
            :required="true"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
        <b-col lg="6" sm="12">
          <BaseRadio
            id="waterSupply"
            label="Qual é a forma de abastecimento de água utilizada no seu domicílio?"
            v-model="object.waterSupply"
            :radio="waterSupplySystems"
            :required="true"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
      </b-row>
      <b-row>
        <b-col lg="6" sm="12">
          <BaseRadio
            id="hasBathroom"
            label="No seu domicílio ou na propriedade existe banheiro ou sanitário?"
            v-model="hasBathroom"
            :radio="singleAnswers"
            :required="true"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
        <b-col lg="6" sm="12" v-if="hasBathroom === 1">
          <BaseRadio
            id="sanitarySewer"
            label="De que forma é feito o escoamento do banheiro ou sanitário?"
            v-model="object.sanitarySewer"
            :radio="sanitarySewerTypes"
            :required="true"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
      </b-row>
      <b-row>
        <b-col lg="6" sm="12">
          <BaseRadio
            id="garbageCollection"
            label="O lixo do seu domicílio:"
            v-model="object.garbageCollection"
            :radio="garbageCollectionTypes"
            :required="true"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
        <b-col lg="6" sm="12">
          <BaseRadio
            id="electricity"
            label="Qual é a forma de iluminação utilizada no seu domicílio?"
            v-model="object.electricity"
            :radio="electricityTypes"
            :required="true"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <BaseRadio
            id="sidewalk"
            label="Existe calçamento/pavimentação no trecho do logradouro (rua, avenida, etc.), em frente ao seu domicílio?"
            v-model="object.sidewalk"
            :radio="sidewalkSituations"
            :required="true"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
      </b-row>
    </div>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import locations from '@/models/locations'
import { propertySituationsSimplified } from '@/models/propertySituations'
import floorCharacteristics from '@/models/floorCharacteristics'
import outsideWallCharacteristics from '@/models/outsideWallCharacteristics'
import singleAnswers from '@/models/singleAnswers'
import { waterSupplySystems } from '@/models/waterSupplySystems'
import sanitarySewerTypes from '@/models/sanitarySewerTypes'
import garbageCollectionTypes from '@/models/garbageCollectionTypes'
import electricityTypes from '@/models/electricityTypes'
import sidewalkSituations from '@/models/sidewalkSituations'

export default {
  name: 'PropertyCharacteristicDetailedForm',
  mixins: [baseComponent],
  data() {
    return {
      locations,
      propertySituationsSimplified,
      floorCharacteristics,
      outsideWallCharacteristics,
      hasWaterSupply: null,
      singleAnswers,
      waterSupplySystems,
      hasBathroom: null,
      sanitarySewerTypes,
      garbageCollectionTypes,
      electricityTypes,
      sidewalkSituations
    }
  }
}
</script>
