<template :visible="visible">
  <div v-if="viewObject">
    <div class="main-content__top">
      <div class="main-content__title">
        <h4>Planejamento e Evolução do Acompanhamento Familiar</h4>
      </div>
    </div>
    <div class="main-content__body">
      <b-container fluid class="bv-example-row pl-0">
        <BreadCrumb />
      </b-container>
    </div>
  </div>
</template>

<script>
import pageVisibility from '@/mixins/pageVisibility'

export default {
  name: 'MonitoringView',
  mixins: [pageVisibility],
  data() {
    return {
      object: null
    }
  },
  created() {
    this.getAllMonitoringById(this.viewObject.id)
  },
  methods: {
    getAllMonitoringById() {
      //TODO
    }
  }
}
</script>
