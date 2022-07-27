<template>
  <b-form-group v-if="label" :label="label" :label-for="id" class="mt-2">
    <b-form-input
      :id="id"
      :list="datalist"
      :value="value"
      @select="updateList"
      v-bind="$attrs"
      v-on="listeners"
      aria-describedby="input-live-help input-live-feedback"
      :placeholder="placeholder"
      :required="required"
      :state="inputDataList"
      :disabled="disabled"
    ></b-form-input>
    <datalist :id="datalist">
      <option
        v-for="size in sizes"
        :key="size.id"
        :value="size.description"
      ></option>
    </datalist>
    <template v-if="required" v-slot:label>
      {{ label }}<span class="text-danger font-weight-bold"> *</span>
    </template>
  </b-form-group>
</template>

<script>
import baseInput from '@/mixins/baseInput'
import inputDatalist from '@/mixins/inputDatalist'

export default {
  mixins: [baseInput, inputDatalist],
  computed: {
    listeners() {
      return {
        ...this.$listeners,
        input: this.updateList
      }
    },
    inputDataList() {
      return this.value === '' ||
        this.value === null ||
        this.validation === null
        ? null
        : this.validation !== true
        ? false
        : true
    }
  }
}
</script>
