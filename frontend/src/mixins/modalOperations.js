export default {
  data() {
    return {
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
      this.newObject = Object
      this.newStatus = true
    },
    showViewObject(item) {
      this.viewObject = item
      this.viewStatus = true
    },
    showEditObject(item) {
      this.editObject = item
      this.editStatus = true
    }
  }
}
