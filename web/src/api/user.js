import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/sp-user/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/sp-user/info',
    method: 'get',
    params: { token }
  })
}

export function pageQuery(page, limit, data) {
  return request({
    url: `/sp-user/pageQuery/${page}/${limit}`,
    method: 'post',
    data: data
  })
}
export function deleteById(id) {
  return request({
    url: `/sp-user/deleteById/${id}`,
    method: 'delete'
  })
}
export function insert(data){
  return request({
    url: `/sp-user/insert`,
    method: 'post',
    data: data
  })
}

export function update(data){
  return request({
    url: `/sp-user/update`,
    method: 'put',
    data: data
  })
}
export function getStudentAll() {
  return request({
    url: '/sp-user/getStudentAll',
    method: 'get'
  })
}

export function getTeacherAll() {
  return request({
    url: '/sp-user/getTeacherAll',
    method: 'get'
  })
}
export function getHome() {
  return request({
    url: '/sp-user/getHome',
    method: 'get'
  })
}

export function updatePassword(data) {
  return request({
    url: `/sp-user/updatePassword`,
    method: 'post',
    data: data
  })
}

export function forgetPassword(data) {
  return request({
    url: `/sp-user/forgetPassword`,
    method: 'post',
    data: data
  })
}


export function register(data) {
  return request({
    url: `/sp-user/register`,
    method: 'post',
    data: data
  })
}

export function resetPassword(id){
  return request({
    url: `/sp-user/resetPassword/`+id,
    method: 'post'
  })
}

