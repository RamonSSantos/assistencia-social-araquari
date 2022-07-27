import http from '@/services/http-common'

class DepartmentService {
  getAll() {
    return http.get('/department')
  }
}

export default new DepartmentService()
