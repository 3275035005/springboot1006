import request from '@/utils/request'

export function pageQuery(page, limit, data) {
  return request({
    url: `/sp-major/pageQuery/${page}/${limit}`,
    method: 'post',
    data: data
  })
}
export function deleteById(id) {
  return request({
    url: `/sp-major/deleteById/${id}`,
    method: 'delete'
  })
}
export function insert(data){
  return request({
    url: `/sp-major/insert`,
    method: 'post',
    data: data
  })
}

export function update(data){
  return request({
    url: `/sp-major/update`,
    method: 'put',
    data: data
  })
}
export function getMajorAll() {
  return request({
    url: '/sp-major/getMajorAll',
    method: 'get'
  })
}
