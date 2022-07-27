export default {
  inheritAttrs: false,
  props: {
    type: {
      type: String,
      default: ''
    },
    id: {
      type: String,
      default: ''
    },
    buttonName: {
      type: String,
      default: ''
    },
    variant: {
      type: String,
      default: ''
    },
    disabled: {
      type: Boolean,
      default: false
    },
    pill: {
      type: Boolean,
      default: false
    },
    block: {
      type: Boolean,
      default: false
    },
    icon: {
      type: String,
      default: ''
    },
    buttonWithSpinner: {
      type: Boolean,
      default: false
    },
    loadingSpinner: {
      type: Boolean,
      default: false
    }
  }
}
