<template :visible="visible">
  <b-form v-if="object">
    <b-tabs v-model="tabIndex" active-nav-item-class="font-weight-bold" card>
      <b-tab v-for="tab in tabs" :key="tab.id" :title="tab.title">
        <div v-if="tab.id === 1">
          <b-card bg-variant="light" class="mt-3">
            <b-form-group
              id="planningOfFamilyMonitoringGroup"
              label="Registro de ingresso e de Desligamento da Família ou Indivíduo no Acompanhamento do PAIF ou PAEFI"
              label-size="md"
              label-class="font-weight-bold"
            >
              <b-row>
                <b-col lg="6" sm="12">
                  <InputDate
                    id="entryDate"
                    label="Data de Ingresso:"
                    v-model="entryDate"
                    placeholder="dd/mm/aaaa"
                    :required="true"
                    :disabled="disabled"
                  />
                </b-col>
                <b-col lg="6" sm="12">
                  <InputDate
                    id="resignationDate"
                    label="Data de Desligamento:"
                    v-model="resignationDate"
                    placeholder="dd/mm/aaaa"
                    :required="false"
                    :disabled="disabled"
                  />
                </b-col>
              </b-row>
              <b-row>
                <b-col lg="9" sm="8" v-if="resignationDate">
                  <InputDataList
                    id="reasonForResignation"
                    datalist="reasonsForResignationList"
                    label="Razões para o Desligamento:"
                    v-model="reasonForResignation"
                    :sizes="reasonsForResignation"
                    placeholder=""
                    :required="true"
                    :disabled="disabled"
                  />
                </b-col>
                <b-col
                  lg="3"
                  sm="4"
                  class="add-new-entry-or-resignation-of-family-monitoring"
                >
                  <BaseButton
                    type="button"
                    id="addNewEntryOrResignationOfFamilyMonitoring"
                    buttonName="Salvar"
                    variant="outline-primary"
                    @click.stop="addNewEntryOrResignationOfFamilyMonitoring"
                  />
                </b-col>
              </b-row>
            </b-form-group>
            <b-card-sub-title>PLANEJAMENTO INICIAL:</b-card-sub-title>
            <b-card-footer>
              O planejamento inicial deve ser elaborado de forma dialogada com a
              família/indivíduo e considerar de forma particularizada as
              necessidades e as potencialidades de cada família. Nele se
              identificam os objetivos a serem perseguidos e as possíveis ações
              e estratégias para alcançá-los. Embora não deva ser encarada de
              forma rígida, o planejamento inicial ajuda a nortear o trabalho a
              ser desenvolvido com a família/indivíduo e a avaliar sua evolução.
            </b-card-footer>
            <b-row>
              <b-col>
                <BaseTextarea
                  id="planningOfFamilyMonitoringDescription"
                  label="Atenção! Toda anotação incluída neste espaço deve ser preenchida de data, nome e função do profissional responsável pela mesma"
                  v-model="planningOfFamilyMonitoringDescription"
                  placeholder=""
                  :required="false"
                  :disabled="disabled"
                  :maxlength="1000"
                />
              </b-col>
            </b-row>
          </b-card>
        </div>
        <template v-else-if="tab.id === 2">
          <b-card bg-variant="light" class="mt-3">
            <b-form-group
              id="progressOfFamilyMonitoringGroup"
              label="Evolução do Acompanhamento Familiar"
              label-size="md"
              label-class="font-weight-bold"
            >
            </b-form-group>
            <b-card-footer>
              Entende-se por
              <strong>evolução do acompanhamento familiar</strong> todo o
              processo que se segue ao contato inicial com a família/indivíduo,
              por meio do qual o profissional aprofunda seu conhecimento sobre a
              realidade específica daquela família, planeja e realiza ações para
              alcance de determinados objetivos e avalia os resultados
              alcançados.
              <p class="mt-3">
                Este espaço é destinado às anotações qualitativas sobre aspectos
                importantes da vida familiar que venham a ser identificados
                durante o processo de acompanhamento. Deve, também, ser
                utilizado para anotações pertinentes aos procedimentos e
                atividades desenvolvidas com a família e para avaliação dos
                resultados obtidos.
              </p>
            </b-card-footer>
            <b-row>
              <b-col>
                <BaseTextarea
                  id="progressOfFamilyMonitoringDescription"
                  label="Atenção! Toda anotação incluída neste espaço deve ser preenchida de data, nome e função do profissional responsável pela mesma"
                  v-model="progressOfFamilyMonitoringDescription"
                  placeholder=""
                  :required="false"
                  :disabled="disabled"
                  :maxlength="1000"
                />
              </b-col>
            </b-row>
          </b-card>
        </template>
      </b-tab>
    </b-tabs>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import reasonsForResignation from '@/models/reasonsForResignation'

export default {
  name: 'PlanningAndProgressOfFamilyMonitoringForm',
  mixins: [baseComponent],
  data() {
    return {
      reasonsForResignation,
      tabs: [
        {
          id: 1,
          title: 'Registro de Ingresso e de Desligamento'
        },
        {
          id: 2,
          title: 'Evolução do Acompanhamento Familiar'
        }
      ],
      tabIndex: 0,
      entryDate: null,
      resignationDate: null,
      reasonForResignation: null,
      planningOfFamilyMonitoringDescription: null,
      progressOfFamilyMonitoringDescription: null
    }
  },
  methods: {
    addNewEntryOrResignationOfFamilyMonitoring() {}
  }
}
</script>

<style scoped>
.add-new-entry-or-resignation-of-family-monitoring {
  display: flex;
  align-items: flex-end;
  margin-bottom: 16px;
}
</style>
