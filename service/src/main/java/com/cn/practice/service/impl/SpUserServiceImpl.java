package com.cn.practice.service.impl;

import com.cn.practice.entity.SpUser;
import com.cn.practice.mapper.SpUserMapper;
import com.cn.practice.service.SpUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.practice.utils.page.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 */
@Service
public class SpUserServiceImpl extends ServiceImpl<SpUserMapper, SpUser> implements SpUserService {

    @Override
    public PageResult pageQuery(int page, int limit, SpUser data) {
        PageHelper.startPage(page, limit);
        List<SpUser> queryList = baseMapper.pageQuery(data);
        PageInfo<SpUser> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }
}
