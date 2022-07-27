<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="6" sm="12">
        <InputMoney
          id="familyGrossSalary"
          label="Renda total da família: (sem considerar a renda recebida de programas sociais)"
          v-model="familyGrossSalary"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="6" sm="12">
        <InputMoney
          id="perCapitaIncome"
          label="Renda familiar per capita: (sem considerar a renda recebida de programas sociais)"
          v-model="perCapitaIncome"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="familyReceivesMoneyFromSocialProgram"
          label="A família recebe dinheiro de algum Programa Social?"
          v-model="familyReceivesMoneyFromSocialProgram"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="moneyReceivedForTheFamilyGroup"
        label="Anote os valores recebidos pela família por meio de Programas Sociais:"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="6" sm="12">
            <InputMoney
              id="bolsaFamilia"
              label="Bolsa Família"
              v-model="moneyReceivedForTheFamily.bolsaFamilia"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="6" sm="12">
            <InputMoney
              id="bpc"
              label="BPC"
              v-model="moneyReceivedForTheFamily.bpc"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="6" sm="12">
            <InputMoney
              id="peti"
              label="PETI"
              v-model="moneyReceivedForTheFamily.peti"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="6" sm="12">
            <InputMoney
              id="others"
              label="Outros"
              v-model="moneyReceivedForTheFamily.others"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
    <b-row>
      <b-col>
        <InputText
          id="continuousCashBenefit"
          label="Para famílias que recebem o BPC, identifique a(s) pessoa(s) beneficiária(s):"
          v-model="continuousCashBenefit"
          placeholder="Nome do membro familiar"
          :maxlength="80"
          :minlength="8"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6" sm="12">
        <InputMoney
          id="familyGrossSalaryWithSocialProgram"
          label="Qual a renda total da família, incluído o valor recebido de programas sociais?"
          v-model="familyGrossSalaryWithSocialProgram"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="6" sm="12">
        <InputMoney
          id="perCapitaIncomeWithSocialProgram"
          label="Qual a renda familiar per capita, incluído o valor recebido de programas sociais?"
          v-model="perCapitaIncomeWithSocialProgram"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-card-footer>
      Atenção! Fique atento para identificar famílias potencialmente elegíveis
      aos programas de transferência de renda e que ainda não recebem o
      benefício ao qual têm direito. Observe sempre as regras específicas de
      cada Programa/Benefício.
    </b-card-footer>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import singleAnswers from '@/models/singleAnswers'

export default {
  name: 'FamilyIncomeForm',
  mixins: [baseComponent],
  data() {
    return {
      singleAnswers,
      familyGrossSalary: null,
      perCapitaIncome: null,
      familyReceivesMoneyFromSocialProgram: null,
      moneyReceivedForTheFamily: {
        bolsaFamilia: null,
        bpc: null,
        peti: null,
        others: null
      },
      continuousCashBenefit: null,
      familyGrossSalaryWithSocialProgram: null,
      perCapitaIncomeWithSocialProgram: null
    }
  }
}
</script>
