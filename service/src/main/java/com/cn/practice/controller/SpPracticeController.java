package com.cn.practice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.practice.entity.SpPractice;
import com.cn.practice.service.SpPracticeService;
import com.cn.practice.utils.page.PageResult;
import com.cn.practice.utils.response.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 个人实习信息 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/sp-practice")
public class SpPracticeController {

    @Autowired
    private SpPracticeService service;


    /**
     * 学生个人实现信息分页条件查询
     * @param page   当前页码
     * @param limit 每页的大小
     * @param data 封装查询条件数据
     * @return
     */
    @PostMapping("pageQuery/{page}/{limit}")
    public R getPageData(
            @PathVariable int page,
            @PathVariable int limit,
            @RequestBody SpPractice data){
        PageResult pageResult = service.pageQuery(page, limit, data);
        return R.ok().data("rows",pageResult);
    }


    /**
     * 教师查询自己学生个人实习信息分页条件查询
     * @param page   当前页码
     * @param limit 每页的大小
     * @param data 封装查询条件数据
     * @return
     */
    @PostMapping("pageQueryTeacher/{page}/{limit}")
    public R pageQueryTeacher(
            @PathVariable int page,
            @PathVariable int limit,
            @RequestBody SpPractice data){
        PageResult pageResult = service.pageQueryTeacher(page, limit, data);
        return R.ok().data("rows",pageResult);
    }

    /**
     * 修改操作
     * @param data
     * @return
     */
    @PutMapping("update")
    public R update(@RequestBody SpPractice data){
        service.updateById(data);
        return R.ok();
    }

    /**
     * 新增操作
     * @param data
     * @return
     */
    @PostMapping("insert")
    public R insert(@RequestBody  SpPractice data){
        data.setStatus("0");
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
     * 查询个人实习信息
     */
    @GetMapping("getPracticeByStudentId")
    public R getPracticeByStudentId(String studentId){
       return R.ok().data("row", service.getPracticeByStudentId(studentId));
    }
}

