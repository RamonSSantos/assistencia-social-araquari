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
    }
  },
  data() {
    return {
      date: null,
      now: new Date(),
      maxDate: '',
      minDate: '1900-01-01'
    }
  },
  created() {
    this.maxDate = this.now.toISOString().slice(0, 10)
  },
  methods: {
    updateValue(event) {
      this.$emit('input', event)
    }
  }
}
