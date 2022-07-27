import http from '@/services/http-common'

const path = '/household'

class HouseholdService {
  getAll(currentPage) {
    return http.get(`${path}?pageNo=${currentPage}`)
  }

  getById(id) {
    return http.get(`${path}/view`, id)
  }

  getByFamilyReferenceName(search) {
    return http.get(`${path}/search?familyReference=${search}`)
  }

  new(data) {
    return http.post(`${path}/new`, data)
  }

  edit(data) {
    return http.put(`${path}/edit`, data)
  }

  getChildrenByFamilyId(familyId) {
    //TODO
    familyId = 1
    return http.get(`${path}/view/children/${familyId}`)
  }
}

export default new HouseholdService()
