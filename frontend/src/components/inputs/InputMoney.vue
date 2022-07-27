<template>
  <b-form-group v-if="label" :label="label" :label-for="id" class="mt-2">
    <b-form-input
      :id="id"
      :value="value"
      @input="updateValue"
      v-money="money"
      v-on="listeners"
      v-model.lazy="price"
      aria-describedby="input-live-help input-live-feedback"
      :state="inputMoney"
      :maxlength="maxlength"
      :disabled="disabled"
      class="form-control"
    ></b-form-input>
    <template v-if="required" v-slot:label>
      {{ label }}<span class="text-danger font-weight-bold"> *</span>
    </template>
  </b-form-group>
</template>

<script>
import baseInput from '@/mixins/baseInput'
import inputMoney from '@/mixins/inputMoney'

export default {
  mixins: [baseInput, inputMoney],
  computed: {
    listeners() {
      return {
        ...this.$listeners,
        input: this.updateValue
      }
    },
    inputMoney() {
      return this.value === 'R$ 0,00' || this.value === null
        ? null
        : this.value.toString().length > this.minlength
        ? true
        : false
    }
  }
}
</script>
