/*
 * Copyright © 2020 287664409@qq.com Inc. All rights reserved
 * @description: com.moses.framework.samples.strategy.OrderHandlerTypeImpl
 * @version V1.0
 */
package com.moses.framework.samples.strategy.service.impl;

import com.moses.framework.samples.strategy.service.OrderHandlerType;

import java.lang.annotation.Annotation;

/**
 * @author Moses
 * @date 2020/12/18
 */
public class OrderHandlerTypeImpl implements OrderHandlerType {
    private String source;
    private String payMethod;

    public OrderHandlerTypeImpl(String source, String payMethod) {
        this.source = source;
        this.payMethod = payMethod;
    }

    @Override
    public String source() {
        return source;
    }

    @Override
    public String payMethod() {
        return payMethod;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return OrderHandlerType.class;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        OrderHandlerTypeImpl that = (OrderHandlerTypeImpl) o;
//        return Objects.equals(source, that.source) &&
//                Objects.equals(payMethod, that.payMethod);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(source, payMethod);
//    }
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += (127 * "source".hashCode()) ^ source.hashCode();
        hashCode += (127 * "payMethod".hashCode()) ^ payMethod.hashCode();
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OrderHandlerType)) {
            return false;
        }
        OrderHandlerType other = (OrderHandlerType) obj;
        return source.equals(other.source()) && payMethod.equals(other.payMethod());
    }
}