import services from '@/http'
import * as storage from '@/modules/auth/storage'
import * as types from './mutations-types'

export const ActionDoLogin = async ({ dispatch }, payload) => {
  const response = await services.auth.login(payload)
  dispatch('ActionSetToken', response.data.token)
  dispatch('ActionLoadSession')
  const notification = {
    type: 'success',
    message: 'Login realizado com sucesso!'
  }
  dispatch('notification/add', notification, { root: true })
}

export const ActionCheckToken = ({ dispatch, state }) => {
  if (state.token) {
    return Promise.resolve(state.token)
  }
  const token = storage.getLocalToken()
  if (!token) {
    return Promise.reject(new Error('Token Inválido'))
  }
  dispatch('ActionSetToken', token)
  return dispatch('ActionLoadSession')
}

export const ActionLoadSession = async ({ dispatch }) => {
  try {
    const response = await services.auth.loadSession()
    dispatch('ActionSetUser', response.body)
  } catch (err) {
    dispatch('ActionSignOut')
  }
}

export const ActionSetUser = ({ commit }, payload) => {
  commit(types.SET_USER, payload)
}

export const ActionGetUser = ({ state }) => {
  if (state.user) {
    return Promise.resolve(state.user)
  }
}

export const ActionSetToken = ({ commit }, payload) => {
  storage.setLocalToken(payload)
  storage.setHeaderToken(payload)
  commit(types.SET_TOKEN, payload)
}

export const ActionInvalidLogin = ({ dispatch }, error) => {
  const notification = {
    type: 'danger',
    message: error.bodyText
  }
  dispatch('notification/add', notification, { root: true })
}

export const ActionSignOut = async ({ dispatch }) => {
  let type = null
  let message = null
  try {
    const response = await services.auth.logout()
    storage.setHeaderToken('')
    storage.deleteLocalToken()
    dispatch('ActionSetUser', {})
    dispatch('ActionSetToken', '')
    type = 'warning'
    message = response.bodyText
  } catch (err) {
    type = 'danger'
    message = err.bodyText
  } finally {
    const notification = {
      type,
      message
    }
    dispatch('notification/add', notification, { root: true })
  }
}
