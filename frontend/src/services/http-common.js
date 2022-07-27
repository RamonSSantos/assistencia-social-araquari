import axios from 'axios'
import store from '@/store'
import routes from '@/router'

const http = axios.create({
  baseURL: process.env.VUE_APP_API_BACKEND
})

http.interceptors.request.use(
  config => config,
  error => Promise.reject(error)
)

http.interceptors.response.use(
  response => response,
  error => {
    if (error.response.status === 500) {
      const notification = {
        type: 'danger',
        message:
          'O site está fora do ar...\nEntre em contato com o administrador!'
      }
      store.dispatch('notification/add', notification, { root: true })
      routes.push({ name: 'NetworkIssue' })
    } else {
      const notification = {
        type: 'danger',
        message: error.response.data
      }
      store.dispatch('notification/add', notification, { root: true })
    }
    return Promise.reject(error)
  }
)

export default http
