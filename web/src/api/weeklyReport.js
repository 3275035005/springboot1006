import request from '@/utils/request'


export function pageQuery(page, limit, data) {
  return request({
    url: `/sp-weekly-report/pageQuery/${page}/${limit}`,
    method: 'post',
    data: data
  })
}
export function insert(data){
  return request({
    url: `/sp-weekly-report/insert`,
    method: 'post',
    data: data
  })
}
export function sendReport(data){
  return request({
    url: `/sp-weekly-report/sendReport`,
    method: 'post',
    data: data
  })
}
export function update(data){
  return request({
    url: `/sp-weekly-report/update`,
    method: 'put',
    data: data
  })
}
export function deleteById(id) {
  return request({
    url: `/sp-weekly-report/deleteById/${id}`,
    method: 'delete'
  })
}
