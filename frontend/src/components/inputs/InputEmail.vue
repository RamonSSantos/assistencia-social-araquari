<template>
  <b-form-group v-if="label" :label="label" :label-for="id" class="mt-2">
    <b-form-input
      type="email"
      :id="id"
      :value="value"
      @input="updateValue"
      v-bind="$attrs"
      v-on="listeners"
      ref="inputEmail"
      aria-describedby="input-live-help input-live-feedback"
      :placeholder="placeholder"
      :required="required"
      :state="inputEmail && emailValidation"
      :disabled="disabled"
      :maxlength="maxlength"
      :autofocus="autofocus"
      autocomplete="off"
    >
    </b-form-input>
    <template v-if="required" v-slot:label>
      {{ label }}<span class="text-danger font-weight-bold"> *</span>
    </template>
  </b-form-group>
  <b-form-input
    v-else
    type="email"
    :id="id"
    :value="value"
    @input="updateValue"
    v-bind="$attrs"
    v-on="listeners"
    ref="inputEmail"
    aria-describedby="input-live-help input-live-feedback"
    :placeholder="placeholder"
    :required="required"
    :state="inputEmail && emailValidation"
    :disabled="disabled"
    :maxlength="maxlength"
    :autofocus="autofocus"
    autocomplete="off"
    class="mb-0"
  >
  </b-form-input>
</template>

<script>
import baseInput from '@/mixins/baseInput'
import inputText from '@/mixins/inputText'
import validateEmail from '@/utils/validateEmail'

export default {
  mixins: [baseInput, inputText],
  props: {
    isValidEmail: {
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
    inputEmail() {
      return this.value === null
        ? null
        : validateEmail(this.value)
        ? true
        : false
    },
    emailValidation() {
      return this.isValidEmail === null
        ? null
        : this.isValidEmail
        ? true
        : false
    }
  },
  created() {
    this.$emit('update:isValidEmail', this.isValidEmail)
  },
  watch: {
    value() {
      this.$emit('update:isValidEmail', this.inputEmail)
    },
    isValidEmail(newValue) {
      this.$emit('update:isValidEmail', newValue)
    }
  }
}
</script>
