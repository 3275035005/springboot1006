package com.cn.practice.service;

import com.cn.practice.entity.SpUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.practice.utils.page.PageResult;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 */
public interface SpUserService extends IService<SpUser> {

    PageResult pageQuery(int page, int limit, SpUser data);
}
