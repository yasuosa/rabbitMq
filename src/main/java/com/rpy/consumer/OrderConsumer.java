package com.rpy.consumer;

import com.rabbitmq.client.Channel;
import com.rpy.common.Constants;
import com.rpy.config.OrderRabbitMqConfig;
import com.rpy.domain.Order;
import com.rpy.mapper.OrderMapper;
import com.rpy.service.OrderService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @program: rabbitmq-springboot-taobao
 * @description:
 * @author: 任鹏宇
 * @create: 2020-12-06 14:28
 **/
@Component
public class OrderConsumer {

    @Lazy
    @Autowired
    private OrderService orderService;

    /**
     * 24小时内未完成支付
     * @param orderId
     * @param message
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queuesToDeclare = @Queue(OrderRabbitMqConfig.ORDER_CANCEL_QUEUE_NAME))
    public void orderCancelMessage(String orderId, Message message, Channel channel) throws IOException {
        Order order = this.orderService.getById(orderId);
        if (Constants.ORDER_STATUS_NO_PAY.equals(order.getStatus())){
            order.setStatus(Constants.ORDER_STATUS_CANCEL);
            this.orderService.updateById(order);
        }
        // 不管怎么样 24内后这条消息 要被签收
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),
                false);
    }
}
