package com.leo.mybatis.session;

/**
 * @version V1.0
 * @Title: SQL会话工厂接口
 * @ClassName: com.leo.mybatis.session.SqlSessionFactory.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 10:26
 */
public interface SqlSessionFactory {

    /**
     * 创建数据库会话
     *
     * @return : com.leo.mybatis.session.SqlSession
     * @author : shi_lei@suixingpay.com
     * @date :  17:24
     */
    SqlSession openSession();

}
