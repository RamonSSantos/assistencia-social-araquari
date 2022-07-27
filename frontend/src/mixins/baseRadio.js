export default {
  inheritAtrrs: false,
  props: {
    id: {
      type: String,
      default: ''
    },
    radio: {
      type: Array,
      default: () => []
    },
    selected: {
      type: Number,
      default: null
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
      value: ''
    }
  },
  created() {
    this.value = this.selected
  },
  methods: {
    updateValue(event) {
      this.$emit('change', event)
    }
  }
}
