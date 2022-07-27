<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="familySpecificityType"
          label="Especificidades sociais, étnicas ou culturais da família"
          v-model="familySpecificityType"
          :radio="familySpecificityTypes"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col
        lg="6"
        sm="12"
        v-if="familySpecificityType === 5 || familySpecificityType === 6"
      >
        <InputText
          id="ethnicity"
          label="Especifique o povo/etnia:"
          v-model="ethnicity"
          placeholder=""
          :maxlength="45"
          :minlength="4"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="6" sm="12" v-if="familySpecificityType === 7">
        <InputText
          id="otherEthnicity"
          label="Informe a etnia da família"
          v-model="ethnicity"
          placeholder=""
          :maxlength="45"
          :minlength="4"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import familySpecificityTypes from '@/models/familySpecificityTypes'

export default {
  name: 'FamilySpecificityForm',
  mixins: [baseComponent],
  data() {
    return {
      familySpecificityTypes,
      familySpecificityType: null,
      ethnicity: null
    }
  }
}
</script>
