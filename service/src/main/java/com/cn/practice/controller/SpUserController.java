package com.cn.practice.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.practice.entity.SpPractice;
import com.cn.practice.entity.SpUser;
import com.cn.practice.entity.SpWeeklyReport;
import com.cn.practice.service.SpPracticeService;
import com.cn.practice.service.SpUserService;
import com.cn.practice.service.SpWeeklyReportService;
import com.cn.practice.utils.page.PageResult;
import com.cn.practice.utils.response.R;
import com.cn.practice.utils.utils.AceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/sp-user")
public class SpUserController {
    @Autowired
    private SpUserService tUserService;

    @Autowired
    private SpWeeklyReportService spWeeklyReportService;

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
            @RequestBody SpUser data){
        PageResult pageResult = tUserService.pageQuery(page, limit, data);
        return R.ok().data("rows",pageResult);
    }

    /**
     * 修改操作
     * @param data
     * @return
     */
    @PutMapping("update")
    public R update(@RequestBody SpUser data){
        tUserService.updateById(data);
        return R.ok();
    }

    /**
     * 新增操作
     * @param data
     * @return
     */
    @PostMapping("insert")
    public R insert(@RequestBody  SpUser data){
        tUserService.save(data);
        return R.ok();
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    @DeleteMapping("deleteById/{id}")
    public R deleteById(@PathVariable String id){
        tUserService.removeById(id);
        return R.ok();
    }


    /**
     * 平台登录
     * @param tUser
     * @return
     */
    @PostMapping("login")
    public R login(@RequestBody SpUser tUser){

        QueryWrapper<SpUser> qw = new QueryWrapper<>();
        LambdaQueryWrapper<SpUser> lambda = qw.lambda();
        lambda.eq(SpUser::getUsername, tUser.getUsername());
        SpUser tUser1 = tUserService.getOne(qw);
        if(tUser1 == null){
            return R.error("账号不存在");
        }
        if(!tUser.getPassword().equals(tUser1.getPassword())){
            return R.error("密码不正确");
        }

        if("0".equals(tUser1.getStatus())){
            return R.error("账号审核中");
        }else  if("2".equals(tUser1.getStatus())){
            return R.error("账号已被禁用");
        }
        return R.ok().data("token",tUser1.getId());
    }

    /**
     * 修改密码
     */
    @PostMapping("updatePassword")
    public R updatePassword(@RequestBody SpUser data){
        SpUser pUser = tUserService.getById(data.getId());
        if(!data.getOldPassword().equals(pUser.getPassword())){
            return R.error("旧密码不正确");
        }
        // 更新密码
        pUser.setPassword(data.getPassword());
        tUserService.updateById(pUser);
        return R.ok();
    }

    /**
     * 通过用户id获取信息
     * @return
     */
    @GetMapping("info")
    public R info(String token){
        SpUser tUser = tUserService.getById(token);
        if("1".equals(tUser.getRole())){
            tUser.setRoles(new String[]{"admin"});
        }else if("2".equals(tUser.getRole())){
            tUser.setRoles(new String[]{"teacher"});
        }else if("3".equals(tUser.getRole())){
            tUser.setRoles(new String[]{"student"});
        }

        return R.ok().data("data",tUser);
    }

    /**
     * 获取所有教师
     * @return
     */
    @GetMapping("getTeacherAll")
    public R getTeacherAll(){
        QueryWrapper<SpUser> qw = new QueryWrapper<>();
        LambdaQueryWrapper<SpUser> lambda = qw.lambda();
        lambda.eq(SpUser::getRole, "2");
        List<SpUser> list = tUserService.list(qw);
        return R.ok().data("data",list);
    }

    /**
     * 获取所有学生
     * @return
     */
    @GetMapping("getStudentAll")
    public R getStudentAll(){
        QueryWrapper<SpUser> qw = new QueryWrapper<>();
        LambdaQueryWrapper<SpUser> lambda = qw.lambda();
        lambda.eq(SpUser::getRole, "3");
        List<SpUser> list = tUserService.list(qw);
        return R.ok().data("data",list);
    }

    /**
     * 查询首页统计数据
     * @return
     */
    @GetMapping("getHome")
    public R getHome(){
        Map<String, Integer> map = new HashMap<>();

        QueryWrapper<SpUser> qw = new QueryWrapper<>();
        LambdaQueryWrapper<SpUser> lambda = qw.lambda();
        lambda.eq(SpUser::getRole, "3");
        int studentNumber = tUserService.count(qw);
        map.put("studentNumber",studentNumber);

        QueryWrapper<SpUser> qw1 = new QueryWrapper<>();
        LambdaQueryWrapper<SpUser> lambda1 = qw1.lambda();
        lambda1.eq(SpUser::getRole, "2");
        int teacherNumber = tUserService.count(qw1);
        map.put("teacherNumber",teacherNumber);

        int weeklyReportNumber = spWeeklyReportService.count(null);
        map.put("weeklyReportNumber", weeklyReportNumber);

        int practiceNumber = spPracticeService.count(new QueryWrapper<SpPractice>()
                .eq("status", "1"));

        map.put("practiceNumber", practiceNumber);
        return R.ok().data("data",map);
    }

    /**
     * 忘记密码
     */
    @PostMapping("forgetPassword")
    public R forgetPassword(@RequestBody SpUser spUser){

        LambdaQueryWrapper<SpUser> qw  = new LambdaQueryWrapper<>();
        qw.eq(SpUser::getName, spUser.getName());
        qw.eq(SpUser::getSex, spUser.getSex());
        qw.eq(SpUser::getPhone, spUser.getPhone());
        qw.eq(SpUser::getUsername, spUser.getUsername());

        SpUser spUser1 = tUserService.getOne(qw);
        if(spUser1 == null){
            return R.error("找回资料不正确，无法找回");
        }
        spUser1.setPassword(spUser.getPassword());
        tUserService.updateById(spUser1);
        return R.ok();
    }

    /**
     * 注册账号
     */
    @PostMapping("register")
    public R register(@RequestBody SpUser spUser){

        QueryWrapper<SpUser> qw = new QueryWrapper<>();
        LambdaQueryWrapper<SpUser> lambda = qw.lambda();
        lambda.eq(SpUser::getUsername, spUser.getUsername());
        SpUser tUser1 = tUserService.getOne(qw);
        if(tUser1 != null){
            return R.error("账号已存在，无法注册");
        }

        spUser.setStatus("0");
        spUser.setRole("3");

        tUserService.save(spUser);
        return R.ok();
    }
}

