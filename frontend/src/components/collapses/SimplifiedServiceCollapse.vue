<template>
  <div v-if="object" role="tablist">
    <b-card
      v-for="item in singleRegistryIdentificationItems"
      :key="item.id"
      no-body
      class="mb-1"
    >
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block v-b-toggle="`accordion-'${item.id}`" variant="dark">
          {{ item.title }}
        </b-button>
      </b-card-header>
      <b-collapse
        :id="`accordion-'${String(item.id)}`"
        accordion="simplified-service"
        role="tabpanel"
        :visible="item.visible"
      >
        <b-card-body>
          <div v-if="item.id === 1">
            <InterviewIdentificationAndControlForm
              :visible="true"
              :object="object"
              :disabled="disabled"
            />
          </div>
          <template v-else>
            Em construção
          </template>
        </b-card-body>
      </b-collapse>
    </b-card>
  </div>
</template>

<script>
import collapse from '@/mixins/collapse'
import singleRegistryIdentificationItems from '@/models/singleRegistryIdentificationItems'

export default {
  name: 'SimplifiedServiceCollapse',
  mixins: [collapse],
  data() {
    return {
      singleRegistryIdentificationItems
    }
  }
}
</script>
