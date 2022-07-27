<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col>
        <InputText
          id="fullname"
          label="Nome completo:"
          v-model="object.fullname"
          placeholder="Nome completo"
          :maxlength="80"
          :minlength="4"
          :required="true"
          :disabled="disabled"
          :autofocus="true"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="4" sm="12">
        <InputDate
          id="dateOfBirth"
          label="Data de nascimento:"
          v-model="object.dateOfBirth"
          placeholder="dd/mm/aaaa"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="4" sm="12">
        <InputDataList
          id="maritalStatus"
          datalist="maritalStatusList"
          label="Estado Civil:"
          v-model="object.maritalStatus"
          :sizes="maritalStatus"
          placeholder="Estado Civil"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="4" sm="12">
        <InputDataList
          id="genre"
          datalist="genreList"
          label="Sexo:"
          v-model="object.genre"
          :sizes="genres"
          placeholder="Sexo"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <InputText
          id="filiation"
          label="Filiação:"
          v-model="object.filiation"
          placeholder="Filiação"
          :maxlength="80"
          :minlength="4"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="4" sm="12">
        <InputTextCpf
          id="cpf"
          label="CPF:"
          v-model="object.cpf"
          placeholder="CPF"
          :minlength="14"
          :maxlength="14"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="4" sm="12">
        <InputText
          id="rg"
          label="RG:"
          v-model="object.rg"
          placeholder="RG"
          :minlength="7"
          :maxlength="16"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="4" sm="12">
        <InputTextWithMask
          id="nis"
          label="NIS:"
          v-model="object.nis"
          mask="###########"
          placeholder="NIS"
          :minlength="11"
          :maxlength="11"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import maritalStatus from '@/models/maritalStatus'
import genres from '@/models/genres'

export default {
  name: 'FamilyReferenceIdentificationForm',
  mixins: [baseComponent],
  data() {
    return {
      maritalStatus,
      genres
    }
  }
}
</script>
