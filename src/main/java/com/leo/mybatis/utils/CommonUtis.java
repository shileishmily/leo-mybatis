package com.leo.mybatis.utils;


import java.util.Collection;
import java.util.Map;

/**
 * @version V1.0
 * @Title: 工具类
 * @ClassName: com.leo.mybatis.utils.CommonUtis.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 9:53
 */
public final class CommonUtis {

    public static boolean isNotEmpty(String src) {
        return src != null && src.trim().length() > 0;
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return collection != null && !collection.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return map != null && !map.isEmpty();
    }

    public static boolean isNotEmpty(Object[] arr) {
        return arr != null && arr.length > 0;
    }

    /**
     * 对字符串去空白符和换行符等
     *
     * @param src :
     * @return : java.lang.String
     * @author : shi_lei@suixingpay.com
     * @date :  9:53
     */
    public static String stringTrim(String src) {
        return (null != src) ? src.trim() : null;
    }
}
