export default {
  model: {
    prop: 'visible',
    event: 'change'
  },
  props: {
    newObject: {
      default: null
    },
    viewObject: {
      default: null
    },
    editObject: {
      default: null
    },
    visible: {
      type: Boolean,
      default: false
    }
  }
}
