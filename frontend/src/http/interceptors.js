import store from '@/store'

export default () => {
  return ({ status }) => {
    if (status === 401) {
      store.dispatch('auth/ActionSignOut')
      window._Vue.$router.push({ name: 'Login' })
    } else if (status === 500) {
      const notification = {
        type: 'danger',
        message:
          'O site está fora do ar...\nEntre em contato com o administrador!'
      }
      store.dispatch('notification/add', notification, { root: true })
    }
  }
}
