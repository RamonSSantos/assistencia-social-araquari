<template>
  <b-form-group v-if="label" :label="label" :label-for="id" class="mt-2">
    <b-form-radio-group
      :id="id"
      :options="radio"
      @change="updateValue"
      v-model="value"
      v-bind="$attrs"
      v-on="listeners"
      aria-describedby="input-live-help input-live-feedback"
      :required="required"
      :state="baseRadio"
      :disabled="disabled"
      value-field="id"
      text-field="description"
      stacked
      :checked="selected"
    ></b-form-radio-group>
    <template v-if="required" v-slot:label>
      {{ label }}<span class="text-danger font-weight-bold"> *</span>
    </template>
  </b-form-group>
</template>

<script>
import baseRadio from '@/mixins/baseRadio'

export default {
  mixins: [baseRadio],
  computed: {
    listeners() {
      return {
        ...this.$listeners,
        change: this.updateValue
      }
    },
    baseRadio() {
      return this.value === 0 || this.value === null ? null : true
    }
  }
}
</script>
