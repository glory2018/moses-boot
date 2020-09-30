/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.exam.TestOperation
 * @version V1.0
 */
package com.moses.framework.samples.exam;

/**
 * @author Moses
 * @date 2020/4/3
 */
public class TestOperation {
    static int add(int num1, int num2) {
        int sum, carry;
        do {
            //因为位运算加法，0+1=1,1+0=1，0+0=0,1+1=0(但是要进位)，所以跟异或有点类似
            //但是当num1&num2的时候，当为一的时候需要左移一位，表示进位。
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            //把sum给num1,进位给num2,当进位为0的时候，表示没有进位
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(add(3, 10));
    }
}