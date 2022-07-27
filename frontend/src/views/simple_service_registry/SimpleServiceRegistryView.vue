<template :visible="visible">
  <div v-if="viewObject">
    <div class="main-content__top">
      <div class="main-content__title">
        <h4>Registro Simplificado do Atendimento</h4>
      </div>
    </div>
    <div class="main-content__body">
      <b-container fluid class="bv-example-row pl-0">
        <BreadCrumb />
        <SimplifiedServiceCollapse :object="object" :disabled="true" />
      </b-container>
    </div>
  </div>
</template>

<script>
import SimpleServiceRegistryService from '@/services/SimpleServiceRegistryService'
import pageVisibility from '@/mixins/pageVisibility'

export default {
  name: 'SimpleServiceRegistryView',
  mixins: [pageVisibility],
  data() {
    return {
      object: null
    }
  },
  created() {
    this.getSimpleServiceRegistryById(this.viewObject.id)
  },
  methods: {
    async getSimpleServiceRegistryById(id) {
      const response = await SimpleServiceRegistryService.getById(id)
      this.object = response.data
    }
  }
}
</script>
