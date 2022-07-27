<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col>
        <BaseRadio
          id="householdConstantCare"
          label="A família possui algum integrante que, devido ao envelhecimento ou à doença, necessite de cuidados constantes de outra pessoa para realizar atividades básicas, tais como, tomar banho, alimentar-se, ficar só em casa, locomover-se dentro de casa etc.?"
          v-model="householdConstantCare"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row v-if="householdConstantCare === 1">
      <b-col lg="5" sm="4">
        <InputText
          id="householdConstantCareIdentification"
          label="Informe o nome do membro da família:"
          v-model="householdConstantCareIdentification"
          placeholder="Membro familiar"
          :maxlength="80"
          :minlength="8"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="5" sm="4">
        <InputText
          id="householdCaregiver"
          label="Quem é o responsável pelo cuidado:"
          v-model="householdCaregiver"
          placeholder=""
          :maxlength="80"
          :minlength="8"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="2" sm="4" class="add-new-household-constant-care">
        <BaseButton
          type="button"
          id="addNewHouseholdConstantCare"
          buttonName="Salvar"
          variant="outline-primary"
          @click.stop="addNewHouseholdConstantCare"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <BaseRadio
          id="foodInsecuritySituation"
          label="A família declara, ou fornece indícios, de que vivencia situação de insegurança alimentar devido a insuficiência de alimentos?"
          v-model="foodInsecuritySituation"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import singleAnswers from '@/models/singleAnswers'

export default {
  name: 'FamilyHealthConditionForm',
  mixins: [baseComponent],
  data() {
    return {
      singleAnswers,
      householdConstantCare: null,
      householdConstantCareIdentification: null,
      householdCaregiver: null,
      foodInsecuritySituation: null
    }
  },
  methods: {
    addNewHouseholdConstantCare() {}
  }
}
</script>

<style scoped>
.add-new-household-constant-care {
  display: flex;
  align-items: flex-end;
  margin-bottom: 16px;
}
</style>
