export default {
  inheritAtrrs: false,
  props: {
    id: {
      type: String,
      default: ''
    },
    checkbox: {
      type: Array,
      default: () => []
    },
    label: {
      type: String,
      default: ''
    },
    required: {
      type: Boolean,
      default: false
    },
    disabled: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      value: []
    }
  },
  methods: {
    updateValue(event) {
      this.$emit('change', event)
    }
  }
}
