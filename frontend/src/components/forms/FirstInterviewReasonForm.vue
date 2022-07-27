<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col>
        <BaseRadio
          id="wayToGetFirstInterview"
          label="De que forma a família (ou membro da família) acessou a Unidade para o primeiro atendimento?"
          v-model="wayToGetFirstInterview"
          :radio="waysToGetFirstInterview"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row v-if="wayToGetFirstInterview === 11">
      <b-col>
        <InputText
          id="governmentAgencyDescription"
          label="Sempre que o acesso for decorrente de algum encaminhamento, identifique detalhadamente o Nome e Contato do órgão/unidade que encaminhou o usuário:"
          v-model="governmentAgencyDescription"
          placeholder="Nome e Contato do órgão/unidade"
          :maxlength="120"
          :minlength="8"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <BaseTextarea
          id="firstInterviewReason"
          label="Quais as razões, demandas ou necessidades que motivaram este primeiro atendimento?"
          v-model="firstInterviewReason"
          placeholder="Observação"
          :required="false"
          :disabled="disabled"
          :maxlength="150"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="beneficiarySocialProgramme"
          label="Assinale abaixo caso a família, ou algum de seus membros, seja beneficiária de algum dos seguintes Programas Sociais:"
          v-model="beneficiarySocialProgramme"
          :radio="socialProgrammeSimplifiedTypes"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6" sm="12" v-if="beneficiarySocialProgramme === 4">
        <InputText
          id="beneficiarySocialProgrammeDescription"
          label="Descrição do Programa Social"
          v-model="beneficiarySocialProgrammeDescription"
          placeholder="Descrição"
          :maxlength="80"
          :minlength="8"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import waysToGetFirstInterview from '@/models/waysToGetFirstInterview'
import { socialProgrammeSimplifiedTypes } from '@/models/socialProgrammeTypes'

export default {
  name: 'FirstInterviewReasonForm',
  mixins: [baseComponent],
  data() {
    return {
      waysToGetFirstInterview,
      socialProgrammeSimplifiedTypes,
      wayToGetFirstInterview: null,
      governmentAgencyDescription: null,
      firstInterviewReason: null,
      beneficiarySocialProgramme: null,
      beneficiarySocialProgrammeDescription: null
    }
  }
}
</script>
