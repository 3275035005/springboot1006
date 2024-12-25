package com.cn.practice.service;

import com.cn.practice.entity.SpPractice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.practice.utils.page.PageResult;

/**
 * <p>
 * 个人实习信息 服务类
 * </p>
 */
public interface SpPracticeService extends IService<SpPractice> {

    PageResult pageQuery(int page, int limit, SpPractice data);


    SpPractice getPracticeByStudentId(String studentId);

    PageResult pageQueryTeacher(int page, int limit, SpPractice data);
}
