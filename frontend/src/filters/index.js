import Vue from 'vue'
import moment from 'moment'

const maskCpf = Vue.filter('maskCpf', value => {
  if (value !== null) {
    if (value.toString().length < 11) {
      value = value.toString().padStart(11, '0')
    }
    // eslint-disable-next-line
    var newValue = value.toString().replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g,"\$1.\$2.\$3\-\$4");
    return newValue
  }
})

const maskDate = Vue.filter('maskDate', value => {
  if (value !== null) {
    return moment(String(value)).format('DD/MM/YYYY')
  }
})

export default {
  maskCpf,
  maskDate
}
