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
      :state="inputNumber"
      :disabled="disabled"
      :maxlength="maxlength"
      onkeypress="return event.charCode >= 48 && event.charCode <= 57"
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
  computed: {
    listeners() {
      return {
        ...this.$listeners,
        input: this.updateValue
      }
    },
    inputNumber() {
      return this.value === '' || this.value === null
        ? null
        : this.value.length >= this.minlength &&
          this.value.length <= this.maxlength
        ? true
        : false
    }
  }
}
</script>
