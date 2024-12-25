package com.cn.practice.service;

import com.cn.practice.entity.SpWeeklyReport;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.practice.utils.page.PageResult;

/**
 * <p>
 * 实习周记 服务类
 * </p>
 */
public interface SpWeeklyReportService extends IService<SpWeeklyReport> {

    PageResult pageQuery(int page, int limit, SpWeeklyReport data);

}
