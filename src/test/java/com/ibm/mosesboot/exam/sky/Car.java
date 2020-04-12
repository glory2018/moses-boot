/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.exam.antian.Car
 * @version V1.0
 */
package com.ibm.mosesboot.exam.sky;

/**
 * @author Moses
 * @date 2020/4/8
 */
public class Car {
    BreakVisualEffects breakVisualEffects;

    public Car() {
        super();
    }

    public Car(BreakVisualEffects breakVisualEffects) {
        super();
        this.breakVisualEffects = breakVisualEffects;
    }

    public void stop() {
        breakVisualEffects.stop();
    }
}