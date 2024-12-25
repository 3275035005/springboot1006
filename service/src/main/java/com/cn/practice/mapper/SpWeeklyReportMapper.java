package com.cn.practice.mapper;

import com.cn.practice.entity.SpWeeklyReport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 实习周记 Mapper 接口
 * </p>
 */
public interface SpWeeklyReportMapper extends BaseMapper<SpWeeklyReport> {

    List<SpWeeklyReport> pageQuery(SpWeeklyReport data);

}
