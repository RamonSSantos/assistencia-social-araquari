export default {
  inheritAttrs: false,
  props: {
    icon: {
      type: String,
      default: ''
    },
    variant: {
      type: String,
      default: 'primary'
    },
    fontScale: {
      type: String,
      default: '1'
    },
    animation: {
      type: String,
      default: null
    },
    scale: {
      type: [String, Number],
      default: 1
    },
    shiftV: {
      type: [String, Number],
      default: 0
    }
  }
}
