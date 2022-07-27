<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="6" sm="7">
        <InputNumber
          id="residentOfState"
          label="Há quantos anos a família mora neste estado:"
          v-model="residentOfState"
          placeholder="Número"
          :maxlength="2"
          :required="false"
          :disabled="residentOfStateStatus"
        />
      </b-col>
      <b-col lg="6" sm="5" class="mt-lg-5 mt-sm-5">
        <b-form-checkbox v-model="residentOfStateStatus">
          A família sempre morou no estado
        </b-form-checkbox>
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6" sm="7">
        <InputNumber
          id="residentOfCity"
          label="Há quantos anos a família mora no município:"
          v-model="residentOfCity"
          placeholder="Número"
          :maxlength="2"
          :required="false"
          :disabled="residentOfCityStatus"
        />
      </b-col>
      <b-col lg="6" sm="5" class="mt-lg-5 mt-sm-5">
        <b-form-checkbox v-model="residentOfCityStatus">
          A família sempre morou no município
        </b-form-checkbox>
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6" sm="7">
        <InputNumber
          id="residentOfDistrict"
          label="Há quantos anos a família mora no bairro atual:"
          v-model="residentOfDistrict"
          placeholder="Número"
          :maxlength="2"
          :required="false"
          :disabled="residentOfDistrictStatus"
        />
      </b-col>
      <b-col lg="6" sm="5" class="mt-lg-5 mt-sm-5">
        <b-form-checkbox v-model="residentOfDistrictStatus">
          A família sempre morou no mesmo bairro
        </b-form-checkbox>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <BaseRadio
          id="victimsOfPrejudice"
          label="A família ou algum de seus membros, é vítima de ameaças ou de discriminação na comunidade onde reside?"
          v-model="victimsOfPrejudice"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="supportiveRelative"
          label="A família possui parentes que residam próximo ao seu local de moradia e que constituam rede de apoio e solidariedade?"
          v-model="supportiveRelative"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="supportiveNeighbour"
          label="A família possui vizinhos que constituam rede de apoio e solidariedade?"
          v-model="supportiveNeighbour"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <BaseRadio
          id="supportiveReligiousGroup"
          label="A família ou algum de seus membros, participa de grupos religiosos, comunitários ou outros grupos/instituições que constituam rede de apoio e solidariedade?"
          v-model="supportiveReligiousGroup"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <BaseRadio
          id="supportiveSocialMovements"
          label="A família ou algum de seus membros, participa de movimentos sociais, sindicatos, organizações comunitárias, Conselhos ou quaisquer outras ações ou instituições voltadas para organização política e defesa de interesses coletivos?"
          v-model="supportiveSocialMovements"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="childAccessToSocialCoexistence"
          label="Existe alguma criança ou adolescente do grupo familiar que não tem acesso a atividade de lazer, recreação e convívio social?"
          v-model="childAccessToSocialCoexistence"
          :radio="specificSingleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
      <b-col lg="6" sm="12">
        <BaseRadio
          id="elderlyAccessToSocialCoexistence"
          label="Existe algum idoso do grupo familiar que não tem acesso a atividade de lazer, recreação e convívio social?"
          v-model="elderlyAccessToSocialCoexistence"
          :radio="specificSingleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <BaseRadio
          id="dependentPersonHomeAlone"
          label="Há pessoas dependentes (crianças, idosos, dependentes ou pessoas com deficiência) que permanecem períodos do dia em casa sem a companhia de um adulto?"
          v-model="dependentPersonHomeAlone"
          :radio="singleAnswers"
          :required="false"
          :disabled="disabled"
          :selected="0"
        />
      </b-col>
    </b-row>
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="familyRelationshipGroup"
        label="Relações de Convivência Intrafamiliares"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="4" sm="12">
            <BaseRadio
              id="maritalRelationshipAssessment"
              label="Percepção/Avaliação do técnico sobre as relações conjugais na família, se for o caso"
              v-model="maritalRelationshipAssessment"
              :radio="familyRelationshipAssessmentAnswers"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
          <b-col lg="4" sm="6">
            <InputText
              id="maritalRelationshipAssessmentInterviewer"
              label="Nome do Técnico"
              v-model="maritalRelationshipAssessmentInterviewer"
              placeholder=""
              :maxlength="45"
              :minlength="4"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="4" sm="6">
            <InputDate
              id="maritalRelationshipAssessmentDate"
              label="Data:"
              v-model="maritalRelationshipAssessmentDate"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="4" sm="12">
            <BaseRadio
              id="relationshipBetweenParentsAndChildrenAssessment"
              label="Percepção/Avaliação do técnico sobre as relações entre pais/responsáveis e os filhos inclusive entre o padrasto ou madastra com o(s) enteados(as), se for o caso"
              v-model="relationshipBetweenParentsAndChildrenAssessment"
              :radio="familyRelationshipAssessmentAnswers"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
          <b-col lg="4" sm="6">
            <InputText
              id="relationshipBetweenParentsAndChildrenAssessmentInterviewer"
              label="Nome do Técnico"
              v-model="
                relationshipBetweenParentsAndChildrenAssessmentInterviewer
              "
              placeholder=""
              :maxlength="45"
              :minlength="4"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="4" sm="6">
            <InputDate
              id="relationshipBetweenParentsAndChildrenAssessmentDate"
              label="Data:"
              v-model="relationshipBetweenParentsAndChildrenAssessmentDate"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="4" sm="12">
            <BaseRadio
              id="relationshipBetweenBrothersAssessment"
              label="Percepção/Avaliação do técnico sobre as relações entre os irmãos, se for o caso"
              v-model="relationshipBetweenBrothersAssessment"
              :radio="familyRelationshipAssessmentAnswers"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
          <b-col lg="4" sm="6">
            <InputText
              id="relationshipBetweenBrothersAssessmentInterviewer"
              label="Nome do Técnico"
              v-model="relationshipBetweenBrothersAssessmentInterviewer"
              placeholder=""
              :maxlength="45"
              :minlength="4"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="4" sm="6">
            <InputDate
              id="relationshipBetweenBrothersAssessmentDate"
              label="Data:"
              v-model="relationshipBetweenBrothersAssessmentDate"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
    <b-row>
      <b-col>
        <BaseRadio
          id="relationshipBetweenResidents"
          label="Indique se há relações conflituosas envolvendo outros indivíduos que residam no domicílio?"
          v-model="relationshipBetweenResidents"
          :radio="familyRelationshipAssessmentAnswers"
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
import singleAnswers from '@/models/singleAnswers'
import familyRelationshipAssessmentAnswers from '@/models/familyRelationshipAssessmentAnswers'

export default {
  name: 'FamilyAndCommunityLivingForm',
  mixins: [baseComponent],
  data() {
    return {
      singleAnswers,
      specificSingleAnswers: [
        {
          id: 1,
          description: 'Sim'
        },
        {
          id: 2,
          description: 'Não'
        },
        {
          id: 3,
          description: 'Não se aplica'
        }
      ],
      familyRelationshipAssessmentAnswers,
      residentOfState: null,
      residentOfStateStatus: true,
      residentOfCity: null,
      residentOfCityStatus: true,
      residentOfDistrict: null,
      residentOfDistrictStatus: true,
      victimsOfPrejudice: null,
      supportiveRelative: null,
      supportiveNeighbour: null,
      supportiveReligiousGroup: null,
      supportiveSocialMovements: null,
      childAccessToSocialCoexistence: null,
      elderlyAccessToSocialCoexistence: null,
      dependentPersonHomeAlone: null,
      maritalRelationshipAssessment: null,
      maritalRelationshipAssessmentInterviewer: null,
      maritalRelationshipAssessmentDate: null,
      relationshipBetweenParentsAndChildrenAssessment: null,
      relationshipBetweenParentsAndChildrenAssessmentInterviewer: null,
      relationshipBetweenParentsAndChildrenAssessmentDate: null,
      relationshipBetweenBrothersAssessment: null,
      relationshipBetweenBrothersAssessmentInterviewer: null,
      relationshipBetweenBrothersAssessmentDate: null,
      relationshipBetweenResidents: null
    }
  }
}
</script>
