<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col>
        <InputText
          id="helthcareCenter"
          label="Unidade de Saúde de Referência:"
          v-model="object.helthcareCenter"
          placeholder="Unidade de Saúde de Referência"
          :maxlength="45"
          :minlength="4"
          :required="false"
          :disabled="disabled"
          :autofocus="true"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="programType"
          label="Domicílio coberto pelo Programa Saúde da Família:"
          v-model="object.programType"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="referenceCare"
          label="Necessita atendimento especial:"
          v-model="object.referenceCare"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
        <div v-if="object.referenceCare === 1">
          <InputText
            id="fullnameReferenceCare"
            label="Nome:"
            v-model="object.fullnameReferenceCare"
            placeholder="Nome"
            :maxlength="80"
            :minlength="4"
            :required="false"
            :disabled="disabled"
          />
        </div>
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="personHasDisability"
          label="Pessoa com deficiência:"
          v-model="object.personHasDisability"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
        <div v-if="object.personHasDisability === 1">
          <InputText
            id="fullnamePersonHasDisability"
            label="Nome:"
            v-model="object.fullnamePersonHasDisability"
            placeholder="Nome"
            :maxlength="80"
            :minlength="4"
            :required="false"
            :disabled="disabled"
          />
        </div>
      </b-col>
      <b-col lg="6" sm="12" v-if="object.personHasDisability === 1">
        <BaseCheckbox
          id="disabilityType"
          label="Tipo de deficiência:"
          v-model="hasDisabilityType"
          :checkbox="disabilityTypes"
          :required="true"
          :disabled="disabled"
        />
        <div v-if="hasDisabilityType.includes(8)">
          <InputText
            id="seriousIllness"
            label="Qual:"
            v-model="object.seriousIllness"
            placeholder="Nome"
            :maxlength="45"
            :minlength="4"
            :required="true"
            :disabled="disabled"
          />
        </div>
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="pregnancy"
          label="Gestante:"
          v-model="object.pregnancy"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
        <div v-if="object.pregnancy === 1">
          <InputNumber
            id="gestationalAge"
            label="Idade Gestacional:"
            v-model="object.gestationalAge"
            placeholder="Idade da gestação"
            :maxlength="2"
            :required="false"
            :disabled="disabled"
          />
        </div>
      </b-col>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="antenatalVisit"
          label="Pré Natal:"
          v-model="object.antenatalVisit"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="contraceptiveMethod"
          label="Utiliza método anticoncepcional:"
          v-model="object.contraceptiveMethod"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
        <div v-if="object.contraceptiveMethod === 1">
          <InputText
            id="contraceptiveMethodDescription"
            label="Qual:"
            v-model="object.contraceptiveMethodDescription"
            placeholder="Nome"
            :maxlength="45"
            :minlength="4"
            :required="false"
            :disabled="disabled"
          />
        </div>
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="chronicDisease"
          label="Situação de doença crônica:"
          v-model="object.chronicDisease"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
        <div v-if="object.chronicDisease === 1">
          <InputText
            id="chronicDiseaseDescription"
            label="Qual:"
            v-model="object.chronicDiseaseDescription"
            placeholder="Nome"
            :maxlength="45"
            :minlength="4"
            :required="false"
            :disabled="disabled"
          />
        </div>
      </b-col>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="prescriptionMedication"
          label="Medicamento de uso contínuo:"
          v-model="object.prescriptionMedication"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
        <div v-if="object.prescriptionMedication === 1">
          <InputMoney
            id="prescriptionMedicationValue"
            label="Gasto mensal:"
            v-model="object.prescriptionMedicationValue"
            :required="false"
            :disabled="disabled"
          />
        </div>
      </b-col>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="drugAddict"
          label="Situação de dependência química na família:"
          v-model="object.drugAddict"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
        <div v-if="object.drugAddict === 1">
          <InputText
            id="drugAddictDescription"
            label="Qual:"
            v-model="object.drugAddictDescription"
            placeholder="Qual"
            :maxlength="45"
            :minlength="4"
            :required="false"
            :disabled="disabled"
          />
        </div>
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import singleAnswers from '@/models/singleAnswers'
import disabilityTypes from '@/models/disabilityTypes'

export default {
  name: 'HealthConditionForm',
  mixins: [baseComponent],
  data() {
    return {
      singleAnswers,
      disabilityTypes,
      hasDisabilityType: []
    }
  }
}
</script>
