export default {
  data() {
    return {
      listStatus: {
        type: Boolean,
        default: true
      },
      newStatus: false,
      viewStatus: false,
      editStatus: false,
      newObject: null,
      viewObject: null,
      editObject: null
    }
  },
  methods: {
    showNewObject() {
      this.newObject = new Object()
      this.newStatus = true
      this.listStatus = false
    },
    showViewObject(item) {
      this.viewObject = item
      this.viewStatus = true
      this.listStatus = false
    },
    showEditObject(item) {
      this.editObject = item
      this.editStatus = true
      this.listStatus = false
    }
  }
}
