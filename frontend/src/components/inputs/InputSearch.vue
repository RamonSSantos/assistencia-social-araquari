<template>
  <b-form-input
    type="text"
    :id="id"
    :value="value"
    @input="updateValue"
    v-bind="$attrs"
    v-on="listeners"
    :placeholder="placeholder"
    :maxlength="maxlength"
    :autofocus="autofocus"
    :debounce="500"
  >
  </b-form-input>
</template>

<script>
import baseSearch from '@/mixins/baseSearch'
import inputText from '@/mixins/inputText'

export default {
  mixins: [baseSearch, inputText],
  props: {
    isValidSearch: {
      type: Boolean,
      default: null
    }
  },
  computed: {
    listeners() {
      return {
        ...this.$listeners,
        input: this.updateValue
      }
    },
    inputText() {
      return this.value === null
        ? null
        : this.value.length >= this.minlength
        ? true
        : false
    },
    textConfirmation() {
      return this.isValidSearch === null
        ? null
        : this.isValidSearch
        ? true
        : false
    }
  },
  created() {
    this.$emit('update:isValidSearch', this.isValidSearch)
  },
  watch: {
    value() {
      this.$emit('update:isValidSearch', this.inputSearch)
    }
  }
}
</script>
