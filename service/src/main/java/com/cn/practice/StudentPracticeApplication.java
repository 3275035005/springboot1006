package com.cn.practice;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 项目启动类
 **/
@MapperScan("com.cn.practice.mapper") // 配置包扫描
@SpringBootApplication
public class StudentPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentPracticeApplication.class);
    }



}
