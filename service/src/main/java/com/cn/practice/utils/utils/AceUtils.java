package com.cn.practice.utils.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具类
 * @version 1.0
 */
public class AceUtils {


    /**
     * 返回当前日期时间字符串<br>
     * 默认格式:yyyy-mm-dd hh:mm:ss
     *
     *
     * @return String 返回当前字符串型日期时间
     */
    public static String getCurrentTime() {
        String returnStr = null;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        returnStr = f.format(date);
        return returnStr;
    }


}
