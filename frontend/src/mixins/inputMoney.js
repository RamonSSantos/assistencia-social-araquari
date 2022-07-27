export default {
  props: {
    minlength: {
      type: Number,
      default: 7
    },
    maxlength: {
      type: Number,
      default: 10
    }
  },
  data() {
    return {
      price: 0,
      money: {
        decimal: ',',
        thousands: '.',
        prefix: 'R$ ',
        precision: 2,
        masked: false
      }
    }
  }
}
