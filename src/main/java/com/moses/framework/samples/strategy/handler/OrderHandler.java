/*
 * Copyright © 2020 287664409@qq.com Inc. All rights reserved
 * @description: com.moses.framework.samples.strategy.OrderHandler
 * @version V1.0
 */
package com.moses.framework.samples.strategy.handler;

import com.moses.framework.samples.strategy.entity.Order;

/**
 * @author Moses
 * @date 2020/12/18
 */
public interface OrderHandler {
    void handle(Order order);
}