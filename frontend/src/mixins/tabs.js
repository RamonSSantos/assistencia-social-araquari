export default {
  props: {
    tabs: {
      type: Array,
      default: () => [{}]
    },
    disabled: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      tabIndex: 0,
      newObject: {}
    }
  },
  computed: {
    stateButtonBack() {
      return this.tabIndex === 0 ? true : false
    },
    buttonName() {
      if (this.tabIndex !== this.tabs.length - 1) {
        return 'Avançar'
      } else {
        return 'Concluir'
      }
    },
    variant() {
      if (this.tabIndex !== this.tabs.length - 1) {
        return 'dark'
      } else {
        return 'info'
      }
    }
  }
}
