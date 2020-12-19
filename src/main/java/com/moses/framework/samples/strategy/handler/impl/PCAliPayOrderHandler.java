/*
 * Copyright © 2020 287664409@qq.com Inc. All rights reserved
 * @description: com.moses.framework.samples.strategy.PCOrderHandler
 * @version V1.0
 */
package com.moses.framework.samples.strategy.handler.impl;

import com.moses.framework.samples.strategy.entity.Order;
import com.moses.framework.samples.strategy.handler.OrderHandler;
import com.moses.framework.samples.strategy.service.OrderHandlerType;

/**
 * @author Moses
 * @date 2020/12/18
 */
@OrderHandlerType(source = "pc", payMethod = "aliPay")
public class PCAliPayOrderHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("支付宝处理PC端订单");
    }
}