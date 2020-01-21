package com.leo.mybatis.executor.parameter;


import java.sql.PreparedStatement;


/**
 * @version V1.0
 * @Title: SQL参数处理类接口
 * @ClassName: com.leo.mybatis.executor.parameter.ParameterHandler.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 10:11
 */
public interface ParameterHandler {
    /**
     * 设置参数
     *
     * @param paramPreparedStatement :
     * @return : void
     * @author : shi_lei@suixingpay.com
     * @date :  10:11
     */
    void setParameters(PreparedStatement paramPreparedStatement);
}
