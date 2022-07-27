<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="3" sm="6">
        <BaseRadio
          id="enjoySingleRegistry"
          label="Possui Cadastro Único:"
          v-model="object.singleRegistry"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="3" sm="6">
        <BaseRadio
          id="socialInclusionProject"
          label="Inclusão em Projetos Sociais:"
          v-model="object.programType1"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
        <div v-if="object.programType1 === 1">
          <InputText
            id="socialInclusionProjectDescription"
            label="Qual:"
            v-model="object.socialInclusionProjectDescription"
            placeholder="Nome do projeto"
            :maxlength="45"
            :minlength="4"
            :required="true"
            :disabled="disabled"
          />
        </div>
      </b-col>
      <b-col lg="3" sm="6">
        <BaseRadio
          id="socialProgram2"
          label="Tarifa Social de Energia Elétrica:"
          v-model="object.programType2"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="3" sm="6">
        <BaseRadio
          id="socialProgram3"
          label="Tarifa Social de Água:"
          v-model="object.programType3"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="3" sm="6">
        <BaseRadio
          id="youngIdentity"
          label="Identidade Jovem:"
          v-model="object.youngIdentity"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="3" sm="6">
        <BaseRadio
          id="pronatec"
          label="Pronatec:"
          v-model="object.pronatec"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="3" sm="6">
        <BaseRadio
          id="freePass"
          label="Passe Livre (Pessoa com Deficiência):"
          v-model="object.freePass"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="3" sm="6">
        <BaseTextarea
          id="observationSingleRegistry"
          label="Observação:"
          v-model="object.observation"
          placeholder="Observação"
          :required="false"
          :disabled="disabled"
          :maxlength="150"
        />
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import singleAnswers from '@/models/singleAnswers'

export default {
  name: 'SingleRegistryForm',
  mixins: [baseComponent],
  data() {
    return {
      singleAnswers
    }
  }
}
</script>
