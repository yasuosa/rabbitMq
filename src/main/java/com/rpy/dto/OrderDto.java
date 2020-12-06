package com.rpy.dto;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

/**
 * @program: rabbitmq-springboot-taobao
 * @description:
 * @author: 任鹏宇
 * @create: 2020-12-06 14:05
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Serializable {


    private Integer userId;
    private Integer goodsId;
}
