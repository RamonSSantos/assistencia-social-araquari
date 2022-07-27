<template>
  <b-card v-if="formType === 1" title="Formulário Principal de Cadastramento">
    <SingleRegistryMainTab :tabs="singleRegistryMainItems" :disabled="false" />
  </b-card>
  <b-card
    v-else-if="formType === 2"
    title="Formulário Avulso 1"
    sub-title="Identificação do Domicílio e da Família"
  >
    <SingleRegistrySeparateTab
      :tabs="singleRegistrySeparateItems"
      :disabled="false"
      :formType="formType"
    />
  </b-card>
  <b-card
    v-else-if="formType === 3"
    title="Formulário Avulso 2"
    sub-title="Identificação da Pessoa"
  >
    <SingleRegistrySeparateTab
      :tabs="singleRegistrySeparateItems"
      :disabled="false"
      :formType="formType"
    />
  </b-card>
  <b-card
    v-else-if="formType === 4"
    title="Formulário Suplementar 1"
    sub-title="Vinculação a Programas e Serviços"
  >
    <SingleRegistryAdditionalTab
      :tabs="singleRegistryAdditionalItems"
      :disabled="false"
      :formType="formType"
    />
  </b-card>
  <b-card
    v-else-if="formType === 5"
    title="Formulário Suplementar 2"
    sub-title="Pessoa em Situação de Rua"
  >
    <SingleRegistryAdditionalTab
      :tabs="singleRegistryAdditionalItems"
      :disabled="false"
      :formType="formType"
    />
  </b-card>
</template>

<script>
import singleRegistryMainItems from '@/models/singleRegistryMainItems'
import singleRegistrySeparateItems from '@/models/singleRegistrySeparateItems'
import singleRegistryAdditionalItems from '@/models/singleRegistryAdditionalItems'

export default {
  name: 'SingleRegistryTypes',
  props: {
    formType: {
      type: Number,
      default: null
    }
  },
  data() {
    return {
      singleRegistryMainItems,
      singleRegistrySeparateItems,
      singleRegistryAdditionalItems
    }
  }
}
</script>
