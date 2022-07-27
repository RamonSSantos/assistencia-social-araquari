<template :visible="visible">
  <b-form v-if="nextObject">
    <template v-if="idSubdepartment === 1">
      <SingleRegistryTypes :formType="nextObject.formType" />
    </template>
    <b-card
      v-else-if="idSubdepartment === 2"
      title="Serviços de Benefícios Eventuais"
    >
      <SimplifiedServiceTab
        :tabs="simplifiedServiceItems"
        :disabled="disabled"
      />
    </b-card>
    <b-card v-else-if="idSubdepartment >= 4 && idSubdepartment <= 6">
      <SocialAssistanceTab :tabs="socialAssistanceItems" :disabled="disabled" />
    </b-card>
    <b-card v-else>
      Em construção
    </b-card>
  </b-form>
</template>

<script>
import simplifiedServiceItems from '@/models/simplifiedServiceItems'
import socialAssistanceItems from '@/models/socialAssistanceItems'

export default {
  name: 'SingleRegistryIdentificationForm',
  model: {
    prop: 'visible',
    event: 'change'
  },
  props: {
    visible: {
      type: Boolean,
      default: false
    },
    disabled: {
      type: Boolean,
      default: false
    },
    nextObject: {
      type: Object,
      default: null
    },
    idSubdepartment: {
      type: Number,
      default: null
    }
  },
  data() {
    return {
      simplifiedServiceItems,
      socialAssistanceItems,
      newObject: Object
    }
  }
}
</script>
