<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="2" md="4" sm="4">
        <InputNumber
          id="familyCode"
          label="Código familiar:"
          v-model="object.familyCode"
          placeholder="Código familiar"
          :minlength="11"
          :maxlength="11"
          :required="true"
          :disabled="disabled"
          :autofocus="true"
        />
      </b-col>
      <b-col lg="2" md="4" sm="4">
        <InputText
          id="state"
          label="UF:"
          v-model="object.state"
          placeholder="UF"
          :maxlength="2"
          :minlength="2"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="2" md="4" sm="4">
        <InputNumber
          id="town"
          label="Município:"
          v-model="object.town"
          placeholder="Código"
          :minlength="5"
          :maxlength="5"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="2" md="4" sm="4">
        <InputText
          id="district_code"
          label="Distrito:"
          v-model="object.district_code"
          placeholder="Código"
          :maxlength="2"
          :minlength="2"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="2" md="4" sm="4">
        <InputText
          id="subdistrict"
          label="Subdistrito:"
          v-model="object.subdistrict"
          placeholder="Código"
          :maxlength="2"
          :minlength="2"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="2" md="4" sm="4">
        <InputNumber
          id="census_sector"
          label="Setor censitário:"
          v-model="object.census_sector"
          placeholder="Código"
          :minlength="4"
          :maxlength="4"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="3" md="6" sm="12">
        <InputDate
          id="interviewDate"
          label="Data da entrevista:"
          v-model="object.interviewDate"
          placeholder="dd/mm/aaaa"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="3" md="6" sm="12">
        <BaseRadio
          id="typeOperation"
          label="Modalidade da operação:"
          v-model="object.operationType"
          :radio="operationTypes"
          :required="true"
          :disabled="disabled"
          :selected="null"
        />
      </b-col>
      <b-col lg="3" md="6" sm="12">
        <BaseRadio
          id="typeInterview"
          label="Forma de coleta de dados:"
          v-model="object.interviewType"
          :radio="interviewTypes"
          :required="true"
          :disabled="disabled"
          :selected="null"
        />
      </b-col>
      <b-col lg="3" md="6" sm="12">
        <BaseRadio
          id="typeForm"
          label="Selecione o formulário:"
          v-model="object.formType"
          :radio="formTypes"
          :required="true"
          :disabled="disabled"
          :selected="null"
        />
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import operationTypes from '@/models/operationTypes'
import interviewTypes from '@/models/interviewTypes'
import formTypes from '@/models/formTypes'

export default {
  name: 'InterviewIdentificationAndControlForm',
  mixins: [baseComponent],
  data() {
    return {
      operationTypes,
      interviewTypes,
      formTypes
    }
  }
}
</script>
