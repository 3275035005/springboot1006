package com.cn.practice.mapper;

import com.cn.practice.entity.SpUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 */
public interface SpUserMapper extends BaseMapper<SpUser> {

    List<SpUser> pageQuery(SpUser data);
}
