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
        <InputText
          id="nickname"
          label="Apelido:"
          v-model="object.nickname"
          placeholder="Apelido"
          :maxlength="30"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="4" sm="6">
        <InputDate
          id="dateOfBirth"
          label="Data de nascimento:"
          v-model="object.dateOfBirth"
          placeholder="dd/mm/aaaa"
          :required="true"
          :disabled="disabled"
        />
      </b-col>
      <b-col lg="4" sm="6">
        <InputNumber
          id="age"
          label="Idade:"
          v-model="object.age"
          placeholder="Idade"
          :maxlength="3"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6" sm="12">
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
      <b-col lg="6" sm="12">
        <InputDataList
          id="race"
          datalist="raceList"
          label="Cor ou raça:"
          v-model="object.race"
          :sizes="races"
          placeholder="Cor ou raça"
          :required="false"
          :disabled="disabled"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <BaseRadio
          id="familyReferenceInteraction"
          label="Relação de parentesco (nome) com a pessoa Responsável pela Unidade Familiar - RF:"
          v-model="object.familyReferenceInteraction"
          :radio="familyReferenceInteractions"
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
import genres from '@/models/genres'
import familyReferenceInteractions from '@/models/familyReferenceInteractions'
import races from '@/models/races'

export default {
  name: 'HouseholdIdentificationForm',
  mixins: [baseComponent],
  data() {
    return {
      genres,
      familyReferenceInteractions,
      races
    }
  }
}
</script>
