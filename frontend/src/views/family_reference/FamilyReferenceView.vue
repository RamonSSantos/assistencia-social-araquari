<template :visible="visible">
  <div v-if="viewObject" role="tablist">
    <div class="main-content__top">
      <div class="main-content__title">
        <h4>Visualizar Referência Familiar</h4>
      </div>
    </div>
    <div class="main-content__body">
      <b-container fluid class="bv-example-row pl-0">
        <BreadCrumb />
        <FamilyInformationCollapse :object="viewObject" :disabled="true" />
      </b-container>
    </div>
  </div>
</template>

<script>
import pageVisibility from '@/mixins/pageVisibility'

export default {
  name: 'FamilyReferenceView',
  mixins: [pageVisibility]
}
</script>
