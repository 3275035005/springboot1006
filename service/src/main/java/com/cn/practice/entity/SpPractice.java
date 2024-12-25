package com.cn.practice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 个人实习信息
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SpPractice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 学生id
     */
    private String studentId;

    /**
     * 教师id
     */
    private String teacherId;

    /**
     * 实习单位
     */
    private String unit;

    /**
     * 实习单位所在地
     */
    private String unitAddress;

    /**
     * 岗位描述
     */
    private String jobDescription;

    /**
     * 计划安排
     */
    private String plan;

    /**
     * 实习状态（0实习中 1实习完成 2不实习）
     */
    private String status;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 评语
     */
    private String remark;

    /**
     * 专业id
     */
    private String majorId;

    /**
     * 填写时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 实习开始时间
     */
    private String startDate;

    /**
     * 实习结束时间
     */
    private String endDate;

    /**
     * 实习报告
     */
    private String report;


    @TableField(exist = false)
    private String[] startEndDate;


    /**
     * 学生姓名
     */
    @TableField(exist = false)
    private String studentName;

    /**
     * 教师姓名
     */
    @TableField(exist = false)
    private String teacherName;

    /**
     * 专业
     */
    @TableField(exist = false)
    private String majorName;


    /**
     * 联系方式
     */
    @TableField(exist = false)
    private String phone;

    /**
     * 学号
     */
    @TableField(exist = false)
    private String username;
    /**
     * 班级
     */
    @TableField(exist = false)
    private String classs;

    /**
     * 性别 0女 1男
     */
    @TableField(exist = false)
    private String sex;

    /**
     * 班级
     */
    @TableField(exist = false)
    private String className;

    @TableField(exist = false)
    private List<SpWeeklyReport> weeklyReportList;



    public String[] getStartEndDate() {
        return startEndDate;
    }

    public void setStartEndDate(String[] startEndDate) {
        if(startEndDate !=null && startEndDate.length > 0){
            this.startDate = startEndDate[0];
            this.endDate = startEndDate[1];
        }
    }
}
