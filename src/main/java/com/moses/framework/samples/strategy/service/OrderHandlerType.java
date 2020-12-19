/*
 * Copyright © 2020 287664409@qq.com Inc. All rights reserved
 * @description: com.moses.framework.samples.strategy.OrderHandlerType
 * @version V1.0
 */
package com.moses.framework.samples.strategy.service;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author Moses
 * @date 2020/12/18
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface OrderHandlerType {
    String source();

    String payMethod();
}
