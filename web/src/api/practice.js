import request from "@/utils/request";

export function pageQuery(page, limit, data) {
  return request({
    url: `/sp-practice/pageQuery/${page}/${limit}`,
    method: 'post',
    data: data
  })
}

export function pageQueryTeacher(page, limit, data) {
  return request({
    url: `/sp-practice/pageQueryTeacher/${page}/${limit}`,
    method: 'post',
    data: data
  })
}
export function insert(data){
  return request({
    url: `/sp-practice/insert`,
    method: 'post',
    data: data
  })
}

export function update(data){
  return request({
    url: `/sp-practice/update`,
    method: 'put',
    data: data
  })
}

export function getPracticeByStudentId(studentId) {
  return request({
    url: `/sp-practice/getPracticeByStudentId`,
    method: 'get',
    params: { studentId }
  })
}
