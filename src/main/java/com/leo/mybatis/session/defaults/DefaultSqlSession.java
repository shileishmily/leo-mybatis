package com.leo.mybatis.session.defaults;


import com.leo.mybatis.executor.Executor;
import com.leo.mybatis.executor.SimpleExecutor;
import com.leo.mybatis.mapping.MappedStatement;
import com.leo.mybatis.session.Configuration;
import com.leo.mybatis.session.SqlSession;
import com.leo.mybatis.utils.CommonUtis;

import java.util.List;


/**
 * @version V1.0
 * @Title: 默认SQL会话实现类
 * @ClassName: com.leo.mybatis.session.defaults.DefaultSqlSession.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 17:32
 */
public class DefaultSqlSession implements SqlSession {

    private final Configuration configuration;

    private final Executor executor;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        this.executor = new SimpleExecutor(configuration);

    }


    @Override
    public <T> T selectOne(String statementId, Object parameter) {
        List<T> results = this.<T>selectList(statementId, parameter);

        return CommonUtis.isNotEmpty(results) ? results.get(0) : null;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object parameter) {
        MappedStatement mappedStatement = this.configuration.getMappedStatement(statementId);
        return this.executor.<E>doQuery(mappedStatement, parameter);
    }

    @Override
    public void update(String statementId, Object parameter) {
        MappedStatement mappedStatement = this.configuration.getMappedStatement(statementId);
        this.executor.doUpdate(mappedStatement, parameter);
    }

    @Override
    public void insert(String statementId, Object parameter) {
        //TODO 待实现
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.<T>getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return this.configuration;
    }

}
