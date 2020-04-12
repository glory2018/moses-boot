/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.exam.antian.NarrowTireBreakVisualEffect
 * @version V1.0
 */
package com.ibm.mosesboot.exam.sky;

/**
 * @author Moses
 * @date 2020/4/8
 */
public class NarrowTireBreakVisualEffect implements BreakVisualEffects{
    @Override
    public void stop() {
        System.out.println("窄轮胎刹车特效展示");
    }
}