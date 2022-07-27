<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col>
        <BaseRadio
          id="childLabour"
          label="Há trabalho infantil na família?"
          v-model="object.childLabour"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-card v-if="object.childLabour === 1" bg-variant="light" class="mt-3">
      <b-form-group
        id="slaveLabourGroup"
        label="Identifique a(s) criança(s) envolvida(s) em trabalho infantil:"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row v-for="child in children" :key="child.id" class="mt-2">
          <b-col>
            <b-form-checkbox v-model="child.hasSlaveLabour" switch>
              Sim
            </b-form-checkbox>
          </b-col>
          <b-col sm="9">
            <b-form-input type="text" v-model="child.fullname" :disabled="true">
            </b-form-input>
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
  </b-form>
</template>

<script>
import HouseholdService from '@/services/HouseholdService'
import baseComponent from '@/mixins/baseComponent'
import singleAnswers from '@/models/singleAnswers'

export default {
  name: 'FreeAnnotationToCityForm',
  mixins: [baseComponent],
  data() {
    return {
      singleAnswers,
      children: {
        id: null,
        fullname: null,
        hasSlaveLabour: false
      }
    }
  },
  created() {
    this.getChildrenByFamilyId()
  },
  methods: {
    async getChildrenByFamilyId() {
      const response = await HouseholdService.getChildrenByFamilyId()
      this.children = response.data
    }
  }
}
</script>
