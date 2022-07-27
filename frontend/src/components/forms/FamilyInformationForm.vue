<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="indigenousFamily"
          label="A família é indígena?"
          v-model="indigenousFamily"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6" sm="12" v-if="indigenousFamily === 1">
        <InputText
          id="ethnicity"
          label="A que povo indígena pertence a família?"
          v-model="object.ethnicity"
          placeholder="Nome da aldeia"
          :maxlength="45"
          :minlength="4"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row v-if="indigenousFamily === 1">
      <b-col lg="3" sm="12">
        <BaseRadio
          id="indigenousLand"
          label="A família reside em terra ou reserva indígena?"
          v-model="indigenousLand"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6" sm="8" v-if="indigenousLand === 1">
        <InputText
          id="indianVillage"
          label="Qual é o nome da terra ou reserva indígena?"
          v-model="object.indianVillage"
          placeholder="Nome da terra indígena"
          :maxlength="45"
          :minlength="4"
          :required="false"
          :disabled="indianVillageStatus"
        />
      </b-col>
      <b-col lg="3" sm="4" v-if="indigenousLand === 1" class="mt-lg-5 mt-sm-5">
        <b-form-checkbox v-model="indianVillageStatus">
          Não sabe
        </b-form-checkbox>
      </b-col>
    </b-row>
    <b-row v-if="indigenousFamily === 2">
      <b-col lg="6" sm="12">
        <BaseRadio
          id="quilombolaCommunity"
          label="A família é quilombola?"
          v-model="quilombolaCommunity"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6" sm="12" v-if="quilombolaCommunity === 1">
        <InputText
          id="community"
          label="Qual é o nome da comunidade quilombola?"
          v-model="object.community"
          placeholder="Nome da comunidade quilombola"
          :maxlength="45"
          :minlength="4"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row v-if="indigenousLand === 2 || quilombolaCommunity === 2">
      <b-col lg="6" sm="12">
        <InputNumber
          id="amountResidents"
          label="Quantas pessoas moram no seu domicílio? (Não preencher para famílias em situação de rua e famílias em domicílio coletivo)"
          v-model="object.amountResidents"
          placeholder="Número"
          :maxlength="2"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="6" sm="12">
        <InputNumber
          id="amountFamilies"
          label="Quantas famílias moram no seu domicílio? (Não preencher para famílias em situação de rua e famílias em domicílio coletivo)"
          v-model="object.amountFamilies"
          placeholder="Número"
          :maxlength="2"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="hospitalizedPerson"
        label="Há alguma pessoa dessa família internada, abrigada ou privada de liberdade há 12 meses ou mais?"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="9" sm="8">
            <InputNumber
              id="hospitalizedChild"
              label="1 - Criança(s) e adolescente(s) (de 0 a 17 anos)"
              v-model="hospitalizedChild"
              placeholder="Número"
              :maxlength="2"
              :required="false"
              :disabled="hospitalizedChildStatus"
            />
          </b-col>
          <b-col lg="3" sm="4" class="mt-lg-5 mt-sm-5">
            <b-form-checkbox v-model="hospitalizedChildStatus">
              Não tem
            </b-form-checkbox>
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="9" sm="8">
            <InputNumber
              id="hospitalizedAdult"
              label="2 - Jovem(ns) e adulto(s) (de 18 a 59 anos)"
              v-model="hospitalizedAdult"
              placeholder="Número"
              :maxlength="2"
              :required="false"
              :disabled="hospitalizedAdultStatus"
            />
          </b-col>
          <b-col lg="3" sm="4" class="mt-lg-5 mt-sm-5">
            <b-form-checkbox v-model="hospitalizedAdultStatus">
              Não tem
            </b-form-checkbox>
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="9" sm="8">
            <InputNumber
              id="hospitalizedElderly"
              label="3 - Idoso(s) (de 60 anos ou mais)"
              v-model="hospitalizedElderly"
              placeholder="Número"
              :maxlength="2"
              :required="false"
              :disabled="hospitalizedElderlyStatus"
            />
          </b-col>
          <b-col lg="3" sm="4" class="mt-lg-5 mt-sm-5">
            <b-form-checkbox v-model="hospitalizedElderlyStatus">
              Não tem
            </b-form-checkbox>
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="familyHasExpense"
        label="A família, normalmente, tem despesa mensal com:"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="9" sm="8">
            <InputMoney
              id="electricalExpense"
              label="1 - Energia elétrica"
              v-model="object.electricalExpense"
              :required="false"
              :maxlength="9"
              :disabled="electricalExpenseStatus"
            />
          </b-col>
          <b-col lg="3" sm="4" class="mt-lg-5 mt-sm-5">
            <b-form-checkbox v-model="electricalExpenseStatus">
              Não tem
            </b-form-checkbox>
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="9" sm="8">
            <InputMoney
              id="waterAndSewerExpense"
              label="2 - Água e esgoto"
              v-model="object.waterAndSewerExpense"
              :required="false"
              :maxlength="9"
              :disabled="waterAndSewerExpenseStatus"
            />
          </b-col>
          <b-col lg="3" sm="4" class="mt-lg-5 mt-sm-5">
            <b-form-checkbox v-model="waterAndSewerExpenseStatus">
              Não tem
            </b-form-checkbox>
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="9" sm="8">
            <InputMoney
              id="cookingGasExpense"
              label="3 - Gás, carvão e lenha"
              v-model="object.cookingGasExpense"
              :required="false"
              :maxlength="9"
              :disabled="cookingGasExpenseStatus"
            />
          </b-col>
          <b-col lg="3" sm="4" class="mt-lg-5 mt-sm-5">
            <b-form-checkbox v-model="cookingGasExpenseStatus">
              Não tem
            </b-form-checkbox>
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="9" sm="8">
            <InputMoney
              id="foodExpense"
              label="4 - Alimentação, higiene e limpeza"
              v-model="object.foodExpense"
              :required="false"
              :maxlength="9"
              :disabled="foodExpenseStatus"
            />
          </b-col>
          <b-col lg="3" sm="4" class="mt-lg-5 mt-sm-5">
            <b-form-checkbox v-model="foodExpenseStatus">
              Não tem
            </b-form-checkbox>
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="9" sm="8">
            <InputMoney
              id="transportationExpense"
              label="5 - Transporte"
              v-model="object.transportationExpense"
              :required="false"
              :maxlength="9"
              :disabled="transportationExpenseStatus"
            />
          </b-col>
          <b-col lg="3" sm="4" class="mt-lg-5 mt-sm-5">
            <b-form-checkbox v-model="transportationExpenseStatus">
              Não tem
            </b-form-checkbox>
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="9" sm="8">
            <InputMoney
              id="rentExpense"
              label="6 - Aluguel"
              v-model="object.rentExpense"
              :required="false"
              :maxlength="9"
              :disabled="rentExpenseStatus"
            />
          </b-col>
          <b-col lg="3" sm="4" class="mt-lg-5 mt-sm-5">
            <b-form-checkbox v-model="rentExpenseStatus">
              Não tem
            </b-form-checkbox>
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="9" sm="8">
            <InputMoney
              id="medicalExpense"
              label="7 - Medicamentos de uso regular"
              v-model="object.medicalExpense"
              :required="false"
              :maxlength="9"
              :disabled="medicalExpenseStatus"
            />
          </b-col>
          <b-col lg="3" sm="4" class="mt-lg-5 mt-sm-5">
            <b-form-checkbox v-model="medicalExpenseStatus">
              Não tem
            </b-form-checkbox>
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import singleAnswers from '@/models/singleAnswers'

export default {
  name: 'FamilyInformationForm',
  mixins: [baseComponent],
  data() {
    return {
      singleAnswers,
      indigenousFamily: null,
      indigenousLand: null,
      indianVillageStatus: false,
      quilombolaCommunity: null,
      hospitalizedChild: null,
      hospitalizedChildStatus: true,
      hospitalizedAdult: null,
      hospitalizedAdultStatus: true,
      hospitalizedElderly: null,
      hospitalizedElderlyStatus: true,
      electricalExpenseStatus: true,
      waterAndSewerExpenseStatus: true,
      cookingGasExpenseStatus: true,
      foodExpenseStatus: true,
      transportationExpenseStatus: true,
      rentExpenseStatus: true,
      medicalExpenseStatus: true
    }
  }
}
</script>
