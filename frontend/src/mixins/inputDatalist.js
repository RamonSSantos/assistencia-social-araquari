export default {
  props: {
    idDatalist: {
      type: Number,
      default: null
    },
    datalist: {
      type: String,
      default: ''
    },
    sizes: {
      type: Array,
      default: () => [{}]
    }
  },
  data() {
    return {
      validation: null
    }
  },
  methods: {
    updateList(event) {
      this.$emit('update:idDatalist', null)
      this.validation = false
      for (let i of this.sizes) {
        if (event === i.description) {
          this.validation = true
          this.$emit('update:idDatalist', i.id)
        }
      }
      this.$emit('input', event)
    }
  }
}
