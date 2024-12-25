package com.cn.practice.service;

import com.cn.practice.entity.SpMajor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.practice.utils.page.PageResult;

/**
 * <p>
 * 专业信息表 服务类
 * </p>
 */
public interface SpMajorService extends IService<SpMajor> {

    PageResult pageQuery(int page, int limit, SpMajor data);

}
