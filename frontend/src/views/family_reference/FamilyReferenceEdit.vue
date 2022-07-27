<template :visible="visible">
  <div v-if="editObject" role="tablist">
    <div class="main-content__top">
      <div class="main-content__title">
        <h4>Editar Referência Familiar</h4>
      </div>
    </div>
    <div class="main-content__body">
      <b-container fluid class="bv-example-row pl-0">
        <BreadCrumb />
        <FamilyInformationCollapse :object="editObject" :disabled="false" />
      </b-container>
    </div>
  </div>
</template>

<script>
import pageVisibility from '@/mixins/pageVisibility'

export default {
  name: 'FamilyReferenceEdit',
  mixins: [pageVisibility]
}
</script>
