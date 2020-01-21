package com.leo.mybatis.suixingpay;


import com.leo.mybatis.session.SqlSession;
import com.leo.mybatis.session.SqlSessionFactory;
import com.leo.mybatis.session.SqlSessionFactoryBuilder;
import com.leo.mybatis.suixingpay.bean.User;
import com.leo.mybatis.suixingpay.dao.UserMapper;


public class TestMain {


    public static void main(String[] args) {

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build("conf.properties");
        SqlSession session = factory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUser("1");
        System.out.println("******* " + user.getName());
//        System.out.println("*******all " + userMapper.getAll().size());
    }

}
