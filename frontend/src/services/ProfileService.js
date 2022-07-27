import http from '@/services/http-common'

class ProfileService {
  getAll() {
    return http.get('/profile')
  }
}

export default new ProfileService()
