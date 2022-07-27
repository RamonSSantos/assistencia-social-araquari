<template :visible="visible">
  <b-form v-if="object">
    <b-card bg-variant="light" class="mt-3">
      <b-form-group
        id="primaryPhoneTypeGroup"
        label="Contato(s)"
        label-size="md"
        label-class="font-weight-bold"
      >
        <b-row>
          <b-col lg="3">
            <BaseRadio
              id="primaryPhoneType"
              label="Telefone Primário:"
              v-model="object.primaryPhoneType"
              :radio="primaryPhoneTypes"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
          <b-col lg="6" v-if="object.primaryPhoneType < 5">
            <InputTextPhone
              id="primaryPhone"
              label="Número:"
              v-model="object.primaryPhone"
              placeholder="Informe o número do telefone"
              :minlength="14"
              :maxlength="15"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="3" v-if="object.primaryPhoneType < 5">
            <BaseRadio
              id="primaryPhoneConfirmation"
              label="Autoriza recebimento de Mensagem?"
              v-model="object.primaryPhoneConfirmation"
              :radio="singleAnswers"
              :required="false"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="3">
            <BaseRadio
              id="secondaryPhoneType"
              label="Telefone Secundário:"
              v-model="object.secondaryPhoneType"
              :radio="primaryPhoneTypes"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
          <b-col lg="6" v-if="object.secondaryPhoneType < 5">
            <InputTextPhone
              id="secondaryPhone"
              label="Número:"
              v-model="object.secondaryPhone"
              placeholder="Informe o número do telefone"
              :minlength="14"
              :maxlength="15"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="3" v-if="object.secondaryPhoneType < 5">
            <BaseRadio
              id="secondaryPhoneConfirmation"
              label="Autoriza recebimento de Mensagem?"
              v-model="object.secondaryPhoneConfirmation"
              :radio="singleAnswers"
              :required="false"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="3">
            <BaseRadio
              id="emailType"
              label="E-mail:"
              v-model="object.emailType"
              :radio="emailTypes"
              :required="true"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
          <b-col lg="6" v-if="object.emailType < 3">
            <InputEmail
              id="email"
              ref="email"
              label="E-mail:"
              v-model="object.email"
              :isValidEmail.sync="isValidEmail"
              placeholder="meu@email.com"
              :maxlength="50"
              :required="false"
              :disabled="disabled"
            />
          </b-col>
          <b-col lg="3" v-if="object.emailType < 3">
            <BaseRadio
              id="newsletter"
              label="Autoriza recebimento de E-mail?"
              v-model="object.newsletter"
              :radio="singleAnswers"
              :required="false"
              :disabled="disabled"
              :selected="0"
            />
          </b-col>
        </b-row>
      </b-form-group>
    </b-card>
  </b-form>
</template>

<script>
import baseComponent from '@/mixins/baseComponent'
import primaryPhoneTypes from '@/models/primaryPhoneTypes'
import emailTypes from '@/models/emailTypes'
import singleAnswers from '@/models/singleAnswers'

export default {
  name: 'ResponsibleFamilyMemberForm',
  mixins: [baseComponent],
  data() {
    return {
      primaryPhoneTypes,
      emailTypes,
      singleAnswers,
      isValidEmail: null
    }
  }
}
</script>
