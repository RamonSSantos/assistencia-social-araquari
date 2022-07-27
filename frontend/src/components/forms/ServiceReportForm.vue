<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col>
        <BaseTextarea
          id="observationServiceReport"
          label="Observação:"
          v-model="object.observation"
          placeholder="Observação"
          :required="false"
          :disabled="disabled"
          :maxlength="1000"
          :autofocus="true"
        />
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'

export default {
  name: 'ServiceReportForm',
  mixins: [baseComponent]
}
</script>
