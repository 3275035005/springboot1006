package com.cn.practice.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.practice.entity.SpMajor;
import com.cn.practice.entity.SpUser;
import com.cn.practice.service.SpMajorService;
import com.cn.practice.utils.page.PageResult;
import com.cn.practice.utils.response.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 专业信息表 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/sp-major")
public class SpMajorController {


    @Autowired
    private SpMajorService service;


    /**
     * 分页条件查询
     * @param page   当前页码
     * @param limit 每页的大小
     * @param data 封装查询条件数据
     * @return
     */
    @PostMapping("pageQuery/{page}/{limit}")
    public R getPageData(
            @PathVariable int page,
            @PathVariable int limit,
            @RequestBody SpMajor data){
        PageResult pageResult = service.pageQuery(page, limit, data);
        return R.ok().data("rows",pageResult);
    }

    /**
     * 修改操作
     * @param data
     * @return
     */
    @PutMapping("update")
    public R update(@RequestBody SpMajor data){
        service.updateById(data);
        return R.ok();
    }

    /**
     * 新增操作
     * @param data
     * @return
     */
    @PostMapping("insert")
    public R insert(@RequestBody SpMajor data){
        service.save(data);
        return R.ok();
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    @DeleteMapping("deleteById/{id}")
    public R deleteById(@PathVariable String id){
        service.removeById(id);
        return R.ok();
    }


    /**
     * 查询所有专业信息
     * @return
     */
    @GetMapping("getMajorAll")
    public R getMajorAll(){
        List<SpMajor> list = service.list(null);
        return R.ok().data("data",list);
    }


}

