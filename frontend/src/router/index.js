import Vue from 'vue'
import routes from './routes'
import Router from 'vue-router'
import store from '@/store'
import NProgress from 'nprogress'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach(async (to, from, next) => {
  document.title = `${to.meta.title} - Araquari | Assistência Social`

  NProgress.start()

  if (to.name !== 'Login' && !store.getters['auth/hasToken']) {
    try {
      await store.dispatch('auth/ActionCheckToken')
      next({ path: to.path })
    } catch {
      next({ name: 'Login' })
    }
  } else if (to.name === 'Login' && store.getters['auth/hasToken']) {
    next({ name: 'Home' })
  } else {
    next()
  }
})

router.afterEach(() => NProgress.done())

export default router
