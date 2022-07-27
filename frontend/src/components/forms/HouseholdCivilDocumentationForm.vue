<template :visible="visible">
  <b-form v-if="object">
    <b-row>
      <b-col lg="6" sm="12">
        <InputDataList
          id="maritalStatus"
          datalist="maritalStatusList"
          label="Estado Civil:"
          v-model="object.maritalStatus"
          :sizes="maritalStatus"
          placeholder="Estado Civil"
          :required="true"
          :disabled="disabled"
          :autofocus="true"
        />
      </b-col>
      <b-col lg="6" sm="12">
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
    </b-row>
    <b-card bg-variant="light">
      <b-form-group
        id="filiation"
        label="Filiação:"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col xl="9" sm="8">
            <InputText
              id="fullnameMother"
              label="Nome completo da mãe:"
              v-model="object.fullnameMother"
              placeholder="Nome completo da mãe"
              :maxlength="80"
              :minlength="4"
              :required="false"
              :disabled="fullnameMotherStatus"
            />
          </b-col>
          <b-col class="mt-lg-5 mt-sm-5">
            <b-form-checkbox v-model="fullnameMotherStatus">
              Não sabe
            </b-form-checkbox>
          </b-col>
        </b-row>
        <b-row>
          <b-col xl="9" sm="8">
            <InputText
              id="fullnameFather"
              label="Nome completo do pai:"
              v-model="object.fullnameFather"
              placeholder="Nome completo do pai"
              :maxlength="80"
              :minlength="4"
              :required="false"
              :disabled="fullnameFatherStatus"
            />
          </b-col>
          <b-col class="mt-lg-5 mt-sm-5">
            <b-form-checkbox v-model="fullnameFatherStatus">
              Não sabe
            </b-form-checkbox>
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="placeOfBirthGroup"
        label="Local de nascimento:"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col>
            <BaseRadio
              id="placeOfBirth"
              label="Onde nasceu?"
              v-model="object.placeOfBirth"
              :radio="placesOfBirth"
              :required="false"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
        </b-row>
        <div v-if="object.placeOfBirth === 2">
          <b-row>
            <b-col xl="9" sm="8">
              <InputText
                id="homeState"
                label="Em que estado nasceu?"
                v-model="object.homeState"
                placeholder="Nome do estado"
                :maxlength="45"
                :minlength="4"
                :required="false"
                :disabled="homeStateStatus"
              />
            </b-col>
            <b-col class="mt-lg-5 mt-sm-5">
              <b-form-checkbox v-model="homeStateStatus">
                Não sabe
              </b-form-checkbox>
            </b-col>
          </b-row>
          <b-row>
            <b-col xl="9" sm="8">
              <InputText
                id="hometown"
                label="Em que município nasceu?"
                v-model="object.hometown"
                placeholder="Nome do município"
                :maxlength="45"
                :minlength="4"
                :required="false"
                :disabled="hometownStatus"
              />
            </b-col>
            <b-col class="mt-lg-5 mt-sm-5">
              <b-form-checkbox v-model="hometownStatus">
                Não sabe
              </b-form-checkbox>
            </b-col>
          </b-row>
        </div>
        <div v-if="object.placeOfBirth === 3">
          <b-row>
            <b-col xl="9" sm="8">
              <InputText
                id="foreignCountry"
                label="Em que país estrangeiro nasceu?"
                v-model="object.foreignCountry"
                placeholder="Nome do país"
                :maxlength="45"
                :minlength="4"
                :required="false"
                :disabled="foreignCountryStatus"
              />
            </b-col>
            <b-col class="mt-lg-5 mt-sm-5">
              <b-form-checkbox v-model="foreignCountryStatus">
                Não sabe
              </b-form-checkbox>
            </b-col>
          </b-row>
        </div>
        <b-row>
          <b-col>
            <BaseRadio
              id="placeOfBirthRegistryOffice"
              label="O nascimento foi registrado em Cartório de Registro Civil?"
              v-model="object.placeOfBirthRegistryOffice"
              :radio="placeOfBirthRegistryOffice"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
    <div v-if="object.placeOfBirthRegistryOffice">
      <b-card bg-variant="light" class="mt-3">
        <b-form-group
          id="publicCivilRegistry"
          label="Tipo e dados da Certidão:"
          label-size="md"
          label-class="font-weight-bold"
        >
          <b-row>
            <b-col>
              <BaseRadio
                id="certificateType"
                label="Tipo:"
                v-model="object.certificateType"
                :radio="certificateTypes"
                :required="true"
                :disabled="disabled"
                :selected="0"
              />
            </b-col>
          </b-row>
          <div v-if="object.certificateType !== 3">
            Dados:
            <b-row>
              <b-col lg="8" sm="12">
                <InputText
                  id="registryOffice"
                  label="Nome do cartório:"
                  v-model="object.registryOffice"
                  placeholder="Nome do cartório"
                  :maxlength="30"
                  :minlength="4"
                  :required="false"
                  :disabled="disabled"
                />
              </b-col>
              <b-col lg="4" sm="12">
                <InputDate
                  id="registerDate"
                  label="Data do registro:"
                  v-model="object.registerDate"
                  placeholder="dd/mm/aaaa"
                  :required="false"
                  :disabled="disabled"
                />
              </b-col>
            </b-row>
          </div>
          <b-row v-if="householdHasPublicCivilRegistry">
            <b-col lg="4" sm="12">
              <InputTextWithMask
                id="numberBook"
                label="Número do livro:"
                v-model="object.numberBook"
                mask="########"
                placeholder=""
                :minlength="8"
                :maxlength="8"
                :required="false"
                :disabled="disabled"
              />
            </b-col>
            <b-col lg="4" sm="12">
              <InputTextWithMask
                id="entrySheet"
                label="Número da folha:"
                v-model="object.entrySheet"
                mask="####"
                placeholder=""
                :minlength="4"
                :maxlength="4"
                :required="false"
                :disabled="disabled"
              />
            </b-col>
            <b-col lg="4" sm="12">
              <InputTextWithMask
                id="rani"
                label="RANI:"
                v-model="object.rani"
                mask="########"
                placeholder=""
                :minlength="8"
                :maxlength="8"
                :required="false"
                :disabled="disabled"
              />
            </b-col>
          </b-row>
          <b-row v-if="householdHasPublicCivilRegistry">
            <b-col>
              <InputText
                id="registration"
                label="Matrícula:"
                v-model="object.registration"
                placeholder="Matrícula"
                :maxlength="32"
                :minlength="32"
                :required="false"
                :disabled="disabled"
              />
            </b-col>
          </b-row>
          <b-row v-if="householdHasPublicCivilRegistry">
            <b-col>
              <InputText
                id="registerState"
                label="Estado de registro:"
                v-model="object.registerState"
                placeholder="Nome do estado"
                :maxlength="45"
                :minlength="4"
                :required="false"
                :disabled="disabled"
              />
            </b-col>
          </b-row>
          <b-row v-if="householdHasPublicCivilRegistry">
            <b-col>
              <InputText
                id="registerTown"
                label="Município de registro:"
                v-model="object.registerTown"
                placeholder="Nome do município"
                :maxlength="45"
                :minlength="4"
                :required="false"
                :disabled="disabled"
              />
            </b-col>
          </b-row>
        </b-form-group>
      </b-card>
      <b-card bg-variant="light" class="mt-3" v-if="!householdHasOnlyRani">
        <b-form-group
          id="identityCard"
          label="Dados do documento de identidade (RG):"
          label-size="md"
          label-class="font-weight-bold"
        >
          <b-row>
            <b-col lg="4" sm="12">
              <InputText
                id="identityCardNumber"
                label="RG:"
                v-model="object.identityCardNumber"
                placeholder="RG"
                :minlength="7"
                :maxlength="16"
                :required="false"
                :disabled="disabled"
              />
            </b-col>
            <b-col lg="4" sm="12" v-if="object.identityCardNumber">
              <InputText
                id="complement"
                label="Complemento:"
                v-model="object.complement"
                placeholder=""
                :maxlength="5"
                :minlength="3"
                :required="false"
                :disabled="disabled"
              />
            </b-col>
            <b-col lg="4" sm="12" v-if="object.identityCardNumber">
              <InputDate
                id="issuingDate"
                label="Data da emissão:"
                v-model="object.issuingDate"
                placeholder="dd/mm/aaaa"
                :required="false"
                :disabled="disabled"
              />
            </b-col>
          </b-row>
          <b-row v-if="object.identityCardNumber">
            <b-col lg="6" sm="12">
              <InputText
                id="identityCardIssuingState"
                label="Estado emissor:"
                v-model="object.identityCardIssuingState"
                placeholder="Nome do estado"
                :maxlength="30"
                :minlength="4"
                :required="false"
                :disabled="disabled"
              />
            </b-col>
            <b-col lg="6" sm="12">
              <InputText
                id="issuingStateInitial"
                label="Sigla do orgão emissor:"
                v-model="object.issuingStateInitial"
                placeholder=""
                :maxlength="8"
                :minlength="3"
                :required="false"
                :disabled="disabled"
              />
            </b-col>
          </b-row>
        </b-form-group>
      </b-card>
    </div>
    <b-card bg-variant="light" class="mt-3" v-if="!householdHasOnlyRani">
      <b-form-group
        id="workCard"
        label="Dados da Carteira de Trabalho e Previdência Social:"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="6" sm="12">
            <InputTextWithMask
              id="workCardNumber"
              label="Número:"
              v-model="object.workCardNumber"
              mask="#######"
              placeholder="Número"
              :minlength="7"
              :maxlength="7"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="6" sm="12">
            <InputTextWithMask
              id="workCardSerie"
              label="Série:"
              v-model="object.workCardSerie"
              mask="#####"
              placeholder="Série"
              :minlength="5"
              :maxlength="5"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="6" sm="12">
            <InputText
              id="workCardIssuingState"
              label="Estado emissor:"
              v-model="object.workCardIssuingState"
              placeholder="Nome do estado"
              :maxlength="30"
              :minlength="4"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="6" sm="12">
            <InputDate
              id="workCardIssuingDate"
              label="Data da emissão:"
              v-model="object.workCardIssuingDate"
              placeholder="dd/mm/aaaa"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
    <b-card bg-variant="light" class="mt-3" v-if="!householdHasOnlyRani">
      <b-form-group
        id="electoralCard"
        label="Dados do Título de Eleitor:"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="4" sm="12">
            <InputTextWithMask
              id="electoralCardNumber"
              label="Número:"
              v-model="object.electoralCardNumber"
              mask="############"
              placeholder="Número"
              :minlength="12"
              :maxlength="12"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="4" sm="12">
            <InputTextWithMask
              id="electoralWard"
              label="Zona:"
              v-model="object.electoralWard"
              mask="####"
              placeholder="Zona"
              :minlength="4"
              :maxlength="4"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="4" sm="12">
            <InputTextWithMask
              id="electoralOffice"
              label="Seção:"
              v-model="object.electoralOffice"
              mask="####"
              placeholder="Seção"
              :minlength="4"
              :maxlength="4"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import maritalStatus from '@/models/maritalStatus'
import placesOfBirth from '@/models/placesOfBirth'
import placeOfBirthRegistryOffice from '@/models/placeOfBirthRegistryOffice'
import certificateTypes from '@/models/certificateTypes'

export default {
  name: 'HouseholdCivilDocumentationForm',
  mixins: [baseComponent],
  computed: {
    householdHasPublicCivilRegistry() {
      return (this.object.placeOfBirthRegistryOffice === 1 ||
        this.object.placeOfBirthRegistryOffice === 2) &&
        this.object.certificateType
        ? true
        : false
    },
    householdHasOnlyRani() {
      return this.object.placeOfBirthRegistryOffice === 3 &&
        this.object.certificateType === 3
        ? true
        : false
    }
  },
  data() {
    return {
      maritalStatus,
      placesOfBirth,
      placeOfBirthRegistryOffice,
      certificateTypes,
      fullnameMotherStatus: false,
      fullnameFatherStatus: false,
      homeStateStatus: false,
      hometownStatus: false,
      foreignCountryStatus: false
    }
  }
}
</script>
