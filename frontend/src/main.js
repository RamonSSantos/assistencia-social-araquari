import Vue from 'vue'
import App from './App'
import store from './store'
import router from './router'
import ComponentsConfig from '@/components/index'
import { BootstrapVue, BootstrapVueIcons } from 'bootstrap-vue'
import VueTheMask from 'vue-the-mask'
import money from 'v-money'
import Filters from '@/filters/index'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'bootstrap-vue/dist/bootstrap-vue-icons.min.css'
import 'nprogress/nprogress.css'

Vue.use(ComponentsConfig)
Vue.use(BootstrapVue)
Vue.use(BootstrapVueIcons)
Vue.use(VueTheMask)
Vue.use(money, { precision: 4 })
Vue.use(Filters)

window.bus = new Vue()

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
