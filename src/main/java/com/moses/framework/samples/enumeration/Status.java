/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.enumeration.Status
 * @version V1.0
 */
package com.moses.framework.samples.enumeration;

/**
 * @author Moses
 * @date 2020/4/4
 */
public enum Status {
    RED("红色"), GREEN("绿色"), BLUE("蓝色");
    public String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
    }

    public static void main(String[] args) {
        System.out.println(GREEN.value);
        // 枚举.values()表示得到 全部枚举的内容
        for (Status c : Status.values()) {
            System.out.println(c.ordinal() + " --> " + c.name() + "(" + c.getValue() + ")");
        }
    }
}