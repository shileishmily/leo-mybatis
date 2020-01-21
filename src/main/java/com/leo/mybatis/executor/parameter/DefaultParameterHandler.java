package com.leo.mybatis.executor.parameter;


import java.sql.PreparedStatement;

/**
 * @version V1.0
 * @Title: 参数处理实现类
 * @ClassName: com.leo.mybatis.executor.parameter.DefaultParameterHandler.java
 * @Description:
 * @Copyright ©2018 Suixingpay. All rights reserved.
 * @author: shi_lei@suixingpay.com
 * @date: 10:12
 */
public class DefaultParameterHandler implements ParameterHandler {

    private Object parameter;

    public DefaultParameterHandler(Object parameter) {
        this.parameter = parameter;
    }

    /**
     * 将SQL参数设置到PreparedStatement中
     *
     * @param ps :
     * @return : void
     * @author : shi_lei@suixingpay.com
     * @date :  10:12
     */
    @Override
    public void setParameters(PreparedStatement ps) {
        try {
            if (null != parameter) {
                if (parameter.getClass().isArray()) {
                    Object[] params = (Object[]) parameter;
                    for (int i = 0; i < params.length; i++) {
                        ps.setObject(i + 1, params[i]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
