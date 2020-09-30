/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.exam.sky.Test1
 * @version V1.0
 */
package com.moses.framework.samples.exam.antiy;

/**
 * @author Moses
 * @date 2020/4/8
 */
public class Test2 {
    /**
     * 判断括号有效性 字符串仅为"("和")"的组合
     * 例如"()()()"为有效括号，返回true
     * "(()())"为有效括号，返回true
     * "(((()("为无效括号，返回false
     */
    public static boolean isVaild(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            Character temp = s.charAt(i);//先转换成字符
            //是否为左括号
            if ('(' == temp) {
                num++;
                //是否为右括号
            } else if (')' == temp) {
                if (num == 0) {
                    return false;
                } else {
                    num--;
                }
            }
        }
        return num == 0;
    }

    /**
     * 计算括号的层次数
     * 例如 "()"层参数为1,"(())"层次数为2,
     * "(()()())"层次数为2,
     * "((())())"层次数为3
     */
    public static int level(String s) {
        int cnt = 0, level = 0, i;
        for (i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                cnt++;
            else
                cnt--;
            level = Math.max(level, cnt);
        }
        return level;
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "(())";
        String s3 = "(()())";
        String s4 = "(()))";
        String s5 = "(()(())";
        String s6 = "((()(()))";
        String s7 = "(()())";
        String s8 = "((())())";
        System.out.println(isVaild(s1));
        System.out.println(isVaild(s2));
        System.out.println(isVaild(s3));
        System.out.println(isVaild(s4));
        System.out.println(isVaild(s5));
        System.out.println(isVaild(s6));
        System.out.println(level(s7));
        System.out.println(level(s8));
    }
}