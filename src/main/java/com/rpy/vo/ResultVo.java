package com.rpy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: rabbitmq-springboot-taobao
 * @description: 统一回复
 * @author: 任鹏宇
 * @create: 2020-12-06 11:26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo implements Serializable {

    private Integer code = 200;
    private String msg;

    private Object data;


    public static ResultVo success(String msg,Object data){
        return new ResultVo(200,msg,data);
    }

    public static ResultVo success(String msg){
        return success(msg,null);
    }

    public static ResultVo fail(String msg,Object data){
        return new ResultVo(400,msg,data);
    }


    public static ResultVo fail(String msg){
        return  fail(msg,null);
    }

}
