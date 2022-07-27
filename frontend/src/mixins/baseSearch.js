import _debounce from 'lodash/debounce'

export default {
  inheritAtrrs: false,
  props: {
    value: {
      type: [String, Number],
      default: null
    },
    id: {
      type: String,
      default: ''
    },
    placeholder: {
      type: String,
      default: ''
    }
  },
  methods: {
    updateValue: _debounce(function(event) {
      this.$emit('input', event)
    }, 500)
  }
}
