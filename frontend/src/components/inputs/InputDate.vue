<template>
  <b-form-group v-if="label" :label="label" :label-for="id" class="mt-2">
    <b-input-group>
      <b-input-group-append>
        <b-form-datepicker
          v-model="date"
          @input="updateValue"
          locale="pt-BR"
          :date-format-options="{
            year: 'numeric',
            month: 'numeric',
            day: 'numeric'
          }"
          :max="maxDate"
          label-current-month="Mês atual"
          label-help="Use o cursor do mouse para navegar pelo calendário"
          labelNoDateSelected="Nenhuma data selecionada"
          label-next-month="Próximo mês"
          label-next-year="Próximo ano"
          label-prev-month="Mês anterior"
          label-prev-year="Ano anterior"
          label-today-button="Hoje"
          label-reset-button="Limpar"
          label-close-button="Fechar"
          today-button
          reset-button
          close-button
          button-only
        >
        </b-form-datepicker>
      </b-input-group-append>
      <b-form-input
        type="date"
        :id="id"
        :value="value"
        v-model="date"
        v-bind="$attrs"
        v-on="listeners"
        @change="updateValue"
        aria-describedby="input-live-help input-live-feedback"
        :placeholder="placeholder"
        :required="required"
        :state="inputDate"
        :disabled="disabled"
        :max="maxDate"
        pattern="\d{1,2}/\d{1,2}/\d{4}"
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
import inputDate from '@/mixins/inputDate'
import { isValidDate } from '@/utils/validateDate'

export default {
  mixins: [inputDate],
  computed: {
    listeners() {
      return {
        ...this.$listeners,
        input: this.updateValue
      }
    },
    inputDate() {
      return this.value === '' || this.value === null
        ? null
        : isValidDate(this.value) &&
          this.value <= this.maxDate &&
          this.value >= this.minDate
        ? true
        : false
    }
  }
}
</script>
