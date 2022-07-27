<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col>
        <InputText
          id="street"
          label="Endereço:"
          v-model="object.street"
          placeholder="Endereço"
          :maxlength="80"
          :minlength="8"
          :required="true"
          :disabled="disabled"
          :autofocus="true"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="2" sm="3">
        <InputNumber
          id="number"
          label="Número:"
          v-model="object.number"
          placeholder="Número"
          :maxlength="5"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="5" sm="5">
        <InputText
          id="districtName"
          label="Bairro:"
          v-model="object.districtName"
          placeholder="Bairro"
          :maxlength="45"
          :minlength="4"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="5" sm="4">
        <InputText
          id="complement"
          label="Complemento:"
          v-model="object.complement"
          placeholder="Complemento"
          :maxlength="45"
          :minlength="3"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="7" sm="12">
        <InputText
          id="landmark"
          label="Ponto de Referência:"
          v-model="object.landmark"
          placeholder="Ponto de Referência"
          :maxlength="45"
          :minlength="6"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="5" sm="12">
        <InputTextWithMask
          id="cep"
          label="CEP:"
          v-model="object.cep"
          mask="#####-###"
          placeholder="CEP"
          :minlength="9"
          :maxlength="9"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'

export default {
  name: 'FamilyAddressDetailedForm',
  mixins: [baseComponent]
}
</script>
