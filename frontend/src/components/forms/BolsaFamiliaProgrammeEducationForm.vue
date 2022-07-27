<template :visible="visible">
  <b-form v-if="object">
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="bolsaFamiliaProgrammeEducationGroup"
        label="Anotações sobre o descumprimento de condicionalidades de educação no Programa Bolsa Família"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="6" sm="12">
            <InputText
              id="householdIdentificationEducation"
              label="Nome do membro da família:"
              v-model="householdIdentificationEducation"
              placeholder="Membro da família"
              :maxlength="80"
              :minlength="8"
              :required="true"
              :disabled="disabled"
              :autofocus="true"
            />
          </b-col>
          <b-col lg="6" sm="12">
            <InputDate
              id="incidentDateEducation"
              label="Data da ocorrência:"
              v-model="incidentDateEducation"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="6" sm="12">
            <InputDataList
              id="nonComplianceWithConditionalitiesTypeEducation"
              datalist="nonComplianceWithConditionalitiesList"
              label="Efeito:"
              v-model="nonComplianceWithConditionalitiesTypeEducation"
              :sizes="nonComplianceWithConditionalitiesTypes"
              placeholder=""
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="4" sm="8">
            <BaseRadio
              id="suspensionOfTheEffectsEducation"
              label="Solicitada suspensão do efeito?"
              v-model="suspensionOfTheEffectsEducation"
              :radio="singleAnswers"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
          <b-col
            lg="2"
            sm="4"
            class="add-new-bolsa-familia-programme-education"
          >
            <BaseButton
              type="button"
              id="addNewBolsaFamiliaProgrammeEducation"
              buttonName="Salvar"
              variant="outline-primary"
              @click.stop="addNewBolsaFamiliaProgrammeEducation"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import nonComplianceWithConditionalitiesTypes from '@/models/nonComplianceWithConditionalitiesTypes'
import singleAnswers from '@/models/singleAnswers'

export default {
  name: 'BolsaFamiliaProgrammeEducationForm',
  mixins: [baseComponent],
  data() {
    return {
      nonComplianceWithConditionalitiesTypes,
      singleAnswers,
      householdIdentificationEducation: null,
      incidentDateEducation: null,
      nonComplianceWithConditionalitiesTypeEducation: null,
      suspensionOfTheEffectsEducation: null
    }
  },
  methods: {
    addNewBolsaFamiliaProgrammeEducation() {}
  }
}
</script>

<style scoped>
.add-new-bolsa-familia-programme-education {
  display: flex;
  align-items: flex-end;
  margin-bottom: 16px;
}
</style>
