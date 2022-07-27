<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col>
        <BaseCheckbox
          id="socialFoodProgrammeType"
          label="Indique abaixo se a família ou algum membro da família é beneficiário de algum programa da Secretaria Nacional de Segurança Alimentar e Nutricional – SESAN."
          v-model="object.socialFoodProgrammeType"
          :checkbox="socialFoodProgrammeTypes"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <BaseRadio
          id="slaveLabourRescue"
          label="Indique abaixo se algum membro da família foi resgatado do trabalho análogo ao de escravo por órgão do governo (Ministério do Trabalho, Polícia Federal, etc.)"
          v-model="object.slaveLabourRescue"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <BaseCheckbox
          id="ministryOfMinesAndEnergySocialProgrammeType"
          label="Indique abaixo se a família ou algum membro da família é beneficiário de algum programa do Ministério de Minas e Energia."
          v-model="object.ministryOfMinesAndEnergySocialProgrammeType"
          :checkbox="ministryOfMinesAndEnergySocialProgrammeTypes"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="consumerUnitGroup"
        label="Preencha o campo abaixo com o número/código de identificação da unidade consumidora, indicado na conta de energia elétrica do domicílio."
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col>
            <InputNumber
              id="consumerUnit"
              label="Código da unidade consumidora:"
              v-model="object.consumerUnit"
              placeholder="Código da unidade consumidora"
              :maxlength="20"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
    <b-row>
      <b-col>
        <BaseCheckbox
          id="socialProgrammeType"
          label="Indique abaixo se algum membro da família recebe algum benefício ou é atendido por algum programa da Assistência Social."
          v-model="object.socialProgrammeType"
          :checkbox="socialProgrammeDetailedTypes"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="ministryOfCitiesProgrammeTypesGroup"
        label="Indique abaixo se a família ou algum membro da família é beneficiário de algum programa do Ministério das Cidades."
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-card sub-title="Lista de Programas">
          <b-card-body>
            <b-card-text
              v-for="item in ministryOfCitiesProgrammeTypes"
              :key="item.id"
              >{{ item.description }}</b-card-text
            >
            <b-button v-b-modal.new-benefit>Novo Benefício</b-button>
            <b-modal id="new-benefit" title="Dados do Benefício">
              <b-form>
                <InputNumber
                  id="programmeNumber"
                  label="Nº do programa acima listado:"
                  v-model="programmeNumber"
                  placeholder=""
                  :maxlength="1"
                  :required="true"
                  :disabled="disabled"
                />
                <InputText
                  id="programmeOrigin"
                  label="Natureza do benefício:"
                  v-model="programmeOrigin"
                  placeholder=""
                  :maxlength="45"
                  :minlength="3"
                  :required="true"
                  :disabled="disabled"
                />
                <InputNumber
                  id="programmeContractNumber"
                  label="Número do contrato:"
                  v-model="programmeContractNumber"
                  placeholder=""
                  :maxlength="14"
                  :required="true"
                  :disabled="disabled"
                />
              </b-form>
              <template v-slot:modal-footer>
                <BaseButton
                  type="reset"
                  id="resetNewBenefitForm"
                  buttonName="Limpar"
                  variant="outline-secondary"
                  @click.stop="resetNewBenefitForm"
                />
                <BaseButton
                  type="submit"
                  id="newBenefit"
                  buttonName="Cadastrar"
                  variant="outline-info"
                  @click.stop="addNewBenefit"
                />
              </template>
            </b-modal>
          </b-card-body>
        </b-card>
      </b-form-group>
    </b-card>
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="traditionalPopulationGroup"
        label="Indique abaixo se sua família pertence a algum grupo populacional tradicional ou específico."
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="3" md="5" sm="12">
            <InputNumber
              id="traditionalPopulationGroupCode"
              label="Código:"
              v-model="traditionalPopulationGroupCode"
              placeholder=""
              :maxlength="3"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="9" md="7" sm="12">
            <InputText
              id="traditionalPopulationGroupDescription"
              label="Descrição:"
              v-model="traditionalPopulationGroupDescription"
              placeholder="Descrição"
              :maxlength="45"
              :minlength="3"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import socialFoodProgrammeTypes from '@/models/socialFoodProgrammeTypes'
import singleAnswers from '@/models/singleAnswers'
import ministryOfMinesAndEnergySocialProgrammeTypes from '@/models/ministryOfMinesAndEnergySocialProgrammeTypes'
import { socialProgrammeDetailedTypes } from '@/models/socialProgrammeTypes'
import ministryOfCitiesProgrammeTypes from '@/models/ministryOfCitiesProgrammeTypes'

export default {
  name: 'LinkingToProgramsAndServices',
  mixins: [baseComponent],
  data() {
    return {
      socialFoodProgrammeTypes,
      singleAnswers,
      ministryOfMinesAndEnergySocialProgrammeTypes,
      socialProgrammeDetailedTypes,
      ministryOfCitiesProgrammeTypes,
      traditionalPopulationGroupCode: null,
      traditionalPopulationGroupDescription: null,
      programmeNumber: null,
      programmeOrigin: null,
      programmeContractNumber: null
    }
  },
  methods: {
    resetNewBenefitForm() {
      this.programmeNumber = null
      this.programmeOrigin = null
      this.programmeContractNumber = null
    },
    addNewBenefit() {
      //TODO
    }
  }
}
</script>
