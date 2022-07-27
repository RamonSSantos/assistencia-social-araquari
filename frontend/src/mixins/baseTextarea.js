export default {
  inheritAtrrs: false,
  props: {
    value: {
      type: [String, Number],
      default: ''
    },
    id: {
      type: String,
      default: ''
    },
    label: {
      type: String,
      default: ''
    },
    placeholder: {
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
    },
    maxlength: {
      type: Number,
      default: 0
    },
    autofocus: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    updateValue(event) {
      this.$emit('input', event)
    }
  }
}
