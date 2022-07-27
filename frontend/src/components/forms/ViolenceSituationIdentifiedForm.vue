<template :visible="visible">
  <b-form v-if="object">
    <b-card
      sub-title="QUADRO 3 - EXCLUSIVO PARA UTILIZAÇÃO DO CREAS"
      bg-variant="light"
      class="mt-3"
    >
      <b-form-group
        id="violenceSituationIdentifiedGroup"
        label="Registro obrigatório de situações de violência e violações de direitos identificados no grupo familiar"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-card-text>
          Utilize este quadro para registrar situações de violência e/ou
          violação de direitos, atuais ou recentes, ocorridos com membros da
          família. Estas situações podem ter sido detectadas pelo profissional
          do CREAS durante o atendimento da família/indivíduo, ou já serem de
          conhecimento prévio, no caso em que constituem a razão pela qual a
          família foi incluída em acompanhamento pelo PAEFI.
        </b-card-text>
        <b-row>
          <b-col lg="6" sm="12">
            <InputText
              id="victimIdentification"
              label="Identificação da pessoa vitimada:"
              v-model="victimIdentification"
              placeholder="Pessoa vitimada"
              :maxlength="80"
              :minlength="8"
              :required="true"
              :disabled="disabled"
              :autofocus="true"
            />
          </b-col>
          <b-col lg="6" sm="12">
            <InputDataList
              id="violenceSituationIdentifiedType"
              datalist="violenceSituationsIdentifiedList"
              label="Situação:"
              v-model="violenceSituationIdentifiedType"
              :sizes="violenceSituationSimplifiedTypes"
              placeholder="Situação"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="5" sm="4">
            <BaseRadio
              id="violenceSituationIdentifiedStatus"
              label="Indício ou Confirmada"
              v-model="violenceSituationIdentifiedStatus"
              :radio="violenceSituationAnswers"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
          <b-col lg="5" sm="4">
            <InputDate
              id="violenceSituationIdentifiedDate"
              label="Data da anotação:"
              v-model="violenceSituationIdentifiedDate"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="2" sm="4" class="add-new-violence-situation-button">
            <BaseButton
              type="button"
              id="addNewViolenceSituationIdentified"
              buttonName="Salvar"
              variant="outline-primary"
              @click.stop="addNewViolenceSituationIdentified"
            />
          </b-col>
        </b-row>
      </b-form-group>
      <b-card-footer>
        Todo registro incluído neste quadro deve ser transposto sem a
        identificação da pessoa para o Mapa Consolidado de Registros
        Obrigatórios deste CREAS. Além disso, o profissional deve ficar atento
        para a sua responsabilidade de notificar os Órgãos do Sistema de
        Garantia de Direitos e preencher a Ficha de Notificação nos casos em que
        for pertinente.
      </b-card-footer>
    </b-card>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import { violenceSituationSimplifiedTypes } from '@/models/violenceSituationsTypes'

export default {
  name: 'ViolenceSituationIdentifiedForm',
  mixins: [baseComponent],
  data() {
    return {
      violenceSituationSimplifiedTypes,
      violenceSituationAnswers: [
        {
          id: 1,
          description: 'Indício'
        },
        {
          id: 2,
          description: 'Confirmada'
        }
      ],
      victimIdentification: null,
      violenceSituationIdentifiedType: null,
      violenceSituationIdentifiedStatus: null,
      violenceSituationIdentifiedDate: null
    }
  },
  methods: {
    addNewViolenceSituationIdentified() {}
  }
}
</script>

<style scoped>
.add-new-violence-situation-button {
  display: flex;
  align-items: center;
}
</style>
