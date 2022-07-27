<template :visible="visible">
  <b-form v-if="object">
    <b-card sub-title="QUADRO 1" bg-variant="light" class="mt-3">
      <b-form-group
        id="violenceSituationGroup"
        label="Histórico de situações de violência e violações de direitos vivenciadas pela família"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="6" sm="12">
            <InputDataList
              id="violenceSituationType"
              datalist="violenceSituationsList"
              label="Situação:"
              v-model="violenceSituationType"
              :sizes="violenceSituationDetailedTypes"
              placeholder="Situação"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="4" sm="8">
            <InputDate
              id="violenceSituationDate"
              label="Data da anotação:"
              v-model="violenceSituationDate"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="2" sm="4" class="add-new-violence-situation-button">
            <BaseButton
              type="button"
              id="addNewViolenceSituation"
              buttonName="Salvar"
              variant="outline-primary"
              @click.stop="addNewViolenceSituation"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="6" sm="12">
            <BaseRadio
              id="violenceSituationStatus"
              label="A situação ainda persiste?"
              v-model="violenceSituationStatus"
              :radio="singleAnswers"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import { violenceSituationDetailedTypes } from '@/models/violenceSituationsTypes'
import singleAnswers from '@/models/singleAnswers'

export default {
  name: 'HistoricalOfViolenceSituationForm',
  mixins: [baseComponent],
  data() {
    return {
      violenceSituationDetailedTypes,
      singleAnswers,
      violenceSituationType: null,
      violenceSituationDate: null,
      violenceSituationStatus: null
    }
  },
  methods: {
    addNewViolenceSituation() {}
  }
}
</script>

<style scoped>
.add-new-violence-situation-button {
  display: flex;
  align-items: flex-end;
  margin-bottom: 16px;
}
</style>
