package com.cn.practice.service.impl;

import com.cn.practice.entity.SpMajor;
import com.cn.practice.entity.SpMajor;
import com.cn.practice.mapper.SpMajorMapper;
import com.cn.practice.service.SpMajorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.practice.utils.page.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 专业信息表 服务实现类
 * </p>
 */
@Service
public class SpMajorServiceImpl extends ServiceImpl<SpMajorMapper, SpMajor> implements SpMajorService {

    @Override
    public PageResult pageQuery(int page, int limit, SpMajor data) {
        PageHelper.startPage(page, limit);
        List<SpMajor> queryList = baseMapper.pageQuery(data);
        PageInfo<SpMajor> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }
}
