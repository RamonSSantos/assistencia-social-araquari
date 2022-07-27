<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="6">
        <InputText
          id="fullname"
          label="Nome completo:"
          v-model="object.fullname"
          placeholder="Nome completo"
          :maxlength="45"
          :minlength="4"
          :required="true"
          :disabled="disabled"
          :autofocus="true"
        />
      </b-col>
      <b-col lg="6">
        <InputTextCpf
          id="cpf"
          label="CPF:"
          v-model="object.cpf"
          placeholder="CPF"
          :minlength="14"
          :maxlength="14"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <BaseTextarea
          id="observation"
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

export default {
  name: 'InterviewerForm',
  mixins: [baseComponent]
}
</script>
