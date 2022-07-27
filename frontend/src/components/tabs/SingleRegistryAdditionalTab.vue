<template>
  <div v-if="tabs">
    <b-tabs v-model="tabIndex" active-nav-item-class="font-weight-bold" card>
      <b-tab v-for="tab in tabs" :key="tab.id" :title="tab.title">
        <div v-if="tab.id === 1">
          <InterviewerForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </div>
        <template v-else-if="tab.id === 2">
          <div v-if="formType === 4">
            <LinkingToProgramsAndServicesForm
              :object="newObject"
              :visible="true"
              :disabled="disabled"
            />
          </div>
          <template v-else-if="formType === 5">
            <HomelessPersonForm
              :object="newObject"
              :visible="true"
              :disabled="disabled"
            />
          </template>
        </template>
      </b-tab>
    </b-tabs>
    <div class="text-center">
      <b-button-group class="mt-2">
        <BaseButton
          type="button"
          id="back"
          buttonName="Voltar"
          variant="secondary"
          @click="tabIndex--"
          :disabled="stateButtonBack"
          class="mr-1"
        />
        <BaseButton
          type="button"
          id="next"
          :buttonName="buttonName"
          :variant="variant"
          @click="tabIndex++"
          class="ml-1"
        />
      </b-button-group>
    </div>
  </div>
</template>

<script>
import tabs from '@/mixins/tabs'

export default {
  name: 'SingleRegistryAdditionalTab',
  mixins: [tabs],
  props: {
    formType: {
      type: Number,
      default: null
    }
  },
  created() {
    if (this.formType === 4) {
      this.tabs.splice(1, 0, {
        id: 2,
        title: '2. Vinculação a Programas e Serviços'
      })
    } else if (this.formType === 5) {
      this.tabs.splice(1, 0, {
        id: 2,
        title: '2. Identificação da Pessoa em Situação de Rua'
      })
    }
  },
  beforeDestroy() {
    this.tabs.splice(1, 1)
  }
}
</script>
