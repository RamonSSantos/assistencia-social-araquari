<template>
  <b-form-group v-if="label" :label="label" :label-for="id" class="mt-2">
    <b-form-checkbox-group
      :id="id"
      :options="checkbox"
      @change.once="updateValue"
      v-model="value"
      v-bind="$attrs"
      v-on="listeners"
      aria-describedby="input-live-help input-live-feedback"
      :required="required"
      :state="baseCheckbox"
      :disabled="disabled"
      value-field="id"
      text-field="description"
      stacked
    ></b-form-checkbox-group>
    <template v-if="required" v-slot:label>
      {{ label }}<span class="text-danger font-weight-bold"> *</span>
    </template>
  </b-form-group>
</template>

<script>
import baseCheckbox from '@/mixins/baseCheckbox'

export default {
  mixins: [baseCheckbox],
  computed: {
    listeners() {
      return {
        ...this.$listeners,
        change: this.updateValue
      }
    },
    baseCheckbox() {
      return this.value.length === 0 ? null : true
    }
  }
}
</script>
