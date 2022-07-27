<template>
  <b-form-group v-if="label" :label="label" :label-for="id" class="mt-2">
    <b-form-input
      type="text"
      :id="id"
      :value="value"
      @input="updateValue"
      v-bind="$attrs"
      v-on="listeners"
      aria-describedby="input-live-help input-live-feedback"
      :placeholder="placeholder"
      :required="required"
      :state="inputText && textConfirmation"
      :disabled="disabled"
      :maxlength="maxlength"
      :autofocus="autofocus"
    >
    </b-form-input>
    <template v-if="required" v-slot:label>
      {{ label }}<span class="text-danger font-weight-bold"> *</span>
    </template>
  </b-form-group>
</template>

<script>
import baseInput from '@/mixins/baseInput'
import inputText from '@/mixins/inputText'

export default {
  mixins: [baseInput, inputText],
  props: {
    isValidText: {
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
      return this.isValidText === null ? null : this.isValidText ? true : false
    }
  },
  created() {
    this.$emit('update:isValidText', this.isValidText)
  },
  watch: {
    value() {
      this.$emit('update:isValidText', this.inputText)
    }
  }
}
</script>
