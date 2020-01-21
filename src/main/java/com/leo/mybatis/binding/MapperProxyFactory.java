package com.leo.mybatis.binding;


import com.leo.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;


/**
 * @version V1.0
 * @Title: Mapper代理工厂
 * @ClassName: com.leo.mybatis.binding.MapperProxyFactory.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 9:46
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    /**
     * 初始化方法
     *
     * @param mapperInterface :
     * @return : null
     * @author : shi_lei@suixingpay.com
     * @date :  9:49
     */
    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * 根据sqlSession创建一个代理
     *
     * @param sqlSession :
     * @return : T
     * @author : shi_lei@suixingpay.com
     * @date :  9:47
     */
    public T newInstance(SqlSession sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<T>(sqlSession, this.mapperInterface);
        return newInstance(mapperProxy);
    }

    /**
     * 根据mapper代理返回实例
     *
     * @param mapperProxy :
     * @return : T
     * @author : shi_lei@suixingpay.com
     * @date :  9:47
     */
    @SuppressWarnings("unchecked")
    protected T newInstance(MapperProxy<T> mapperProxy) {
        return  (T) Proxy.newProxyInstance(this.mapperInterface.getClassLoader(), new Class[]{this.mapperInterface},
                mapperProxy);
    }
}
