package com.cn.practice.service.impl;

import com.cn.practice.entity.SpWeeklyReport;
import com.cn.practice.entity.SpWeeklyReport;
import com.cn.practice.mapper.SpWeeklyReportMapper;
import com.cn.practice.service.SpWeeklyReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.practice.utils.page.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 实习周记 服务实现类
 * </p>
 */
@Service
public class SpWeeklyReportServiceImpl extends ServiceImpl<SpWeeklyReportMapper, SpWeeklyReport> implements SpWeeklyReportService {

    @Override
    public PageResult pageQuery(int page, int limit, SpWeeklyReport data) {
        PageHelper.startPage(page, limit);
        List<SpWeeklyReport> queryList = baseMapper.pageQuery(data);
        PageInfo<SpWeeklyReport> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }
}
