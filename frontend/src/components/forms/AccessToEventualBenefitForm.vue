<template :visible="visible">
  <b-form v-if="object">
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="accessToEventualBenefitGroup"
        label="Registro de concessão de Benefícios Eventuais da Assistencia Social:"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col>
            <BaseRadio
              id="eventualBenefitType"
              label="Tipo de Benefício:"
              v-model="eventualBenefitType"
              :radio="eventualBenefitTypes"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="4" sm="12">
            <InputDate
              id="date"
              label="Data:"
              v-model="date"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="8" sm="12">
            <BaseTextarea
              id="eventualBenefitDescription"
              label="Observação:"
              v-model="eventualBenefitDescription"
              placeholder=""
              :required="false"
              :disabled="disabled"
              :maxlength="80"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col v-if="eventualBenefitType === 1">
            <InputText
              id="registration"
              label="Nº do Registro de Nascimento da criança:"
              v-model="registration"
              placeholder="Matrícula"
              :maxlength="32"
              :minlength="32"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col v-else-if="eventualBenefitType === 2">
            <InputTextCpf
              id="cpf"
              label="Nº do CPF da pessoa falecida:"
              v-model="cpf"
              placeholder="CPF"
              :minlength="14"
              :maxlength="14"
              :required="true"
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
import eventualBenefitTypes from '@/models/eventualBenefitTypes'

export default {
  name: 'AccessToEventualBenefitForm',
  mixins: [baseComponent],
  data() {
    return {
      eventualBenefitTypes,
      date: null,
      eventualBenefitType: null,
      eventualBenefitDescription: null,
      registration: null,
      cpf: null
    }
  }
}
</script>
