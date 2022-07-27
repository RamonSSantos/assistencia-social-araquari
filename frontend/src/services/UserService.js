import http from '@/services/http-common'

const path = '/user'

class UserService {
  getAll(currentPage) {
    return http.get(`${path}?pageNo=${currentPage}`)
  }

  getByUser(search) {
    return http.get(`${path}/search?user=${search}`)
  }

  new(data) {
    return http.post(`${path}/new`, data)
  }

  edit(data) {
    return http.put(`${path}/edit`, data)
  }
}

export default new UserService()
