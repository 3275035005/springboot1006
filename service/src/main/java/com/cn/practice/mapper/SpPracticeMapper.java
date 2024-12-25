package com.cn.practice.mapper;

import com.cn.practice.entity.SpPractice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 个人实习信息 Mapper 接口
 * </p>
 */
public interface SpPracticeMapper extends BaseMapper<SpPractice> {

    List<SpPractice> pageQuery(SpPractice data);

    SpPractice getPracticeByStudentId(String studentId);

    List<SpPractice> pageQueryTeacher(SpPractice data);
}
