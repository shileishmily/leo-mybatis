package com.leo.mybatis.constants;

/**
 * @version V1.0
 * @Title: 常量类
 * @ClassName: com.leo.mybatis.constants.Constant.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 10:20
 */
public interface Constant {

    String CHARSET_UTF8 = "UTF-8";

    /******** 在properties文件中配置信息 start **************/
    String MAPPER_LOCATION = "mapper.location";
    String DB_DRIVER_CONF = "db.driver";
    String DB_URL_CONF = "db.url";
    String DB_USERNAME_CONF = "db.username";
    String db_PASSWORD = "db.password";
    /******** 在properties文件中配置信息 end **************/


    /************ mapper xml start  ****************/
    String MAPPER_FILE_SUFFIX = ".xml";
    String XML_ROOT_LABEL = "mapper";
    String XML_ELEMENT_ID = "id";
    String XML_SELECT_NAMESPACE = "namespace";
    String XML_SELECT_RESULTTYPE = "resultType";
    /************ mapper xml end  ****************/


    /**
     * SQL类型枚举
     */
    public enum SqlType {
        SELECT("select"),
        INSERT("insert"),
        UPDATE("update"),
        DEFAULT("default");

        private String value;

        private SqlType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

}
