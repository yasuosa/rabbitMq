package com.rpy.service.impl;

import cn.hutool.core.date.DateUtil;
import com.rpy.common.Constants;
import com.rpy.config.OrderRabbitMqConfig;
import com.rpy.dto.OrderDto;
import com.rpy.utils.IdGeneratorSnowflake;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rpy.mapper.OrderMapper;
import com.rpy.domain.Order;
import com.rpy.service.OrderService;
import org.yaml.snakeyaml.scanner.Constant;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void createOrder(OrderDto dto) {
        Order order = new Order();
        order.setId(IdGeneratorSnowflake.generatorIdWithProfix(Constants.ORDER_PROFIX_OD));
        order.setGoodsid(dto.getGoodsId());
        order.setUserid(dto.getUserId());
        order.setCreatetime(DateUtil.date());
        order.setStatus(Constants.ORDER_STATUS_NO_PAY);
        this.orderMapper.insert(order);

        rabbitTemplate.convertAndSend(OrderRabbitMqConfig.ORDER_NO_PAY_QUEUE_NAME, (Object)order.getId(),
                new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        message.getMessageProperties().setMessageId(order.getId());
                        return message;
                    }
                });

    }
}

