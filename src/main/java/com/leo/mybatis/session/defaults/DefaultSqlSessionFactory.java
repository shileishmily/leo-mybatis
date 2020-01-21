package com.leo.mybatis.session.defaults;


import com.leo.mybatis.constants.Constant;
import com.leo.mybatis.session.Configuration;
import com.leo.mybatis.session.SqlSession;
import com.leo.mybatis.session.SqlSessionFactory;
import com.leo.mybatis.utils.CommonUtis;
import com.leo.mybatis.utils.XmlUtil;

import java.io.File;
import java.net.URL;


/**
 * @version V1.0
 * @Title: 会话工厂实现类
 * @ClassName: com.leo.mybatis.session.defaults.DefaultSqlSessionFactory.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 17:26
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    /**
     * 数据库配置
     */
    private final Configuration configuration;


    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
        loadMappersInfo(Configuration.getProperty(Constant.MAPPER_LOCATION).replaceAll("\\.", "/"));
    }

    /**
     * 建立会话
     *
     * @return : com.leo.mybatis.session.SqlSession
     * @author : shi_lei@suixingpay.com
     * @date :  10:25
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(this.configuration);
    }

    /**
     * 解析Mapper Xml文件
     *
     * @param dirName : “mapper.location”对应的XML文件位置
     * @return : void
     * @author : shi_lei@suixingpay.com
     * @date :  10:24
     */
    private void loadMappersInfo(String dirName) {

        URL resources = DefaultSqlSessionFactory.class.getClassLoader().getResource(dirName);

        File mappersDir = new File(resources.getFile());

        if (mappersDir.isDirectory()) {
            // 显示包下所有文件
            File[] mappers = mappersDir.listFiles();
            if (CommonUtis.isNotEmpty(mappers)) {
                for (File file : mappers) {
                    // 对文件夹继续递归
                    if (file.isDirectory()) {
                        loadMappersInfo(dirName + "/" + file.getName());
                    } else if (file.getName().endsWith(Constant.MAPPER_FILE_SUFFIX)) {
                        // 只对XML文件解析
                        XmlUtil.readMapperXml(file, this.configuration);
                    }
                }
            }
        }
    }
}
