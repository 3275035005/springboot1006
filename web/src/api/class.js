import request from '@/utils/request'

export function pageQuery(page, limit, data) {
  return request({
    url: `/sp-class/pageQuery/${page}/${limit}`,
    method: 'post',
    data: data
  })
}
export function deleteById(id) {
  return request({
    url: `/sp-class/deleteById/${id}`,
    method: 'delete'
  })
}
export function insert(data){
  return request({
    url: `/sp-class/insert`,
    method: 'post',
    data: data
  })
}

export function update(data){
  return request({
    url: `/sp-class/update`,
    method: 'put',
    data: data
  })
}
export function getClassAll() {
  return request({
    url: '/sp-class/getClassAll',
    method: 'get'
  })
}
