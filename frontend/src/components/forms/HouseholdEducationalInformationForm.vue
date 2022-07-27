<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="alphabetization"
          label="Sabe ler e escrever?"
          v-model="object.alphabetization"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="student"
          label="Frequenta escola ou créche atualmente?"
          v-model="object.student"
          :radio="singleAnswers"
          :required="true"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <div v-if="object.student === 1">
      <b-row>
        <b-col lg="6" sm="12">
          <InputText
            id="schoolName"
            label="Qual é o nome dessa escola ou creche que frequenta?"
            v-model="object.name"
            placeholder="Nome da escola"
            :maxlength="80"
            :minlength="4"
            :required="true"
            :disabled="disabled"
          />
        </b-col>
        <b-col lg="6" sm="12">
          <BaseRadio
            id="schoolLocation"
            label="Essa escola ou creche está localizada neste município?"
            v-model="object.schoolLocationStatus"
            :radio="singleAnswers"
            :required="true"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
      </b-row>
      <div v-if="object.schoolLocationStatus === 1">
        <b-row class="my-2">
          <b-col xl="8" sm="8">
            <InputNumber
              id="codeInep"
              label="Código do INEP/MEC da escola ou creche:"
              v-model="object.codeInep"
              placeholder="Código do INEP/MEC"
              :minlength="8"
              :maxlength="8"
              :required="false"
              :disabled="codeInepStatus"
            />
          </b-col>
          <b-col class="mt-lg-5 mt-sm-5">
            <b-form-checkbox v-model="codeInepStatus">
              Não tem
            </b-form-checkbox>
          </b-col>
        </b-row>
      </div>
      <div v-if="object.schoolLocationStatus === 2">
        <b-card bg-variant="light">
          <b-form-group
            id="schoolLocation"
            label="Qual é o estado e o município onde está localizada a escola ou creche?"
            label-size="md"
            label-class="font-weight-bold"
          >
            <b-row>
              <b-col lg="6" sm="12">
                <InputText
                  id="state"
                  label="Estado"
                  v-model="object.state"
                  placeholder="Estado"
                  :maxlength="45"
                  :minlength="4"
                  :required="true"
                  :disabled="disabled"
                />
              </b-col>
              <b-col lg="6" sm="12">
                <InputText
                  id="town"
                  label="Município"
                  v-model="object.town"
                  placeholder="Município"
                  :maxlength="45"
                  :minlength="4"
                  :required="true"
                  :disabled="disabled"
                />
              </b-col>
            </b-row>
          </b-form-group>
        </b-card>
        <b-row class="my-2">
          <b-col xl="8" sm="8">
            <InputNumber
              id="codeInep"
              label="Código do INEP/MEC da escola ou creche:"
              v-model="object.codeInep"
              placeholder="Código do INEP/MEC"
              :minlength="8"
              :maxlength="8"
              :required="false"
              :disabled="codeInepStatus"
            />
          </b-col>
          <b-col class="mt-lg-5 mt-sm-5">
            <b-form-checkbox v-model="codeInepStatus">
              Não tem
            </b-form-checkbox>
          </b-col>
        </b-row>
      </div>
      <b-row>
        <b-col>
          <BaseRadio
            id="courseEnroll"
            label="Qual é o curso que frequenta?"
            v-model="object.courseEnroll"
            :radio="educationalLevels"
            :required="true"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <BaseRadio
            id="courseEnrollSerie"
            label="Qual é o ano/série que frequenta?"
            v-model="object.courseEnrollSerie"
            :radio="courseEnrollSeries"
            :required="false"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
      </b-row>
    </div>
    <div v-if="object.student === 2">
      <b-row>
        <b-col>
          <BaseRadio
            id="educationalLevel"
            label="Qual foi o curso mais elevado que freqüentou, no qual concluiu pelo menos uma série?"
            v-model="object.educationalLevel"
            :radio="educationalLevels"
            :required="true"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
      </b-row>
      <b-row>
        <b-col lg="6" sm="12">
          <BaseRadio
            id="courseEnrollSerie"
            label="Qual foi o último ano/série que concluiu com aprovação nesse curso que frequentou?"
            v-model="object.courseEnrollSerie"
            :radio="courseEnrollSeries"
            :required="false"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
        <b-col lg="6" sm="12">
          <BaseRadio
            id="courseEnrollStatus"
            label="Concluiu esse curso que frequentou?"
            v-model="object.courseEnrollStatus"
            :radio="singleAnswers"
            :required="false"
            :disabled="disabled"
            :selected="0"
          />
        </b-col>
      </b-row>
    </div>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import singleAnswers from '@/models/singleAnswers'
import educationalLevels from '@/models/educationalLevels'
import courseEnrollSeries from '@/models/courseEnrollSeries'

export default {
  name: 'HouseholdEducationalInformationForm',
  mixins: [baseComponent],
  data() {
    return {
      singleAnswers,
      educationalLevels,
      courseEnrollSeries,
      codeInepStatus: true
    }
  }
}
</script>
