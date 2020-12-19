/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.exam.sky.Test1
 * @version V1.0
 */
package com.moses.framework.exam.antiy;

/**
 * @author Moses
 * @date 2020/4/8
 */
public class Test1 {
    /**
     * * 程序填空，输入为两两不等的三个整数，输入为从小到大正序排列 例如showme(7,9,4),输出为4 7 9 不改变以下代码结构，把程序补充完整
     */
    public static void shwome(int a, int b, int c) {
        int t = 0;
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }
        System.out.println(a + "--" + b + "--" + c);
    }

    // test
    public static void main(String[] args) {
        shwome(1, 3, 5);
        shwome(5, 3, 1);
        shwome(1, 5, 3);
    }
}