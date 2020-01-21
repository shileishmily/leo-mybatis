package com.leo.mybatis.executor.resultset;


import java.sql.ResultSet;
import java.util.List;

/**
 * @version V1.0
 * @Title: 返回结果处理类接口
 * @ClassName: com.leo.mybatis.executor.resultset.ResultSetHandler.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 10:15
 */
public interface ResultSetHandler {

    /**
     * 处理查询结果
     *
     * @param resultSet :
     * @return : java.util.List<E>
     * @author : shi_lei@suixingpay.com
     * @date :  10:15
     */
    <E> List<E> handleResultSets(ResultSet resultSet);

}
