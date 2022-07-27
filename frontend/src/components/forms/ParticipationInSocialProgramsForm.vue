<template :visible="visible">
  <b-form v-if="object">
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="participationInSocialProgramsGroup"
        label="Registre a participação de membros da família em serviços, programas ou projetos que contribuam para o desenvolvimento da convivência comunitária e para o fortalecimento de vínculos:"
        label-size="md"
        label-class="font-weight-bold"
      >
        <!-- TODO -->
        <b-row>
          <b-col>
            <BaseRadio
              id="communitySocialProgrammeService"
              label="Serviço, Programa ou Projeto:"
              v-model="communitySocialProgrammeService"
              :radio="communitySocialProgrammeServices"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <BaseRadio
              id="communitySocialProgrammeLocation"
              label="Unidade de realização:"
              v-model="communitySocialProgrammeLocation"
              :radio="communitySocialProgrammeLocations"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="6" sm="12">
            <InputDate
              id="startingDate"
              label="Data de Ingresso:"
              v-model="startingDate"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="6" sm="12">
            <InputDate
              id="closingDate"
              label="Data de Encerramento:"
              v-model="closingDate"
              placeholder="dd/mm/aaaa"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <BaseTextarea
              id="participationInSocialProgramsDescription"
              label="Observação:"
              v-model="participationInSocialProgramsDescription"
              placeholder=""
              :required="false"
              :disabled="disabled"
              :maxlength="150"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import {
  communitySocialProgrammeServices,
  communitySocialProgrammeLocations
} from '@/models/communityServiceProgrammes'

export default {
  name: 'ParticipationInSocialProgramsForm',
  mixins: [baseComponent],
  data() {
    return {
      communitySocialProgrammeServices,
      communitySocialProgrammeLocations,
      communitySocialProgrammeService: null,
      communitySocialProgrammeLocation: null,
      startingDate: null,
      closingDate: null,
      participationInSocialProgramsDescription: null
    }
  }
}
</script>
