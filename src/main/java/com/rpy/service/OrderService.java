package com.rpy.service;

import com.rpy.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rpy.dto.OrderDto;

public interface OrderService extends IService<Order> {


    void createOrder(OrderDto dto);
}

