<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="3" sm="12">
        <BaseRadio
          id="retired"
          label="Aposentado?"
          v-model="object.retired"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="3" sm="12">
        <BaseRadio
          id="workLaskWeek"
          label="Trabalhou na semana passada?"
          v-model="object.workLaskWeek"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="workLaskYear"
          label="Houve trabalho remunerado nos últimos 12 meses?"
          v-model="object.workLaskYear"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
        <div v-if="object.workLaskYear === 1">
          <InputNumber
            id="monthsWorked"
            label="Quantos meses trabalhou nesse período?"
            v-model="object.monthsWorked"
            placeholder="Quantos meses trabalhou nesse período?"
            :maxlength="2"
            :required="false"
            :disabled="disabled"
          />
        </div>
      </b-col>
    </b-row>
    <div v-if="object.retired === 2">
      <b-form-text id="input-live-help">
        Caso tenha mais de um trabalho, considere como principal o de maior
        número de horas normalmente trabalhadas por semana
      </b-form-text>
      <b-row>
        <b-col lg="6" sm="12">
          <InputText
            id="jobLocation"
            label="Local de Trabalho:"
            v-model="object.jobLocation"
            placeholder="Local de trabalho"
            :maxlength="45"
            :minlength="4"
            :required="false"
            :disabled="disabled"
          />
        </b-col>
        <b-col lg="6" sm="12">
          <BaseRadio
            id="professionalQualificationAnswer"
            label="Possui qualificação profissional?"
            v-model="object.professionalQualificationAnswer"
            :radio="singleAnswers"
            :required="false"
            :disabled="disabled"
            :selected="0"
          />
          <div v-if="object.professionalQualificationAnswer === 1">
            <InputText
              id="professionalQualification"
              label="Qual?"
              v-model="object.professionalQualification"
              placeholder="Qualificação profissional"
              :maxlength="45"
              :minlength="4"
              :required="false"
              :disabled="disabled"
            />
          </div>
        </b-col>
      </b-row>
      <b-row>
        <b-col lg="6" sm="12">
          <InputText
            id="jobTitle"
            label="Função:"
            v-model="object.jobTitle"
            placeholder="Função"
            :maxlength="45"
            :minlength="4"
            :required="false"
            :disabled="disabled"
          />
        </b-col>
        <b-col lg="6" sm="12">
          <BaseTextarea
            id="observation"
            label="Observação:"
            v-model="object.observation"
            placeholder="Observação"
            :required="false"
            :disabled="disabled"
            :maxlength="150"
          />
        </b-col>
      </b-row>
    </div>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import singleAnswers from '@/models/singleAnswers'

export default {
  name: 'HouseholdWorkInformationForm',
  mixins: [baseComponent],
  data() {
    return {
      singleAnswers
    }
  }
}
</script>
