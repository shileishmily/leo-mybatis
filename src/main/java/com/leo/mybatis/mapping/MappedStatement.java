package com.leo.mybatis.mapping;

import com.leo.mybatis.constants.Constant.SqlType;

/**
 * @version V1.0
 * @Title: 封装SQL属性
 * @ClassName: com.leo.mybatis.mapping.MappedStatement.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 10:21
 */
public final class MappedStatement {

    /**
     * mapper文件的namespace
     */
    private String namespace;

    /**
     * sql的id属性
     */
    private String sqlId;

    /**
     * sql语句，对应源码的sqlSource
     */
    private String sql;

    /**
     * 返回类型
     */
    private String resultType;

    /**
     * SQL命令类型，如：select/update/insert等
     */
    private SqlType sqlCommandType;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public SqlType getSqlCommandType() {
        return sqlCommandType;
    }

    public void setSqlCommandType(SqlType sqlCommandType) {
        this.sqlCommandType = sqlCommandType;
    }
}
