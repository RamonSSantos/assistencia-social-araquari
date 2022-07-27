<template :visible="visible">
  <div v-if="newObject">
    <div class="main-content__top">
      <div class="main-content__title">
        <h4>
          Controle dos Encaminhamentos Realizados no Processo de Acompanhamento
          Familiar
        </h4>
      </div>
    </div>
    <div class="main-content__body">
      <b-container fluid class="bv-example-row pl-0">
        <BreadCrumb />
        <b-tabs
          v-model="tabIndex"
          active-nav-item-class="font-weight-bold"
          card
        >
          <b-tab
            v-for="tab in dispatchControlTypes"
            :key="tab.id"
            :title="tab.title"
          >
            <div v-if="tab.id === 1">
              <b-form>
                <b-row>
                  <b-col lg="5" sm="12">
                    <div class="my-2">
                      Código da área a qual está sendo realizado o
                      encaminhamento:
                    </div>
                    <b-input-group>
                      <InputSearch
                        id="locationCodeFromReferralId"
                        v-model="register.locationCodeFromReferral.id"
                        :isValidSearch="null"
                        placeholder="Código do local:"
                        :maxlength="80"
                        :autofocus="true"
                        @keydown.enter.prevent="searchLocationCodeFromReferral"
                      />
                      <b-input-group-append is-text class="cursor-pointer">
                        <BaseIcon
                          icon="search"
                          @click.stop="searchLocationCodeFromReferral"
                          :animation="null"
                        />
                      </b-input-group-append>
                    </b-input-group>
                  </b-col>
                  <b-col lg="7" sm="12">
                    <InputText
                      id="locationCodeFromReferralDescription"
                      label="Especifique o Órgão/Unidade para o qual está sendo feito o encaminhamento:"
                      v-model="register.locationCodeFromReferral.description"
                      placeholder="Nome do local"
                      :maxlength="80"
                      :minlength="8"
                      :required="false"
                      :disabled="!disabled"
                    />
                  </b-col>
                </b-row>
                <b-row>
                  <b-col>
                    <InputText
                      id="referralRegisterReason"
                      label="Objetivo/Motivo:"
                      v-model="register.referralRegisterReason"
                      placeholder=""
                      :maxlength="80"
                      :minlength="8"
                      :required="true"
                      :disabled="disabled"
                    />
                  </b-col>
                </b-row>
                <b-row>
                  <b-col lg="5" sm="12">
                    <InputDate
                      id="referralRegisterDate"
                      label="Data:"
                      v-model="register.referralRegisterDate"
                      placeholder="dd/mm/aaaa"
                      :required="true"
                      :disabled="disabled"
                    />
                  </b-col>
                  <b-col lg="7" sm="12">
                    <InputText
                      id="referralRegisterUserFullname"
                      label="Nome do Profissional:"
                      v-model="register.referralRegisterUserFullname"
                      :maxlength="80"
                      :required="false"
                      :disabled="!disabled"
                    />
                  </b-col>
                </b-row>
                <b-row>
                  <b-col>
                    <BaseTextarea
                      id="referralRegisterDetails"
                      label="Detalhes do Encaminhamento:"
                      v-model="register.referralRegisterDetails"
                      placeholder=""
                      :required="false"
                      :disabled="disabled"
                      :maxlength="350"
                    />
                  </b-col>
                </b-row>
                <b-row align-h="between">
                  <b-col cols="auto" class="mr-auto">
                    <BaseButton
                      type="button"
                      id="goToDispatchControlPage"
                      buttonName="Cancelar"
                      variant="warning"
                      @click.stop="goToDispatchControlPage"
                    />
                  </b-col>
                  <b-col cols="auto">
                    <b-button-group>
                      <BaseButton
                        type="button"
                        id="resetFormReferralRegister"
                        buttonName="Limpar"
                        variant="secondary"
                        @click.stop="resetFormReferralRegister"
                      />
                      <BaseButton
                        type="button"
                        id="addNewReferralRegister"
                        buttonName="Salvar"
                        variant="outline-info"
                        @click.stop="addNewReferralRegister"
                      />
                    </b-button-group>
                  </b-col>
                </b-row>
              </b-form>
            </div>
            <template v-else-if="tab.id === 2">
              <b-card bg-variant="light" class="mt-3">
                <b-form-group
                  id="singleSystemOfSocialAssistanceGroup"
                  label="SISTEMA ÚNICO DE ASSISTÊNCIA SOCIAL - SUAS"
                  label-size="md"
                  label-class="font-weight-bold"
                >
                  <b-row>
                    <b-col>
                      <InputText
                        id="responsibleFamilyMemberIdentification"
                        label="Nome do membro da família:"
                        v-model="form.responsibleFamilyMemberIdentification"
                        placeholder="Membro da família"
                        :maxlength="80"
                        :minlength="8"
                        :required="true"
                        :disabled="disabled"
                      />
                    </b-col>
                  </b-row>
                  <b-row>
                    <b-col>
                      <InputText
                        id="localAttendanceDescription"
                        label="Local para encaminhamento:"
                        v-model="form.localAttendanceDescription"
                        placeholder="Nome do local"
                        :maxlength="80"
                        :minlength="8"
                        :required="true"
                        :disabled="disabled"
                      />
                    </b-col>
                  </b-row>
                  <b-row>
                    <b-col>
                      <InputText
                        id="localAttendanceAddress"
                        label="Endereço do local para encaminhamento:"
                        v-model="form.localAttendanceAddress"
                        placeholder="Endereço do local"
                        :maxlength="80"
                        :minlength="8"
                        :required="true"
                        :disabled="disabled"
                      />
                    </b-col>
                  </b-row>
                  <b-row>
                    <b-col>
                      <BaseTextarea
                        id="needsIdentifiedBySocialAssistance"
                        label="Necessidades identificadas pela Assistência Social:"
                        v-model="form.needsIdentifiedBySocialAssistance"
                        placeholder=""
                        :required="false"
                        :disabled="disabled"
                        :maxlength="350"
                      />
                    </b-col>
                  </b-row>
                  <b-row>
                    <b-col lg="5" sm="12">
                      <InputDate
                        id="referralFormDate"
                        label="Data:"
                        v-model="register.referralFormDate"
                        placeholder="dd/mm/aaaa"
                        :required="true"
                        :disabled="disabled"
                      />
                    </b-col>
                  </b-row>
                  <b-row>
                    <b-col>
                      <InputText
                        id="referralPlaceOfOriginDescription"
                        label="Nome da Unidade responsável pela origem do encaminhamento:"
                        v-model="form.referralPlaceOfOriginDescription"
                        placeholder="Nome do local"
                        :maxlength="80"
                        :minlength="8"
                        :required="true"
                        :disabled="!disabled"
                      />
                    </b-col>
                  </b-row>
                  <b-row>
                    <b-col lg="5" sm="12">
                      <InputTextPhone
                        id="referralPlaceOfOriginContact"
                        label="Telefone para contato:"
                        v-model="form.referralPlaceOfOriginContact"
                        placeholder="Informe o número do telefone"
                        :minlength="14"
                        :maxlength="15"
                        :required="true"
                        :disabled="disabled"
                      />
                    </b-col>
                    <b-col lg="7" sm="12">
                      <InputText
                        id="referralPlaceOfOriginUserFullname"
                        label="Nome do Profissional:"
                        v-model="form.referralPlaceOfOriginUserFullname"
                        :maxlength="80"
                        :required="false"
                        :disabled="!disabled"
                      />
                    </b-col>
                  </b-row>
                  <b-row>
                    <b-col>
                      <BaseTextarea
                        id="referralFormDetails"
                        label="Anotações:"
                        v-model="form.referralFormDetails"
                        placeholder=""
                        :required="false"
                        :disabled="disabled"
                        :maxlength="700"
                      />
                    </b-col>
                  </b-row>
                  <b-row align-h="between">
                    <b-col cols="auto" class="mr-auto">
                      <BaseButton
                        type="button"
                        id="goToDispatchControlPage"
                        buttonName="Cancelar"
                        variant="warning"
                        @click.stop="goToDispatchControlPage"
                      />
                    </b-col>
                    <b-col cols="auto">
                      <b-button-group>
                        <BaseButton
                          type="button"
                          id="resetFormReferralForm"
                          buttonName="Limpar"
                          variant="secondary"
                          @click.stop="resetFormReferralForm"
                        />
                        <BaseButton
                          type="button"
                          id="addNewReferralForm"
                          buttonName="Salvar"
                          variant="outline-info"
                          @click.stop="addNewReferralForm"
                        />
                      </b-button-group>
                    </b-col>
                  </b-row>
                </b-form-group>
              </b-card>
            </template>
          </b-tab>
        </b-tabs>
      </b-container>
    </div>
    <b-modal
      v-model="showModal"
      title="Tabela de Códigos de Encaminhamentos"
      size="lg"
      @hidden="showModal = false"
    >
      <b-form>
        <b-row>
          <b-col>
            <BaseRadio
              id="referralCode"
              label="Tipo de Benefício:"
              v-model="referralCode"
              :radio="referralCodesTable"
              :required="true"
              :disabled="disabled"
              :selected="referralCodeSelected"
            />
          </b-col>
        </b-row>
      </b-form>
      <template v-slot:modal-footer>
        <BaseButton
          type="button"
          id="closeModal"
          buttonName="Cancelar"
          variant="outline-secondary"
          @click.stop="showModal = false"
        />
        <BaseButton
          type="submit"
          id="selectLocationCodeFromReferral"
          buttonName="Selecionar"
          variant="outline-info"
          :disabled="disabled"
          @click.stop="selectLocationCodeFromReferral"
        />
      </template>
    </b-modal>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import pageVisibility from '@/mixins/pageVisibility'
import dispatchControlTypes from '@/models/dispatchControlTypes'
import referralCodesTable from '@/models/referralCodesTable'
import EventBus from '@/services/EventBus'

export default {
  name: 'DispatchControlNew',
  mixins: [pageVisibility],
  computed: {
    referralCodeSelected: {
      get() {
        return this.register.locationCodeFromReferral.id === null
          ? 0
          : Number(this.register.locationCodeFromReferral.id)
      },
      set(newValue) {
        return Number(newValue)
      }
    }
  },
  data() {
    return {
      dispatchControlTypes,
      referralCodesTable,
      loading: false,
      tabIndex: 0,
      disabled: false,
      showModal: false,
      referralCode: null,
      register: {
        locationCodeFromReferral: {
          id: null,
          description: null
        },
        referralRegisterReason: null,
        referralRegisterDate: null,
        referralRegisterUserId: null,
        referralRegisterUserFullname: null,
        referralRegisterDetails: null
      },
      form: {
        responsibleFamilyMemberIdentification: null,
        localAttendanceDescription: null,
        localAttendanceAddress: null,
        needsIdentifiedBySocialAssistance: null,
        referralFormDate: null,
        referralPlaceOfOriginDescription: null,
        referralPlaceOfOriginContact: null,
        referralPlaceOfOriginUserId: null,
        referralPlaceOfOriginUserFullname: null,
        referralFormDetails: null
      }
    }
  },
  created() {
    this.getUserInformation()
  },
  methods: {
    ...mapActions('auth', ['ActionGetUser']),
    async getUserInformation() {
      const response = await this.ActionGetUser()
      const userId = response[0]
      const userFullname = response[1]

      this.register.referralRegisterUserId = userId
      this.register.referralRegisterUserFullname = userFullname

      this.form.referralPlaceOfOriginUserId = userId
      this.form.referralPlaceOfOriginUserFullname = userFullname
    },
    searchLocationCodeFromReferral() {
      if (this.register.locationCodeFromReferral.id) {
        this.referralCodeSelected = Number(
          this.register.locationCodeFromReferral.id
        )
        this.updateLocationCodeFromReferral()
      } else {
        this.showModal = true
      }
    },
    selectLocationCodeFromReferral() {
      this.register.locationCodeFromReferral.id = this.referralCode
      this.updateLocationCodeFromReferral()
      this.showModal = false
    },
    updateLocationCodeFromReferral() {
      for (const i of this.referralCodesTable) {
        if (this.register.locationCodeFromReferral.id == i.id) {
          this.register.locationCodeFromReferral.id = i.id
          this.register.locationCodeFromReferral.description = i.description
        }
      }
    },
    addNewReferralRegister() {
      //TODO
    },
    addNewReferralForm() {
      //TODO
    },
    resetFormReferralRegister() {
      this.register.locationCodeFromReferral.id = null
      this.register.locationCodeFromReferral.description = null
      this.register.referralRegisterReason = null
      this.register.referralRegisterDate = null
      this.register.referralRegisterDetails = null
    },
    resetFormReferralForm() {
      this.form.responsibleFamilyMemberIdentification = null
      this.form.localAttendanceDescription = null
      this.form.localAttendanceAddress = null
      this.form.needsIdentifiedBySocialAssistance = null
      this.form.referralFormDate = null
      this.form.referralPlaceOfOriginContact = null
      this.form.referralFormDetails = null
    },
    goToDispatchControlPage() {
      EventBus.$emit(this.$route.meta.eventBus)
      this.$router.push({ name: 'DispatchControl', params: { page: 1 } })
    }
  }
}
</script>
