package com.leo.mybatis.executor.statement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version V1.0
 * @Title: Statement处理类接口
 * @ClassName: com.leo.mybatis.executor.statement.StatementHandler.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 10:04
 */
public interface StatementHandler {

    /**
     * SQL预处理
     *
     * @param paramConnection :
     * @return : java.sql.PreparedStatement
     * @author : shi_lei@suixingpay.com
     * @date :  10:05
     */
    PreparedStatement prepare(Connection paramConnection) throws SQLException;

    /**
     * 查询
     *
     * @param preparedStatement :
     * @return : java.sql.ResultSet
     * @author : shi_lei@suixingpay.com
     * @date :  10:05
     */
    ResultSet query(PreparedStatement preparedStatement) throws SQLException;

    /**
     * 修改
     *
     * @param preparedStatement :
     * @return : void
     * @author : shi_lei@suixingpay.com
     * @date :  10:05
     */
    void update(PreparedStatement preparedStatement) throws SQLException;
}
