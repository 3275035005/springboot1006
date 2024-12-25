package com.cn.practice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SpUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 账号/工号/学号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别 0女 1男
     */
    private String sex;

    /**
     * 班级
     */
    private String classs;
    /**
     * 头像
     */
    private String avatar;

    /**
     * 账号状态 0 审核中 1正常 2禁用
     */
    private String status;

    /**
     * 角色 1管理员 2教师 3学生
     */
    private String role;

    /**
     * 注册时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(exist = false)
    private String[] roles;

    /**
     * 接收原密码
     */
    @TableField(exist = false)
    private String oldPassword;

}
