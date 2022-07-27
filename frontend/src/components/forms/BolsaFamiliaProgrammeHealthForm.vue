<template :visible="visible">
  <b-form v-if="object">
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="bolsaFamiliaProgrammeHealthGroup"
        label="Anotações sobre o descumprimento de condicionalidades de saúde no Programa Bolsa Família"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="6" sm="12">
            <InputText
              id="householdIdentificationHealth"
              label="Nome do membro da família:"
              v-model="householdIdentificationHealth"
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
              id="incidentDateHealth"
              label="Data da ocorrência:"
              v-model="incidentDateHealth"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="6" sm="12">
            <InputDataList
              id="nonComplianceWithConditionalitiesTypeHealth"
              datalist="nonComplianceWithConditionalitiesList"
              label="Efeito:"
              v-model="nonComplianceWithConditionalitiesTypeHealth"
              :sizes="nonComplianceWithConditionalitiesTypes"
              placeholder=""
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="4" sm="8">
            <BaseRadio
              id="suspensionOfTheEffectsHealth"
              label="Solicitada suspensão do efeito?"
              v-model="suspensionOfTheEffectsHealth"
              :radio="singleAnswers"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
          <b-col lg="2" sm="4" class="add-new-bolsa-familia-programme-health">
            <BaseButton
              type="button"
              id="addNewBolsaFamiliaProgrammeHealth"
              buttonName="Salvar"
              variant="outline-primary"
              @click.stop="addNewBolsaFamiliaProgrammeHealth"
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
  name: 'BolsaFamiliaProgrammeHealthForm',
  mixins: [baseComponent],
  data() {
    return {
      nonComplianceWithConditionalitiesTypes,
      singleAnswers,
      householdIdentificationHealth: null,
      incidentDateHealth: null,
      nonComplianceWithConditionalitiesTypeHealth: null,
      suspensionOfTheEffectsHealth: null
    }
  },
  methods: {
    addNewBolsaFamiliaProgrammeHealth() {}
  }
}
</script>

<style scoped>
.add-new-bolsa-familia-programme-health {
  display: flex;
  align-items: flex-end;
  margin-bottom: 16px;
}
</style>
