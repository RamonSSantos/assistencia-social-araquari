<template :visible="visible">
  <b-form v-if="object">
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="HistoricalOfFamilyBasedCareGroup"
        label="Utilize o quadro abaixo para registrar eventuais situações de acolhimento institucional vivenciadas por algum membro do grupo familiar, sejam situações atuais ou ocorridas no passado"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="6" sm="12">
            <InputText
              id="welcomedFamilyMember"
              label="Nome do membro da família:"
              v-model="welcomedFamilyMember"
              placeholder="Membro da família"
              :maxlength="80"
              :minlength="8"
              :required="true"
              :disabled="disabled"
              :autofocus="true"
            />
          </b-col>
          <b-col lg="6" sm="12">
            <InputText
              id="reasonForWelcoming"
              label="Motivo:"
              v-model="reasonForWelcoming"
              placeholder=""
              :maxlength="150"
              :minlength="4"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="5" sm="4">
            <InputDate
              id="startingDateOfInstitutionalSheltering"
              label="Data de Início:"
              v-model="startingDateOfInstitutionalSheltering"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="5" sm="4">
            <InputDate
              id="endingDateOfInstitutionalSheltering"
              label="Data de Fim:"
              v-model="endingDateOfInstitutionalSheltering"
              placeholder="dd/mm/aaaa"
              :required="true"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="2" sm="4" class="add-new-institutional-sheltering">
            <BaseButton
              type="button"
              id="addNewInstitutionalSheltering"
              buttonName="Salvar"
              variant="outline-primary"
              @click.stop="addNewInstitutionalSheltering"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <BaseTextarea
              id="institutionalShelteringAccordingToNaturalDisaster"
              label="Caso o grupo familiar, em seu conjunto, já tenha vivenciado alguma situação de acolhimento institucional (abrigamento) decorrente da perda, temporária ou definitiva do domicílio, quer em função de catástrofe natural ou de fatalidade pessoal, registre o período em que o fato ocorreu e o motivo/fato que levou ao acolhimento:"
              v-model="institutionalShelteringAccordingToNaturalDisaster"
              placeholder=""
              :required="false"
              :disabled="disabled"
              :maxlength="150"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <BaseTextarea
              id="familyAbandonment"
              label="Caso alguma criança/adolescente ou família esteja, ou já tenha estado, sob guarda (legal ou informal) de outra pessoa não residente no domicílio (família extensa, amigos, patrões, etc), registre o período em que o fato ocorreu, a razão pela qual ocorreu, a pessoa que esteve com a guarda e o nome ou número de ordem da criança/adolescente:"
              v-model="familyAbandonment"
              placeholder=""
              :required="false"
              :disabled="disabled"
              :maxlength="150"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <BaseCheckbox
              id="removedFromFamilyCoexistence"
              label="Outras situações de afastamentos do convívio familiar:"
              v-model="removedFromFamilyCoexistence"
              :checkbox="familyCoexistenceTypes"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
      </b-form-group>
      <b-card-footer>
        Sempre que possível, identifique e registre no campo abaixo a
        instituição na qual a pessoa foi acolhida
      </b-card-footer>
    </b-card>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'

export default {
  name: 'HistoricalOfFamilyBasedCareForm',
  mixins: [baseComponent],
  data() {
    return {
      familyCoexistenceTypes: [
        {
          id: 1,
          description:
            'Assinale caso a família possua algum membro adulto (pais ou filhos) em instituição prisional'
        },
        {
          id: 2,
          description:
            'Assinale caso a família possua algum membro adolescente cumprindo medida socioeducativa de internação'
        }
      ],
      welcomedFamilyMember: null,
      reasonForWelcoming: null,
      startingDateOfInstitutionalSheltering: null,
      endingDateOfInstitutionalSheltering: null,
      institutionalShelteringAccordingToNaturalDisaster: null,
      familyAbandonment: null,
      removedFromFamilyCoexistence: null
    }
  },
  methods: {
    addNewInstitutionalSheltering() {}
  }
}
</script>

<style scoped>
.add-new-institutional-sheltering {
  display: flex;
  align-items: flex-end;
  margin-bottom: 16px;
}
</style>
