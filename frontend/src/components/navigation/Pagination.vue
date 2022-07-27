<template>
  <b-row v-if="totalRows > minRows ? true : false">
    <b-col cols="6" class="my-1 offset-3">
      <b-pagination
        @input="updatePage"
        v-bind="$attrs"
        v-on="listeners"
        v-model="currentPage"
        :per-page="perPage"
        :total-rows="totalRows"
        align="fill"
        size="sm"
        class="my-0"
        pills
      ></b-pagination>
    </b-col>
  </b-row>
</template>

<script>
import pagination from '@/mixins/pagination'

export default {
  name: 'Pagination',
  mixins: [pagination],
  computed: {
    listeners() {
      return {
        ...this.$listeners,
        input: this.updatePage
      }
    }
  }
}
</script>
