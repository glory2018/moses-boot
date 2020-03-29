/************************** 
 * 类名：Color.java 
 * 作者：范少荣  Jan 23, 2013
 **************************/
package com.ibm.mosesboot.enumeration;

/**
 * <b style='color:red'>Description</b>
 *
 * @author 范少荣 Jan 23, 2013
 * @version 2.0
 * @since 1.0
 */
public class Color {
    public static final Color RED = new Color("红色");// 定义第一个对象
    public static final Color GREEN = new Color("绿色");// 定义第二个对象
    public static final Color BLUE = new Color("蓝色");// 定义第三个对象
    public static final int CONTENT1 = 1; // 表示红色
    public static final int CONTENT2 = 2; // 表示绿色
    private String name;

    private Color(String name) { // 构造方法私有化，同时设置颜色的名称
        this.setName(name); // 为颜色的名字赋值
    }

    public String getName() { // 取得颜色名称
        return this.name;
    }

    public void setName(String name) { // 设置颜色名称
        this.name = name;
    }

    public static Color getInstance(int i) { // 得到 一个颜色，只能从固定的几个颜色中取得
        switch (i) {
            case 1: { // 返回红色对象
                return RED;
            }
            case 2: { // 返回绿色对象
                return GREEN;
            }
            case 3: { // 返回蓝色对象
                return BLUE;
            }
            default: { // 错误的值
                return null;
            }
        }
    }

    /**
     * Description
     *
     * @param value Description
     * @return value Description
     * @since 1.0
     */
    public static void main(String[] args) {
        Color c1 = Color.RED; // 取得红色
        System.out.println(c1.getName());// 输出名字
        Color c2 = Color.getInstance(3);// 根据编号取得名字
        System.out.println(c2.getName());// 输出名字
        System.out.println(Color.CONTENT1 + Color.CONTENT2); // 颜色相加
    }
}
