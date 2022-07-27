export default {
  model: {
    prop: 'visible',
    event: 'change'
  },
  props: {
    viewModal: {
      default: null
    },
    editModal: {
      default: null
    },
    visible: {
      type: Boolean,
      default: false
    },
    lastPage: {
      type: Number,
      default: 0
    }
  },
  methods: {
    changeModal(visible) {
      this.$emit('change', visible)
    }
  }
}
