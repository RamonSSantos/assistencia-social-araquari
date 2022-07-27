<template>
  <b-form-group v-if="label" :label="label" :label-for="id" class="mt-2">
    <b-input-group>
      <b-input-group-append>
        <b-form-timepicker
          v-model="time"
          locale="pt-br"
          label-hours="Horas"
          label-minutes="Minutos"
          label-reset-button="Limpar"
          label-close-button="Fechar"
          reset-button
          button-only
        >
        </b-form-timepicker>
      </b-input-group-append>
      <b-form-input
        type="text"
        :id="id"
        :value="value"
        v-model="time"
        @input="updateValue"
        v-bind="$attrs"
        v-on="listeners"
        aria-describedby="input-live-help input-live-feedback"
        :placeholder="placeholder"
        :required="required"
        :state="inputTime"
        :disabled="disabled"
        :min="min"
        :max="max"
        v-mask="'##:##'"
        autocomplete="off"
      >
      </b-form-input>
    </b-input-group>
    <template v-if="required" v-slot:label>
      {{ label }}<span class="text-danger font-weight-bold"> *</span>
    </template>
  </b-form-group>
</template>

<script>
import baseInput from '@/mixins/baseInput'

export default {
  mixins: [baseInput],
  data() {
    return {
      time: null,
      min: '00:01',
      max: '23:59'
    }
  },
  computed: {
    listeners() {
      return {
        ...this.$listeners,
        input: this.updateValue
      }
    },
    inputTime() {
      return this.value === '' || this.value === null || this.value.length < 5
        ? null
        : this.value >= this.min &&
          this.value <= this.max &&
          this.value.length === 5
        ? true
        : false
    }
  }
}
</script>
