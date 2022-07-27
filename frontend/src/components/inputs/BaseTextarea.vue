<template>
  <b-form-group v-if="label" :label="label" :label-for="id" class="mt-2">
    <b-form-textarea
      :id="id"
      :value="value"
      @input="updateValue"
      v-bind="$attrs"
      v-on="listeners"
      aria-describedby="input-live-help input-live-feedback"
      :placeholder="placeholder"
      :required="required"
      :disabled="disabled"
      :maxlength="maxlength"
      :autofocus="autofocus"
      rows="3"
      max-rows="8"
      no-resize
    >
    </b-form-textarea>
    <template v-if="required" v-slot:label>
      {{ label }}<span class="text-danger font-weight-bold"> *</span>
    </template>
  </b-form-group>
</template>

<script>
import baseTextarea from '@/mixins/baseTextarea'

export default {
  mixins: [baseTextarea],
  computed: {
    listeners() {
      return {
        ...this.$listeners,
        input: this.updateValue
      }
    }
  }
}
</script>
