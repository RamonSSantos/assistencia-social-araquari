import Vue from 'vue'
import VueResource from 'vue-resource'
import services from './services'
import interceptors from './interceptors'

Vue.use(VueResource)

const http = Vue.http

http.options.root = process.env.VUE_APP_API_BACKEND
http.interceptors.push(interceptors)

Object.keys(services).map(service => {
  services[service] = Vue.resource('', {}, services[service])
})

const setBearerToken = token => {
  Vue.http.headers.common['Authorization'] = `Bearer ${token}`
}

export default services
export { http, setBearerToken }
