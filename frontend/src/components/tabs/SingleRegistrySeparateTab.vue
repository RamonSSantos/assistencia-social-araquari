<template>
  <div v-if="tabs">
    <b-tabs v-model="tabIndex" active-nav-item-class="font-weight-bold" card>
      <b-tab v-for="tab in tabs" :key="tab.id" :title="tab.title">
        <div v-if="tab.id === 1">
          <FamilyAddressDetailedForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </div>
        <template v-else-if="tab.id === 2">
          <InterviewerForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 3">
          <PropertyCharacteristicDetailedForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 4">
          <div v-if="formType === 2">
            <FamilyInformationForm
              :object="newObject"
              :visible="true"
              :disabled="disabled"
            />
          </div>
          <template v-else-if="formType === 3">
            <FamilyCompositionTable
              :object="newObject"
              :visible="true"
              :disabled="disabled"
            />
          </template>
        </template>
        <template v-else-if="tab.id === 5">
          <ResponsibleFamilyMemberForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
        </template>
        <template v-else-if="tab.id === 6">
          <FreeAnnotationToCityForm
            :object="newObject"
            :visible="true"
            :disabled="disabled"
          />
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
  name: 'SingleRegistrySeparateTab',
  mixins: [tabs],
  props: {
    formType: {
      type: Number,
      default: null
    }
  },
  created() {
    if (this.formType === 2) {
      this.tabs.splice(3, 0, {
        id: 4,
        title: '4. Família'
      })
    } else if (this.formType === 3) {
      this.tabs.splice(3, 0, {
        id: 4,
        title: '4. Composição Familiar'
      })
    }
  },
  beforeDestroy() {
    this.tabs.splice(3, 1)
  }
}
</script>
