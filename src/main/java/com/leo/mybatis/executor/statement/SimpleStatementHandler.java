package com.leo.mybatis.executor.statement;


import com.leo.mybatis.mapping.MappedStatement;
import com.leo.mybatis.utils.CommonUtis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @version V1.0
 * @Title: Statement处理实现类
 * @ClassName: com.leo.mybatis.executor.statement.SimpleStatementHandler.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 10:06
 */
public class SimpleStatementHandler implements StatementHandler {
    /**
     * #{}正则匹配
     */
    private static Pattern param_pattern = Pattern.compile("#\\{([^\\{\\}]*)\\}");

    private MappedStatement mappedStatement;


    public SimpleStatementHandler(MappedStatement mappedStatement) {
        this.mappedStatement = mappedStatement;
    }

    /**
     * SQL预处理
     *
     * @param connection :
     * @return : java.sql.PreparedStatement
     * @author : shi_lei@suixingpay.com
     * @date :  10:09
     */
    @Override
    public PreparedStatement prepare(Connection connection) throws SQLException {
        String originalSql = mappedStatement.getSql();

        if (CommonUtis.isNotEmpty(originalSql)) {
            // 替换#{}，预处理，防止SQL注入
            return connection.prepareStatement(parseSymbol(originalSql));
        } else {
            throw new SQLException("original sql is null.");
        }
    }

    /**
     * 查询
     *
     * @param preparedStatement :
     * @return : java.sql.ResultSet
     * @author : shi_lei@suixingpay.com
     * @date :  10:10
     */
    @Override
    public ResultSet query(PreparedStatement preparedStatement)
            throws SQLException {
        return preparedStatement.executeQuery();
    }

    /**
     * 修改
     *
     * @param preparedStatement :
     * @return : void
     * @author : shi_lei@suixingpay.com
     * @date :  10:10
     */
    @Override
    public void update(PreparedStatement preparedStatement)
            throws SQLException {
        preparedStatement.executeUpdate();
    }

    /**
     * 将SQL语句中的#{}替换为？，源码中是在SqlSourceBuilder类中解析的
     *
     * @param source :
     * @return : java.lang.String
     * @author : shi_lei@suixingpay.com
     * @date :  10:07
     */
    private static String parseSymbol(String source) {
        source = source.trim();
        Matcher matcher = param_pattern.matcher(source);
        return matcher.replaceAll("?");
    }

}
