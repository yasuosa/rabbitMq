package com.rpy.common;

/**
 * @program: rabbitmq-springboot-taobao
 * @description:
 * @author: 任鹏宇
 * @create: 2020-12-06 14:25
 **/
public interface Constants {


    Integer ORDER_STATUS_NO_PAY=0;
    Integer ORDER_STATUS_NO_RECEIVE=1;
    Integer ORDER_STATUS_FINISHED=2;
    Integer ORDER_STATUS_CANCEL = -1;
    String ORDER_PROFIX_OD = "OD";
}
