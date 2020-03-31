/**
 * <p>
 * <br>项目:CodeStyle
 * <br>文件名:TestByte.java
 * <br>包名:com.steve.util
 * <br>创建日期:2015年11月12日下午6:04:47
 * <br>网址：http://www.founderinternational.com/
 * <br>方正国际软件有限公司 Founder International Co.,Ltd. All rights reserved
 * <br>版权所有
 * </p>
 */
package com.moses.framework.util;

/**
 * <p>
 * <br>
 * 标题： <br>
 * 描述： <br>
 * 作者： 范少荣 <br>
 * 修改日期：2015年11月12日下午6:04:47 <br>
 * 修改历史： <br>
 * 版本：1.0
 * </p>
 */
public class TestByte {
    public static void main(String[] args) {
        System.out.println("Integer:" + Integer.SIZE / 8); // 4
        System.out.println("Short:" + Short.SIZE / 8); // 2
        System.out.println("Long:" + Long.SIZE / 8); // 8
        System.out.println("Byte:" + Byte.SIZE / 8); // 1
        System.out.println("Character:" + Character.SIZE / 8); // 2
        System.out.println("Float:" + Float.SIZE / 8); // 4
        System.out.println("Double:" + Double.SIZE / 8); // 8
        System.out.println("Boolean:" + Boolean.toString(false));
        System.out.println();
    }
}
