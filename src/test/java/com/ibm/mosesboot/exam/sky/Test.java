/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.exam.antian.Test
 * @version V1.0
 */
package com.ibm.mosesboot.exam.sky;

/**
 * @author Moses
 * @date 2020/4/8
 */
public class Test {
    public static void main(String[] args) {
        BreakVisualEffects BreakVisualEffects = new NarrowTireBreakVisualEffect();
        Car gtCar = new Car(BreakVisualEffects);
        gtCar.stop();
        BreakVisualEffects = new WideTireBreakVisualEffect();
        Car SUVCar = new Car(BreakVisualEffects);
        SUVCar.stop();
    }
}
