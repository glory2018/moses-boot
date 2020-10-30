/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.exam.TryCatchTest
 * @version V1.0
 */
package com.moses.framework.exam.finall;

/**
 * @author Moses
 * @date 2020/4/3
 */
// 当try、catch中有return时，finally中的代码会执行么？
public class TryCatchTest {
    public static void main(String[] args) {
        System.out.println("return的返回值：" + test());
//		System.out.println("包含异常return的返回值：" + testWithException());
//        System.out.println("return的返回值：" + testWithObject().age); // 测试返回值类型是对象时
    }

    // finally是在return后面的表达式运算之后执行的，此时并没有返回运算之后的值
    //，而是把值保存起来，不管finally对该值做任何的改变，返回的值都不会改变，依然返回保存起来的值。
    //也就是说方法的返回值是在finally运算之前就确定了的。
    static int test() {
        int x = 1;
        try {
            return x++;
        } catch (Exception e) {
        } finally {
            System.out.println("finally:" + x);
            ++x;
            System.out.println("++x:" + x);
            // finally代码中最好不要包含return，程序会提前退出，
            // 也就是说返回的值不是try或catch中的值
            return x;
        }
    }

    static int testWithException() {
        Integer x = null;
        try {
            x.intValue(); // 造个空指针异常
            return x++;
        } catch (Exception e) {
            System.out.println("catch:" + x);
            x = 1;
            return x; // 返回1
//			return ++x; // 返回2
        } finally {
            x = 1;
            System.out.println("finally:" + x);
            ++x;
            System.out.println("++x:" + x);
            // finally代码中最好不要包含return，程序会提前退出，
            // 也就是说返回的值不是try或catch中的值
//			 return x;
        }
    }

    static Num testWithObject() {
        Num num = new Num();
        try {
            return num;
        } catch (Exception e) {
        } finally {
            num.age++; // 改变了引用对象的值
            System.out.println("finally:" + num.age);
        }
        return num;
    }

    static class Num {
        public int age;
    }
}