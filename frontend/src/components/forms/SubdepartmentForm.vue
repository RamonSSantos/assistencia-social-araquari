<template :visible="visible">
  <b-form v-if="newObject">
    <template v-if="subdepartment.id === 1">
      <InterviewIdentificationAndControlForm
        :visible="true"
        :object="newObject"
        :disabled="disabled"
      />
    </template>
    <template
      v-else-if="
        subdepartment.id === 2 ||
          (subdepartment.id >= 4 && subdepartment.id <= 6)
      "
    >
      <b-row>
        <b-col lg="4" sm="12">
          <InputDate
            id="interviewDate"
            label="Data da entrevista:"
            v-model="newObject.interviewDate"
            @input="statusInterviewDate"
            placeholder="dd/mm/aaaa"
            :required="false"
            :disabled="disabled"
            :autofocus="true"
          />
        </b-col>
        <b-col lg="8" sm="12">
          <BaseRadio
            id="basicDescriptionIdentification"
            label="Descrição Sumária do Atendimento:"
            v-model="newObject.description"
            :radio="basicDescriptionIdentifications"
            :required="true"
            :disabled="disabled"
            :selected="null"
          />
        </b-col>
      </b-row>
    </template>
    <template v-else>
      Em construção
    </template>
    <b-row>
      <b-col>
        <b-button-group class="mt-2">
          <BaseButton
            type="button"
            id="clear"
            buttonName="Limpar"
            variant="warning"
            :pill="true"
            class="mr-1"
            @click.stop="clearForm()"
          />
          <BaseButton
            type="button"
            id="next"
            buttonName="Continuar"
            variant="dark"
            :pill="true"
            class="ml-1"
            :disabled="statusNextButton"
            @click.stop="showNextObject()"
          />
        </b-button-group>
      </b-col>
    </b-row>
    <div v-if="nextStatus" class="mt-4">
      <SingleRegistryIdentificationForm
        v-model="nextStatus"
        :disabled="disabled"
        :nextObject="nextObject"
        :idSubdepartment="subdepartment.id"
      />
    </div>
  </b-form>
</template>

<script>
import basicDescriptionIdentifications from '@/models/basicDescriptionIdentifications'
import { isValidDateAndYear } from '@/utils/validateDate'

export default {
  name: 'SubdepartmentForm',
  props: {
    subdepartment: {
      default: null
    },
    newObject: {
      type: Object,
      default: null
    },
    visible: {
      type: Boolean,
      default: false
    },
    disabled: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      basicDescriptionIdentifications,
      statusNextButton: false,
      nextObject: null,
      nextStatus: false
    }
  },
  methods: {
    statusInterviewDate() {
      this.statusNextButton = true
      if (isValidDateAndYear(this.newObject.interviewDate)) {
        this.statusNextButton = false
      }
    },
    showNextObject() {
      this.nextObject = this.newObject
      this.nextStatus = true
    },
    clearForm() {
      this.nextObject = null
      this.nextStatus = false
    }
  }
}
</script>
