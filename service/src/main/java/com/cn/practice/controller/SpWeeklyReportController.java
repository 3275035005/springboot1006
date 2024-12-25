package com.cn.practice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.practice.entity.SpPractice;
import com.cn.practice.entity.SpWeeklyReport;
import com.cn.practice.service.SpPracticeService;
import com.cn.practice.service.SpWeeklyReportService;
import com.cn.practice.utils.page.PageResult;
import com.cn.practice.utils.response.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 实习周记 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/sp-weekly-report")
public class SpWeeklyReportController {


    @Autowired
    private SpWeeklyReportService service;


    @Autowired
    private SpPracticeService spPracticeService;

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
            @RequestBody SpWeeklyReport data){
        Map<String, Object> list = new HashMap<>();

        PageResult pageResult = service.pageQuery(page, limit, data);
        List<SpWeeklyReport> records = pageResult.getRecords();
        for (SpWeeklyReport record : records) {
            // 查询实习总结
            SpPractice spPractice = spPracticeService.getOne(new QueryWrapper<SpPractice>().eq("student_id", record.getStudentId()));
            if(spPractice != null){
              if(StringUtils.isEmpty(spPractice.getReport())){
                  list.put("report", true);
              }else{
                  list.put("report", false);
              }
            }
        }
        list.put("rows",pageResult );
        return R.ok().data("list",list);
    }

    /**
     * 修改操作
     * @param data
     * @return
     */
    @PutMapping("update")
    public R update(@RequestBody SpWeeklyReport data){
        service.updateById(data);
        return R.ok();
    }

    /**
     * 新增操作
     * @param data
     * @return
     */
    @PostMapping("insert")
    public R insert(@RequestBody SpWeeklyReport data){
        SpWeeklyReport spWeeklyReport = service.getOne(new QueryWrapper<SpWeeklyReport>()
                .eq("weekly_date", data.getWeeklyDate())
                .eq("student_id",  data.getStudentId()));
        if(spWeeklyReport != null){
            return R.error("实习周记已提交，请勿重复提交");
        }
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
     *  实习报告提交
     */
    @PostMapping("sendReport")
    public R sendReport(@RequestBody SpPractice spPractice){
        SpPractice spPracticeNew = new SpPractice();
        spPracticeNew.setReport(spPractice.getReport());
        QueryWrapper<SpPractice> qw = new QueryWrapper<>();
        qw.eq("student_id", spPractice.getStudentId());
        spPracticeService.update(spPracticeNew, qw);
        return R.ok();
    }
}

