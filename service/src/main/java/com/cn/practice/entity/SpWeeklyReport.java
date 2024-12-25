package com.cn.practice.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.ArrayList;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 实习周记
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SpWeeklyReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 实习过程图片
     */
    private String imageList;

    /**
     * 实习内容
     */
    private String content;

    /**
     * 学生id
     */
    private String studentId;

    /**
     * 周
     */
    private String weeklyDate;



    /**
     * 提交时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


    @TableField(exist = false)
    private List<String> imageLists;


    public void setImageList(String imageList) {

        if(StringUtils.isEmpty(imageList)){
            this.imageLists =  new ArrayList<>();
        }else{
            this.imageLists =  JSONArray.parseArray(imageList, String.class);
        }

    }


    public void setImageLists(List<String> imageLists) {
        this.imageList = JSON.toJSONString(imageLists);
    }


}
