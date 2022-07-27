import http from '@/services/http-common'

const path = '/subdepartment'

class SubdepartmentService {
  getAll(currentPage) {
    return http.get(`${path}?pageNo=${currentPage}`)
  }

  getBySubdepartment(search) {
    return http.get(`${path}/search?subdepartment=${search}`)
  }

  new(data) {
    return http.post(`${path}/new`, data)
  }

  edit(data) {
    return http.put(`${path}/edit`, data)
  }
}

export default new SubdepartmentService()
