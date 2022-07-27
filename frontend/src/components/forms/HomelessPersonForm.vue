<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="8" md="7" sm="12">
        <InputText
          id="homelessPersonFullname"
          label="Nome completo:"
          v-model="object.fullname"
          placeholder="Nome completo"
          :maxlength="80"
          :minlength="4"
          :required="true"
          :disabled="disabled"
          :autofocus="true"
        />
      </b-col>
      <b-col lg="4" md="5" sm="12">
        <InputTextWithMask
          id="homelessPersonNis"
          label="NIS:"
          v-model="object.nis"
          mask="###########"
          placeholder="Identificação (NIS/PIS/PASEP)"
          :minlength="11"
          :maxlength="11"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="whereHeSleepsGroup"
        label="Onde costuma dormir? Este quesito admite múltipla marcação"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="3" md="6" sm="12">
            <InputNumber
              id="sleepInStreet"
              label="1 - Rua: Quantas vezes por semana?"
              v-model="sleepInStreet"
              placeholder=""
              :maxlength="2"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="3" md="6" sm="12">
            <InputNumber
              id="sleepInHostel"
              label="2 - Albergue: Quantas vezes por semana?"
              v-model="sleepInHostel"
              placeholder=""
              :maxlength="2"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="3" md="6" sm="12">
            <InputNumber
              id="sleepInPrivateHome"
              label="3 - Domicílio particular: Quantas vezes por semana?"
              v-model="sleepInPrivateHome"
              placeholder=""
              :maxlength="2"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="3" md="6" sm="12">
            <InputNumber
              id="sleepInAnotherOption"
              label="4 - Outro: Quantas vezes por semana?"
              v-model="sleepInAnotherOption"
              placeholder=""
              :maxlength="2"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
    <b-row>
      <b-col lg="6">
        <BaseRadio
          id="livingOnTheStreetPeriod"
          label="Há quanto tempo vive na rua?"
          v-model="livingOnTheStreetPeriod"
          :radio="livingOnTheStreetPeriods"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6">
        <BaseCheckbox
          id="livingOnTheStreetReason"
          label="Quais os principais motivos pelos quais passou a morar na rua/albergue/outro? Este quesito admite múltipla marcação."
          v-model="livingOnTheStreetReason"
          :checkbox="livingOnTheStreetReasons"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6">
        <BaseRadio
          id="livingInTheCityPeriod"
          label="Há quanto tempo mora nesta cidade?"
          v-model="livingInTheCityPeriod"
          :radio="livingInTheCityPeriods"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6">
        <BaseRadio
          id="hasContactWithRelative"
          label="Tem contato com parente que viva fora da rua?"
          v-model="hasContactWithRelative"
          :radio="contactWithRelativePeriods"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <BaseRadio
          id="livingWithFamilyOnTheStreet"
          label="Vive com sua família na rua?"
          v-model="livingWithFamilyOnTheStreet"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6">
        <BaseCheckbox
          id="participatedInCommunityActivities"
          label="Nos últimos seis meses frequentou ou participou de alguma atividade comunitária? Este quesito admite múltipla marcação."
          v-model="participatedInCommunityActivities"
          :checkbox="communityActivities"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="6">
        <BaseRadio
          id="attendedInHostInstitution"
          label="Nos últimos seis meses foi atendido em algum dos lugares listados abaixo? Este quesito admite múltipla marcação."
          v-model="attendedInHostInstitution"
          :radio="hostInstitutions"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6">
        <BaseRadio
          id="formalEmployment"
          label="Alguma vez teve emprego com carteira de trabalho assinada?"
          v-model="formalEmployment"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6">
        <BaseCheckbox
          id="howHeEarnsMoney"
          label="O que faz para ganhar dinheiro? Este quesito admite múltipla marcação."
          v-model="howHeEarnsMoney"
          :checkbox="waysToMakeMoney"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import livingOnTheStreetPeriods from '@/models/livingOnTheStreetPeriods'
import livingOnTheStreetReasons from '@/models/livingOnTheStreetReasons'
import livingInTheCityPeriods from '@/models/livingInTheCityPeriods'
import contactWithRelativePeriods from '@/models/contactWithRelativePeriods'
import singleAnswers from '@/models/singleAnswers'
import communityActivities from '@/models/communityActivities'
import hostInstitutions from '@/models/hostInstitutions'
import waysToMakeMoney from '@/models/waysToMakeMoney'

export default {
  name: 'HomelessPersonForm',
  mixins: [baseComponent],
  data() {
    return {
      livingOnTheStreetPeriods,
      livingOnTheStreetReasons,
      livingInTheCityPeriods,
      contactWithRelativePeriods,
      singleAnswers,
      communityActivities,
      hostInstitutions,
      waysToMakeMoney,
      sleepInStreet: null,
      sleepInHostel: null,
      sleepInPrivateHome: null,
      sleepInAnotherOption: null,
      livingOnTheStreetPeriod: null,
      livingOnTheStreetReason: null,
      livingInTheCityPeriod: null,
      hasContactWithRelative: null,
      livingWithFamilyOnTheStreet: null,
      participatedInCommunityActivities: null,
      attendedInHostInstitution: null,
      formalEmployment: null,
      howHeEarnsMoney: null
    }
  }
}
</script>
