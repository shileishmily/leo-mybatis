package com.leo.mybatis.session;

import java.util.List;

/**
 * @version V1.0
 * @Title: 数据库连接session会话接口
 * @ClassName: com.leo.mybatis.session.SqlSession.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 17:24
 */
public interface SqlSession {

    /**
     * 查询带条记录
     *
     * @param statementId
     * @param parameter
     * @param <T>
     * @return
     */
    <T> T selectOne(String statementId, Object parameter);

    /**
     * 查询多条记录
     *
     * @param statementId
     * @param parameter
     * @param <E>
     * @return
     */
    <E> List<E> selectList(String statementId, Object parameter);

    /**
     * 修改
     *
     * @param statementId
     * @param parameter
     */
    void update(String statementId, Object parameter);


    /**
     * 新增
     *
     * @param statementId
     * @param parameter
     */
    void insert(String statementId, Object parameter);

    /**
     * 获取mapper
     *
     * @param paramClass
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> paramClass);

    /**
     * 获取配置
     *
     * @return
     */
    Configuration getConfiguration();
}
