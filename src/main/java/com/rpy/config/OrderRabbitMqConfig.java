package com.rpy.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: rabbitmq-springboot-taobao
 * @description: 订单消息队列配置
 * @author: 任鹏宇
 * @create: 2020-12-06 14:07
 **/
@Configuration
public class OrderRabbitMqConfig {

    /**
     * 死信交互机名称
     */
    public static final String  ORDER_DEALY_EXCHANGE_NAME="OrderNoPay.exc";

    /**
     * 死信队列（取消订单队列）的路由
     */
    public static final String ROUTING_KEY_ORDER ="OrderNoPay.key";

    /**
     * 未支付队列名称
     */
    public static final String ORDER_NO_PAY_QUEUE_NAME="orderNoPayQueue";

    /**
     * 订单取消队列名
     */
    public static final String ORDER_CANCEL_QUEUE_NAME="orderCancelPayQueue";

//    private static final Integer TIME=24* 3600 * 1000;
    private static final Integer TIME=10 * 1000;

    /**
     * 延迟队列 订单创建成功 但未支付
     * @return
     */
    @Bean
    public Queue orderNoPayQueue(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", TIME); // 24小时
        args.put("x-dead-letter-exchange", ORDER_DEALY_EXCHANGE_NAME); // 该队列里面的消息 死了，去那个交换机
        args.put("x-dead-letter-routing-key", ROUTING_KEY_ORDER); // 该队列里面的消 息死了，去那个交换机, 由那个路由 key 路由他
        Queue queue=new Queue(ORDER_NO_PAY_QUEUE_NAME,true,false,false,args);
        return queue;
    }

    /**
     * 死信交互及
     * @return
     */
    @Bean
    public DirectExchange orderNoPayExchange(){
        DirectExchange directExchange=new DirectExchange(ORDER_DEALY_EXCHANGE_NAME);
        return directExchange;
    }

    /**
     * 24小时内都未支付
     * @return
     */
    @Bean
    public Queue orderCancelPayQueue(){
        Queue queue=new Queue(ORDER_CANCEL_QUEUE_NAME,true);
        return queue;
    }

    /**
     * 绑定订单取消队列和交互机
     * @return
     */
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(orderCancelPayQueue()).to(orderNoPayExchange()).with(ROUTING_KEY_ORDER);
    }
}
