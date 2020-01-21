package com.leo.mybatis.binding;

import com.leo.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @Title:
 * @ClassName: com.leo.mybatis.binding.MapperRegistry.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 9:45
 */
public class MapperRegistry {
    //mapper类代理
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    /**
     * 注册代理工厂
     *
     * @param type :
     * @return : void
     * @author : shi_lei@suixingpay.com
     * @date :  9:44
     */
    public <T> void addMapper(Class<T> type) {
        this.knownMappers.put(type, new MapperProxyFactory<T>(type));
    }


    /**
     * 获取代理工厂实例
     *
     * @param type       :
     * @param sqlSession :
     * @return : T
     * @author : shi_lei@suixingpay.com
     * @date :  9:44
     */
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) this.knownMappers.get(type);
        return mapperProxyFactory.newInstance(sqlSession);
    }
}
