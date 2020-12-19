/*
 * Copyright © 2020 287664409@qq.com Inc. All rights reserved
 * @description: com.moses.framework.samples.strategy.OrderService
 * @version V1.0
 */
package com.moses.framework.samples.strategy.service;

import com.moses.framework.samples.strategy.entity.Order;
import com.moses.framework.samples.strategy.handler.OrderHandler;
import com.moses.framework.samples.strategy.service.impl.OrderHandlerTypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 订单服务
 *
 * @author Moses
 * @date 2020/12/18
 */
@Service
public class OrderService {
    private Map<OrderHandlerType, OrderHandler> orderHandleMap;

    /**
     * 选择OrderHandlerType作为map的key值
     * 参数v -> v表示选择将原来的对象作为map的value值
     * 参数(v1, v2) -> v1中，如果v1与v2的key值相同，选择v1作为那个key所对应的value值
     *
     * @param orderHandlers 订单处理程序
     */
    @Autowired
    public void setOrderHandleMap(List<OrderHandler> orderHandlers) {
        // 注入各种类型的订单处理类
        orderHandleMap = orderHandlers.stream()
                .peek(orderHandler -> System.out.println(AnnotationUtils.findAnnotation(orderHandler.getClass(), OrderHandlerType.class)))
                .peek(System.out::println).collect(
                        Collectors.toMap(orderHandler -> AnnotationUtils.findAnnotation(orderHandler.getClass(), OrderHandlerType.class),
                                v -> v, (v1, v2) -> v1));
    }

    public void orderService(Order order) {
        // ...一些前置处理
        // 通过订单来源确以及支付方式获取对应的handler
        OrderHandlerType orderHandlerType = new OrderHandlerTypeImpl(order.getSource(), order.getPayMethod());
        OrderHandler orderHandler = orderHandleMap.get(orderHandlerType);
        orderHandler.handle(order);
        // ...一些后置处理
    }
}