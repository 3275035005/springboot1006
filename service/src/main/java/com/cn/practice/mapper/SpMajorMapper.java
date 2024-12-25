package com.cn.practice.mapper;

import com.cn.practice.entity.SpMajor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 专业信息表 Mapper 接口
 * </p>
 */
public interface SpMajorMapper extends BaseMapper<SpMajor> {

    List<SpMajor> pageQuery(SpMajor data);
}
