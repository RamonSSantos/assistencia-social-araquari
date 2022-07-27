<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="hasWorkCard"
          label="Possui Carteira de Trabalho?"
          v-model="object.hasWorkCard"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="8" sm="12">
        <div v-if="object.hasWorkCard === 1">
          <BaseRadio
            id="remuneratioType"
            label="Condição de Ocupação:"
            v-model="object.remuneratioType"
            :radio="occupationTypes"
            :required="true"
            :disabled="disabled"
            :selected="0"
          />
        </div>
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="remunerationLastMonth"
          label="No mês passado recebeu remuneração de trabalho?"
          v-model="object.remunerationLastMonth"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="8" sm="12">
        <div v-if="object.remunerationLastMonth === 1">
          <InputMoney
            id="grossSalary"
            label="Valor bruto da remuneração efetivamente recebida em todos os trabalhos:"
            v-model="object.grossSalary"
            :required="true"
            :disabled="disabled"
          />
        </div>
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="4" sm="12">
        <BaseRadio
          id="remunerationLastYear"
          label="Houve trabalho remunerado nos últimos 12 meses?"
          v-model="object.remunerationLastYear"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="8" sm="12">
        <InputMoney
          id="grossSalaryPeriod"
          label="Remuneração bruta de todos os trabalhos recebidos nesse período:"
          v-model="object.grossSalaryPeriod"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <div v-if="object.remunerationLastYear === 2">
      <b-card bg-variant="light">
        <b-form-group
          id="remunerations"
          label="Quanto recebe normalmente por mês dê:"
          label-size="md"
          label-class="font-weight-bold"
        >
          <b-row class="my-3">
            <b-col xl="7" sm="7">
              <InputMoney
                id="donation"
                label="Ajuda/doação regular de não morador"
                v-model="object.donation"
                :required="false"
                :disabled="donationChecked"
              />
            </b-col>
            <b-col class="mt-xl-4 pt-xl-4 mt-md-5 mt-sm-5 pt-sm-4">
              <b-form-checkbox v-model="donationChecked">
                Não recebe
              </b-form-checkbox>
            </b-col>
          </b-row>
          <b-row class="my-3">
            <b-col xl="7" sm="7">
              <InputMoney
                id="retired"
                label="Aposentadoria, aposentadoria rural, pensão ou BPC/LOAS"
                v-model="object.retired"
                :required="false"
                :disabled="retiredChecked"
              />
            </b-col>
            <b-col class="mt-xl-4 pt-xl-4 mt-md-4 mt-sm-5 pt-sm-5">
              <b-form-checkbox v-model="retiredChecked">
                Não recebe
              </b-form-checkbox>
            </b-col>
          </b-row>
          <b-row class="my-3">
            <b-col xl="7" sm="7">
              <InputMoney
                id="unemploymentInsurance"
                label="Seguro Desemprego"
                v-model="object.unemploymentInsurance"
                :required="false"
                :disabled="unemploymentInsuranceChecked"
              />
            </b-col>
            <b-col class="mt-sm-5">
              <b-form-checkbox v-model="unemploymentInsuranceChecked">
                Não recebe
              </b-form-checkbox>
            </b-col>
          </b-row>
          <b-row class="my-3">
            <b-col xl="7" sm="7">
              <InputMoney
                id="pensionFood"
                label="Pensão Alimentícia"
                v-model="object.pensionFood"
                :required="false"
                :disabled="pensionFoodChecked"
              />
            </b-col>
            <b-col class="mt-sm-5">
              <b-form-checkbox v-model="pensionFoodChecked">
                Não recebe
              </b-form-checkbox>
            </b-col>
          </b-row>
          <b-row class="my-3">
            <b-col xl="7" sm="7">
              <InputMoney
                id="otherRemuneration"
                label="Outras fontes de remuneração exceto bolsa família ou outras transferências similares"
                v-model="object.otherRemuneration"
                :required="false"
                :disabled="otherRemunerationChecked"
              />
            </b-col>
            <b-col class="mt-lg-5 pt-lg-4 mt-sm-5 pt-sm-5">
              <b-form-checkbox v-model="otherRemunerationChecked">
                Não recebe
              </b-form-checkbox>
            </b-col>
          </b-row>
        </b-form-group>
      </b-card>
    </div>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import occupationTypes from '@/models/occupationTypes'
import singleAnswers from '@/models/singleAnswers'

export default {
  name: 'HouseholdRemunerationForm',
  mixins: [baseComponent],
  data() {
    return {
      occupationTypes,
      singleAnswers,
      donationChecked: true,
      retiredChecked: true,
      unemploymentInsuranceChecked: true,
      pensionFoodChecked: true,
      otherRemunerationChecked: true
    }
  }
}
</script>
