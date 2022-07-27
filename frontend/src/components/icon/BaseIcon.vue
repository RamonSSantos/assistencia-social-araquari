<template>
  <b-icon
    :icon="icon"
    :variant="variant"
    :font-scale="fontScale"
    :animation="animation"
    :scale="scale"
    :shift-v="shiftV"
    v-bind="$attrs"
    v-on="listeners"
  ></b-icon>
</template>

<script>
import baseIcon from '@/mixins/baseIcon'

export default {
  mixins: [baseIcon],
  computed: {
    listeners() {
      return {
        ...this.$listeners
      }
    }
  }
}
</script>
