<template>
  <b-overlay
    v-if="buttonWithSpinner"
    :show="loadingSpinner"
    opacity="0.6"
    spinner-small
    :spinner-variant="variant"
  >
    <b-button
      :type="type"
      :id="id"
      :variant="variant"
      :disabled="disabled"
      v-bind="$attrs"
      v-on="listeners"
      :pill="pill"
      :block="block"
    >
      {{ buttonName }}
    </b-button>
  </b-overlay>
  <b-button
    v-else
    :type="type"
    :id="id"
    :variant="variant"
    :disabled="disabled"
    v-bind="$attrs"
    v-on="listeners"
    :pill="pill"
    :block="block"
  >
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
