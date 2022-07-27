import http from '@/services/http-common'

const path = '/single-registry-identification'
class SimpleServiceRegistryService {
  getAll(currentPage) {
    return http.get(`${path}?pageNo=${currentPage}`)
  }

  getById(id) {
    return http.get(`${path}/view/${id}`)
  }

  getByHousehold(search) {
    return http.get(`${path}?search=${search}`)
  }

  new(data) {
    return http.post(`${path}/new`, data)
  }

  edit(data) {
    return http.put(`${path}/edit`, data)
  }
}

export default new SimpleServiceRegistryService()
