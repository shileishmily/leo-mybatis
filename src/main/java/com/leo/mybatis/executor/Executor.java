package com.leo.mybatis.executor;


import com.leo.mybatis.mapping.MappedStatement;

import java.util.List;


/**
 * @version V1.0
 * @Title: SQL执行器
 * @ClassName: com.leo.mybatis.executor.Executor.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 17:37
 */
public interface Executor {

    /**
     * 查询数据库
     *
     * @param ms
     * @param parameter
     * @return
     * @see
     */
    <E> List<E> doQuery(MappedStatement ms, Object parameter);

    /**
     * 更新操作
     *
     * @param ms
     * @param parameter
     */
    void doUpdate(MappedStatement ms, Object parameter);
}
