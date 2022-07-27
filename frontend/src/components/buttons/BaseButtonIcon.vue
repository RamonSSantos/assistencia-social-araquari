<template>
  <b-button
    :type="type"
    :id="id"
    :variant="variant"
    :disabled="disabled"
    v-bind="$attrs"
    v-on="listeners"
    :block="block"
  >
    <BaseIcon :icon="icon" :variant="null" />
    {{ buttonName }}
  </b-button>
</template>

<script>
import baseButton from '@/mixins/baseButton'

export default {
  mixins: [baseButton],
  computed: {
    listeners() {
      return {
        ...this.$listeners
      }
    }
  }
}
</script>
