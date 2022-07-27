<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="8" md="6" sm="12">
        <InputText
          id="jobLocation"
          label="Local de Trabalho:"
          v-model="object.jobLocation"
          placeholder="Local de trabalho"
          :maxlength="45"
          :minlength="4"
          :required="true"
          :disabled="disabled"
          :autofocus="true"
        />
      </b-col>
      <b-col lg="2" md="3" sm="6">
        <InputTime
          id="workDayFrom"
          label="Horário:"
          v-model="workDayFrom"
          placeholder="De"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="2" md="3" sm="6">
        <InputTime
          id="workDayTo"
          label="Formato: 24hrs"
          v-model="workDayTo"
          placeholder="Até"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="8" md="6" sm="12">
        <InputText
          id="jobTitle"
          label="Função:"
          v-model="object.jobTitle"
          placeholder="Função"
          :maxlength="45"
          :minlength="4"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="4" md="6" sm="12">
        <InputMoney
          id="familyGrossSalary"
          label="Salário Bruto da Família:"
          v-model="object.familyGrossSalary"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="8" md="6" sm="12">
        <BaseRadio
          id="typeRemuneration"
          label="Remuneração:"
          v-model="object.remunerationType"
          :radio="remunerationTypes"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="4" md="6" sm="12">
        <InputMoney
          id="grossSalary"
          label="Valor:"
          v-model="object.grossSalary"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import remunerationTypes from '@/models/remunerationTypes'

export default {
  name: 'WorkInformationForm',
  mixins: [baseComponent],
  data() {
    return {
      remunerationTypes,
      workDayFrom: null,
      workDayTo: null
    }
  }
}
</script>
