package com.cn.practice.service.impl;

import com.cn.practice.entity.SpPractice;
import com.cn.practice.entity.SpPractice;
import com.cn.practice.mapper.SpPracticeMapper;
import com.cn.practice.service.SpPracticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.practice.utils.page.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 个人实习信息 服务实现类
 * </p>
 */
@Service
public class SpPracticeServiceImpl extends ServiceImpl<SpPracticeMapper, SpPractice> implements SpPracticeService {

    @Override
    public PageResult pageQuery(int page, int limit, SpPractice data) {
        PageHelper.startPage(page, limit);
        List<SpPractice> queryList = baseMapper.pageQuery(data);
        PageInfo<SpPractice> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }

    @Override
    public SpPractice getPracticeByStudentId(String studentId) {
        return baseMapper.getPracticeByStudentId(studentId);
    }

    @Override
    public PageResult pageQueryTeacher(int page, int limit, SpPractice data) {
        PageHelper.startPage(page, limit);
        List<SpPractice> queryList = baseMapper.pageQueryTeacher(data);
        PageInfo<SpPractice> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }
}
