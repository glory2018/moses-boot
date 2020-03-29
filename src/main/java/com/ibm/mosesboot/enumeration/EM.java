/************************** 
 * 类名：EM.java 
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
public class EM {
    /**
     * 状态枚举 <模块_状态值>;
     */
    public static enum Status {
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
    }

    public static void main(String[] args) {
        System.out.println(EM.Status.GREEN.value);
        for (Status c : Status.values()) { // 枚举.values()表示得到 全部枚举的内容
            System.out.println(c.ordinal() + " --> " + c.name() + "(" + c.getValue() + ")");
        }
    }
}
