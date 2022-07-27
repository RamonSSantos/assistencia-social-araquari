<template :visible="visible">
  <b-form v-if="object">
    <b-card
      sub-title="QUADRO 2 - EXCLUSIVO PARA UTILIZAÇÃO PELO CRAS"
      bg-variant="light"
      class="mt-3"
    >
      <b-form-group
        id="monitoringSocialAssistanceReferenceCentresGroup"
        label="Caso a família esteja, ou já tenha estado, sob acompanhamento de um CREAS, registre o período em que isso ocorreu e o CREAS que realizou o acompanhamento"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="3" sm="6">
            <InputDate
              id="startingDateOfMonitoring"
              label="Data Início:"
              v-model="startingDateOfMonitoring"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="3" sm="6">
            <InputDate
              id="endingDateOfMonitoring"
              label="Data Final:"
              v-model="endingDateOfMonitoring"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="6" sm="12">
            <InputText
              id="socialAssistanceSpecializedReferenceCenterIdentification"
              label="Identificação do CREAS:"
              v-model="socialAssistanceSpecializedReferenceCenterIdentification"
              placeholder="Identificação do CREAS"
              :maxlength="80"
              :minlength="8"
              :required="true"
              :disabled="disabled"
              :autofocus="true"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'

export default {
  name: 'MonitoringSocialAssistanceReferenceCentresForm',
  mixins: [baseComponent],
  data() {
    return {
      startingDateOfMonitoring: null,
      endingDateOfMonitoring: null,
      socialAssistanceSpecializedReferenceCenterIdentification: null
    }
  }
}
</script>
