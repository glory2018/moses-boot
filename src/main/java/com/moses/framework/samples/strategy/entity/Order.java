/*
 * Copyright © 2020 287664409@qq.com Inc. All rights reserved
 * @description: com.moses.framework.samples.strategy.Order
 * @version V1.0
 */
package com.moses.framework.samples.strategy.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Moses
 * @date 2020/12/18
 */
@Data
public class Order {
    /**
     * 订单来源
     */
    private String source;
    /**
     * 支付方式
     */
    private String payMethod;
    /**
     * 订单编号
     */
    private String code;
    /**
     * 订单金额
     */
    private BigDecimal amount;
    // ...其他的一些字段
}
