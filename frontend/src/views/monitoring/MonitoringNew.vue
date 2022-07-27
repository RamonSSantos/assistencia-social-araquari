<template :visible="visible">
  <div v-if="newObject">
    <div class="main-content__top">
      <div class="main-content__title">
        <h4>
          Registro Sintético de Avaliação de Resultados do Acompanhamento
          Familiar
        </h4>
      </div>
    </div>
    <div class="main-content__body">
      <b-container fluid class="bv-example-row pl-0">
        <BreadCrumb />
        <b-form>
          <b-card bg-variant="light">
            <b-form-group
              id=""
              label="Registro Sintético de Avaliação de Resultados do Acompanhamento Familiar"
              label-size="md"
              label-class="font-weight-bold"
            >
              <b-card-header>
                A Avaliação de Resultados do Acompanhamento Familiar pode ser
                realizada a qualquer momento, a critério do profissional
                responsável. Entretanto, recomenda-se que o registro sintético
                da avaliação de resultados seja preenchido, no mínimo, uma vez a
                cada seis meses durante o período de acompanhamento, e
                obrigatoriamente, sempre que houver o desligamento de uma
                família do PAIF ou PAEFI.
                <br />A Avaliação de Resultados deve ser realizada com a
                participação da família acompanhada (ou indivíduo), e a
                avaliação do profissional também deve considerar as opiniões e
                percepções da própria família (ou indivíduo). Deve, ainda, haver
                especial atenção com a identificação dos fatores que
                contribuíram, ou que dificultaram, o alcance dos resultados
                esperados.
              </b-card-header>
              <b-row>
                <b-col>
                  <InputText
                    id="iduser"
                    label="Nome do Profissional Responsável:"
                    v-model="form.userFullname"
                    :maxlength="80"
                    :required="false"
                    :disabled="!disabled"
                  />
                </b-col>
              </b-row>
              <b-row>
                <b-col>
                  <InputText
                    id="responsibleFamilyMemberIdentification"
                    label="Nome do membro da família:"
                    v-model="form.responsibleFamilyMemberIdentification"
                    placeholder="Membro da família"
                    :maxlength="80"
                    :minlength="8"
                    :required="true"
                    :disabled="disabled"
                  />
                </b-col>
              </b-row>
              <b-row>
                <b-col lg="6" sm="12">
                  <InputDate
                    id="dateOfValuation"
                    label="Data da Avaliação:"
                    v-model="form.dateOfValuation"
                    placeholder="dd/mm/aaaa"
                    :required="true"
                    :disabled="disabled"
                  />
                </b-col>
                <b-col lg="6" sm="12">
                  <InputNumber
                    id="numberOfMonthsOfFamilyMonitoring"
                    label="Número de meses que a família está sendo acompanhada:"
                    v-model="form.numberOfMonthsOfFamilyMonitoring"
                    placeholder=""
                    :maxlength="2"
                    :required="true"
                    :disabled="disabled"
                  />
                </b-col>
              </b-row>
              <b-row>
                <b-col>
                  <BaseRadio
                    id="socialAssistanceOffers"
                    label="Foram efetivamente disponibilizadas para a família/indivíduo todas as ofertas da Assistência Social (em termos de serviços, benefícios, programas e projetos) cuja necessidade havia sido identificada pelo profissional?"
                    v-model="form.socialAssistanceOffers"
                    :radio="specificSingleAnswers"
                    :required="true"
                    :disabled="disabled"
                    :selected="0"
                  />
                </b-col>
              </b-row>
              <b-row>
                <b-col>
                  <BaseRadio
                    id="effectiveService"
                    label="Em relação aos encaminhamentos da família/indivíduo para as demais políticas, houve atendimento efetivo e resolutivo por parte da área que recebeu o(s) encaminhamento(s)?"
                    v-model="form.effectiveService"
                    :radio="otherSpecificSingleAnswers"
                    :required="true"
                    :disabled="disabled"
                    :selected="0"
                  />
                </b-col>
              </b-row>
              <b-row>
                <b-col>
                  <BaseRadio
                    id="serviceMonitoringContributes"
                    label="A família reconhece o Serviço de Acompanhamento como algo que contribui para a superação ou enfrentamento dos seus problemas e dificuldades e deseja continuar recebendo atenções deste serviço?"
                    v-model="form.serviceMonitoringContributes"
                    :radio="specificSingleAnswers"
                    :required="true"
                    :disabled="disabled"
                    :selected="0"
                  />
                </b-col>
              </b-row>
              <b-row>
                <b-col>
                  <BaseRadio
                    id="resultsObtained"
                    label="Como você classifica os resultados obtidos, até o presente momento, no que se refere à ampliação da capacidade de enfrentamento ou superação das condições de vulnerabilidade e/ou risco social e pessoal por parte da família/indivíduo?"
                    v-model="form.resultsObtained"
                    :radio="resultsObtainedTypes"
                    :required="true"
                    :disabled="disabled"
                    :selected="0"
                  />
                </b-col>
              </b-row>
              <b-row>
                <b-col>
                  <BaseTextarea
                    id="resultsObtainedDescription"
                    label="Registre, descritivamente os principais resultados alcançados, bem como fatores que contribuíram ou difilcultaram o alcance dos resultados:"
                    v-model="form.resultsObtainedDescription"
                    placeholder=""
                    :required="false"
                    :disabled="disabled"
                    :maxlength="400"
                  />
                </b-col>
              </b-row>
            </b-form-group>
            <b-row align-h="between">
              <b-col cols="auto" class="mr-auto">
                <BaseButton
                  type="button"
                  id="goToMonitoringPage"
                  buttonName="Cancelar"
                  variant="warning"
                  @click.stop="goToMonitoringPage"
                />
              </b-col>
              <b-col cols="auto">
                <b-button-group>
                  <BaseButton
                    type="button"
                    id="resetForm"
                    buttonName="Limpar"
                    variant="secondary"
                    @click.stop="resetForm"
                  />
                  <BaseButton
                    type="button"
                    id="addNewMonitoring"
                    buttonName="Salvar"
                    variant="outline-info"
                    @click.stop="addNewMonitoring"
                  />
                </b-button-group>
              </b-col>
            </b-row>
          </b-card>
        </b-form>
      </b-container>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import pageVisibility from '@/mixins/pageVisibility'
import resultsObtainedTypes from '@/models/resultsObtainedTypes'
import EventBus from '@/services/EventBus'

export default {
  name: 'MonitoringNew',
  mixins: [pageVisibility],
  data() {
    return {
      resultsObtainedTypes,
      loading: false,
      disabled: false,
      form: {
        userId: null,
        userFullname: null,
        responsibleFamilyMemberIdentification: null,
        dateOfValuation: null,
        numberOfMonthsOfFamilyMonitoring: null,
        socialAssistanceOffers: null,
        effectiveService: null,
        serviceMonitoringContributes: null,
        resultsObtained: null,
        resultsObtainedDescription: null
      },
      specificSingleAnswers: [
        {
          id: 1,
          description: 'Sim'
        },
        {
          id: 2,
          description: 'Parcialmente'
        },
        {
          id: 3,
          description: 'Não'
        }
      ],
      otherSpecificSingleAnswers: []
    }
  },
  created() {
    this.getUserInformation()
    this.otherSpecificSingleAnswers = this.specificSingleAnswers.slice()
    this.otherSpecificSingleAnswers.push({
      id: 4,
      description:
        'Não se aplica, pois não houve necessidade de encaminhamento para outra área'
    })
  },
  methods: {
    ...mapActions('auth', ['ActionGetUser']),
    async getUserInformation() {
      const response = await this.ActionGetUser()
      this.form.userId = response[0]
      this.form.userFullname = response[1]
    },
    addNewMonitoring() {
      //TODO
    },
    resetForm() {
      this.form.responsibleFamilyMemberIdentification = null
      this.form.dateOfValuation = null
      this.form.numberOfMonthsOfFamilyMonitoring = null
      this.form.socialAssistanceOffers = null
      this.form.effectiveService = null
      this.form.serviceMonitoringContributes = null
      this.form.resultsObtained = null
      this.form.resultsObtainedDescription = null
    },
    goToMonitoringPage() {
      EventBus.$emit(this.$route.meta.eventBus)
      this.$router.push({ name: 'Monitoring', params: { page: 1 } })
    }
  }
}
</script>
