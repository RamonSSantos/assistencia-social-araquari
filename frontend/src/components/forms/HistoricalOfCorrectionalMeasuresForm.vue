<template :visible="visible">
  <b-form v-if="object">
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="historicalOfCorrectionalMeasuresGroup"
        label="Histórico de Aplicação de Medidas Socioeducativas para Adolescentes"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="6" sm="12">
            <InputText
              id="adolescentIdentification"
              label="Nome do adolescente:"
              v-model="adolescentIdentification"
              placeholder="Adolescente"
              :maxlength="80"
              :minlength="8"
              :required="true"
              :disabled="disabled"
              :autofocus="true"
            />
          </b-col>
          <b-col lg="6" sm="12">
            <InputDataList
              id="correctionalMeasureDescription"
              datalist="correctionalMeasuresList"
              label="Tipo de Medida:"
              v-model="correctionalMeasureDescription"
              :sizes="correctionalMeasuresTypes"
              placeholder=""
              :required="true"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="5" sm="4">
            <InputDate
              id="startingDateOfCorrectionalMeasure"
              label="Data de Início:"
              v-model="startingDateOfCorrectionalMeasure"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="5" sm="4">
            <InputDate
              id="endingDateOfCorrectionalMeasure"
              label="Data de Fim:"
              v-model="endingDateOfCorrectionalMeasure"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="2" sm="4" class="add-new-correctional-measure">
            <BaseButton
              type="button"
              id="addNewCorrectionalMeasure"
              buttonName="Salvar"
              variant="outline-primary"
              @click.stop="addNewCorrectionalMeasure"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
    <b-card
      bg-variant="light"
      class="mt-3"
      v-if="
        correctionalMeasureSelected === 1 || correctionalMeasureSelected === 2
      "
    >
      <b-form-group
        id="monitoringCorrectionalMeasures"
        label="Caso o adolescente esteja cumprindo medida socioeducativa de LA ou PSC, registre se o mesmo foi, ou está sendo, acompanhado pelo CREAS"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="4" sm="12">
            <BaseRadio
              id="monitoringSocialAssistanceReferenceCentres"
              label="Acompanhado pelo CREAS"
              v-model="monitoringSocialAssistanceReferenceCentres"
              :radio="singleAnswers"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
          <b-col lg="4" sm="12">
            <InputDate
              id="monitoringDateSocialAssistanceReferenceCentres"
              label="Data da Anotação:"
              v-model="monitoringDateSocialAssistanceReferenceCentres"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="4" sm="12">
            <InputText
              id="monitoringObservationSocialAssistanceReferenceCentres"
              label="Observação:"
              v-model="monitoringObservationSocialAssistanceReferenceCentres"
              placeholder=""
              :maxlength="80"
              :minlength="8"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
        <b-row v-if="correctionalMeasureSelected === 2">
          <b-col>
            <BaseTextarea
              id="monitoringCorrectionalMeasureDescription"
              label="Caso esteja cumprindo medida socioeducativa de PSC registre os contatos relativos ao local de prestação do serviço e do orientador responsável:"
              v-model="monitoringCorrectionalMeasureDescription"
              placeholder=""
              :required="false"
              :disabled="disabled"
              :maxlength="80"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import correctionalMeasuresTypes from '@/models/correctionalMeasuresTypes'
import singleAnswers from '@/models/singleAnswers'

export default {
  name: 'HistoricalOfCorrectionalMeasuresForm',
  mixins: [baseComponent],
  data() {
    return {
      correctionalMeasuresTypes,
      singleAnswers,
      adolescentIdentification: null,
      correctionalMeasureDescription: null,
      correctionalMeasureSelected: null,
      startingDateOfCorrectionalMeasure: null,
      endingDateOfCorrectionalMeasure: null,
      monitoringSocialAssistanceReferenceCentres: null,
      monitoringDateSocialAssistanceReferenceCentres: null,
      monitoringObservationSocialAssistanceReferenceCentres: null,
      monitoringCorrectionalMeasureDescription: null
    }
  },
  methods: {
    addNewCorrectionalMeasure() {}
  },
  watch: {
    correctionalMeasureDescription(newValue) {
      this.correctionalMeasureSelected = 0
      for (let i of correctionalMeasuresTypes) {
        if (i.description === newValue) {
          this.correctionalMeasureSelected = i.id
        }
      }
    }
  }
}
</script>

<style scoped>
.add-new-correctional-measure {
  display: flex;
  align-items: flex-end;
  margin-bottom: 16px;
}
</style>
