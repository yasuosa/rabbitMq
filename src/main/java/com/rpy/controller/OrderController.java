package com.rpy.controller;

import com.rpy.dto.OrderDto;
import com.rpy.service.OrderService;
import com.rpy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmq-springboot-taobao
 * @description: 订单管理
 * @author: 任鹏宇
 * @create: 2020-12-06 14:02
 **/
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("createOrder")
    public ResultVo createOrder(@RequestBody OrderDto dto){
        orderService.createOrder(dto);
        return ResultVo.success("创建订单成功");
    }
}
