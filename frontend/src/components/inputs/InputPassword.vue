<template>
  <b-form-group v-if="label" :label="label" :label-for="id" class="mt-2">
    <b-form-input
      type="password"
      :id="id"
      :value="value"
      @input="updateValue"
      v-bind="$attrs"
      v-on="listeners"
      aria-describedby="input-live-help input-live-feedback"
      :placeholder="placeholder"
      :required="required"
      :state="inputPassword && passwordValidation"
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
    type="password"
    :id="id"
    :value="value"
    @input="updateValue"
    v-bind="$attrs"
    v-on="listeners"
    aria-describedby="input-live-help input-live-feedback"
    :placeholder="placeholder"
    :required="required"
    :state="inputPassword && passwordValidation"
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

export default {
  mixins: [baseInput, inputText],
  props: {
    isValidPassword: {
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
    inputPassword() {
      return this.value === null ? null : this.value.length >= 7 ? true : false
    },
    passwordValidation() {
      return this.isValidPassword === null
        ? null
        : this.isValidPassword
        ? true
        : false
    }
  },
  created() {
    this.$emit('update:isValidPassword', this.isValidPassword)
  },
  watch: {
    value() {
      this.$emit('update:isValidPassword', this.inputPassword)
    },
    isValidPassword(newValue) {
      this.$emit('update:isValidPassword', newValue)
    }
  }
}
</script>
