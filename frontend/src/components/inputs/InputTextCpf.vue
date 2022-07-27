<template>
  <b-form-group v-if="label" :label="label" :label-for="id" class="mt-2">
    <b-form-input
      type="text"
      :id="id"
      :value="value"
      @input="updateValue"
      v-bind="$attrs"
      v-on="listeners"
      ref="inputCpf"
      v-mask="'###.###.###-##'"
      aria-describedby="input-live-help input-live-feedback"
      :placeholder="placeholder"
      :required="required"
      :state="inputText && cpfValidation"
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
import validateCpf from '@/utils/validateCpf'

export default {
  mixins: [baseInput, inputText],
  props: {
    isValidCpf: {
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
        : this.value.length >= this.minlength && validateCpf(this.value)
        ? true
        : false
    },
    cpfValidation() {
      return this.isValidCpf === null ? null : this.isValidCpf ? true : false
    }
  },
  created() {
    this.$emit('update:isValidCpf', this.isValidCpf)
  },
  watch: {
    value() {
      this.$emit('update:isValidCpf', this.inputText)
    }
  }
}
</script>
