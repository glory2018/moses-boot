/************************** 
 * 类名：InvokeClone.java 
 * 作者：范少荣  2012-12-14
 **************************/
package com.moses.framework.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * <b style='color:red'>Description</b>
 *
 * @author 范少荣 2012-12-14
 * @version 2.0
 * @since 1.0
 */
public class InvokeClone {
    public static void main(String[] args) throws Exception {
        // 反射类的Class对象
        Class t = Class.forName("org.framework.poi.Role");
        // 生成反射类的实例
        Object xxbb = t.newInstance();
        // 反射类的某方法的参数列表Class[]对象
        Class[] pramClass = {Class.forName("java.lang.String")};
        // 获得反射类setUSER_ID方法的定义
        Method m1 = t.getMethod("setName", pramClass);
        // 执行方法,方法返回的是Object对象，你可以自已强制转换成相应的类型
        System.out.println((String) m1.invoke(xxbb, "xxx"));
        // 获得反射类getUSER_ID方法的定义,注意由于getUSER_ID方法,没有参数因此可以用null做为参数
        Method m = t.getMethod("getName", null);
        // 执行方法
        System.out.println(m.invoke(xxbb, null));
        Object obxx = manufacture("org.framework.poi.Role", "name", "234");
        System.out.println(obxx);
    }

    public static Object manufacture(String className, String att, Object value)
            throws Exception {
        Class t = Class.forName(className);
        // 生成反射类的实例
        Object obj = t.newInstance();
        // 反射类的某方法的参数列表Class[]对象
        Class pramClass = Class.forName("java.lang.String");
        setter(obj, att, value, pramClass);
        return obj;
    }

    public static Object manufacture(String className, String[] att,
                                     Object[] args) throws Exception {
        Class t = Class.forName(className);
        // 生成反射类的实例
        Object obj = t.newInstance();
        Class[] argsClass = new Class[args.length];
        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
            setter(obj, att[i], args[i], argsClass[i]);
        }
        return obj;
    }

    public static void setter(Object obj, String att, Object value,
                              Class<?> type) {
        try {
            Method met = obj.getClass().getMethod("set" + initStr(att), type);
            met.invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getter(Object obj, String att) {
        try {
            Method met = obj.getClass().getMethod("get" + initStr(att));
            return met.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String initStr(String old) { // 将单词的首字母大写
        String str = old.substring(0, 1).toUpperCase() + old.substring(1);
        return str;
    }

    public static void encapsulateObject(Object o1, Object o2) {
        Field[] fields = o2.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                String propertyName = fields[i].getName();
                // 得到参数类型
                Class<?> paramType = fields[i].getType();
                setter(o2, propertyName, getter(o1, propertyName), paramType);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
    }

    public static void encapsulateObject(Object o1, Object o2, String[] property) {
        Field[] fields = o2.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                for (int j = 0; j < property.length; j++) {
                    String propertyName = fields[i].getName();
                    int result = property[j].indexOf(propertyName);
                    if (result != -1) {
                        // 得到参数类型
                        Class<?> paramType = fields[i].getType();
                        setter(o2, propertyName, getter(o1, propertyName),
                                paramType);
                    }
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
    }
}
