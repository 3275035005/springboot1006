package com.cn.practice.service.impl;

import com.cn.practice.entity.SpClass;
import com.cn.practice.entity.SpClass;
import com.cn.practice.mapper.SpClassMapper;
import com.cn.practice.service.SpClassService;
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
public class SpClassServiceImpl extends ServiceImpl<SpClassMapper, SpClass> implements SpClassService {

    @Override
    public PageResult pageQuery(int page, int limit, SpClass data) {
        PageHelper.startPage(page, limit);
        List<SpClass> queryList = baseMapper.pageQuery(data);
        PageInfo<SpClass> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }
}
