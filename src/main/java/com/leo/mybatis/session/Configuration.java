package com.leo.mybatis.session;


import com.leo.mybatis.binding.MapperRegistry;
import com.leo.mybatis.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * @version V1.0
 * @Title: mybatis核心配置类
 * @ClassName: com.leo.mybatis.session.Configuration.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 17:21
 */
public class Configuration {

    //JDBC配置加载
    public static Properties PROPS = new Properties();
    //mapper代理注册器
    protected final MapperRegistry mapperRegistry = new MapperRegistry();
    //存放SQL语句ID，和SQL属性对象
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    /**
     * addMapper
     *
     * @param type
     */
    public <T> void addMapper(Class<T> type) {
        this.mapperRegistry.addMapper(type);
    }

    /**
     * getMapper
     *
     * @param type
     * @param sqlSession
     * @return
     * @see
     */
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return this.mapperRegistry.getMapper(type, sqlSession);
    }

    /**
     * addMappedStatement
     *
     * @param key
     * @param mappedStatement
     */
    public void addMappedStatement(String key, MappedStatement mappedStatement) {
        this.mappedStatements.put(key, mappedStatement);
    }

    /**
     * 获取MappedStatement
     *
     * @param id xml文件标签的id属性
     * @return
     * @see
     */
    public MappedStatement getMappedStatement(String id) {
        return this.mappedStatements.get(id);
    }

    /**
     * 获取字符型属性(默认值为空字符串)
     *
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        return getProperty(key, "");
    }

    /**
     * 获取字符型属性(可指定默认值)
     *
     * @param key
     * @param defaultValue 默认值
     * @return
     */
    public static String getProperty(String key, String defaultValue) {
        return PROPS.containsKey(key) ? PROPS.getProperty(key) : defaultValue;
    }

}
