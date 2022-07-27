export default {
  inheritAtrrs: false,
  model: {
    prop: 'currentPage',
    event: 'change'
  },
  props: {
    currentPage: Number,
    perPage: Number,
    totalRows: Number,
    minRows: {
      type: Number,
      default: 10
    }
  },
  methods: {
    updatePage(event) {
      this.$emit('change', event)
    }
  },
  watch: {
    totalRows(newValue) {
      this.totalRows = newValue
    }
  }
}
