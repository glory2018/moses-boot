package com.moses.framework.util;

import java.math.BigDecimal;

/**
 * <b style='color:red'>字符串工具</b>
 * <ul>
 * <li>对象转字符串
 * <li>是否为空字符串
 * <li>"0"字符取代空字符串
 * <li>依次从三个字符串取>0的Double值
 * <li>依次从三个Double取>0的Double值
 * <li>去掉字符串中的单引号
 * <li>添加字符串中的单引号
 * <li>List拼装为(,,)字符串
 * <li>添加字符串中的单引号
 * <li>对象转化为数值，0取代空
 * <li>将一个字符串按照句点（.）分隔，返回最后一段
 * <li>格式化文件路径，将其中不规范的分隔转换为标准的分隔符,并且去掉末尾的"/"符号
 * <li>格式化文件路径，(适用于FTP远程文件路径或者Web资源的相对路径)。
 * <li>获取文件父路径
 * <li>获取相对路径
 * <li>获取当前系统换行符
 * <li>将用“|”分隔的字符串转换为字符串集合列表，剔除分隔后各个字符串前后的空格
 * <li>将用正则表达式regex分隔的字符串转换为字符串集合列表，剔除分隔后各个字符串前后的空格
 * <li>字符串集合列表转换为分隔的字符串
 * <li>将一个字符串的首字母改为大写或者小写
 * <li>将字符串的首字母转为小写
 * <li>将字符串的首字母转为大写
 * <li>去除字符串两边空格
 * <li>去除字符串左边空格
 * <li>去除字符串右边空格
 * <li>判断元素是否在数组内
 * <li>判断字符串是否为数字
 * </ul>
 * <p>
 * <p>
 * Sep 5, 2012
 *
 * @version 2.0
 * @since 1.0
 */
public class StringUtil {
    /**
     * 对象转字符串
     *
     * @param o 对象
     * @return 字符串
     * @since 1.0
     */
    public static String getStringFromObj(Object o) {
        if (o == null) {
            return "无";
        }
        return o.toString();
    }

    /**
     * 是否为空字符串
     *
     * @param s 判断字符串
     * @return 是否为空
     * @since 1.0
     */
    public static boolean isNull(String s) {
        if (s == null || s.trim().equals(""))
            return true;
        return false;
    }

    /**
     * 对象转化为数值，0取代空
     *
     * @param o 处理对象
     * @return 返回非空数值
     * @since 1.0
     */
    public static Number getNumberFromObject(Object o) {
        if (o == null) {
            return 0;
        }
        return (Number) o;
    }

    /**
     * 去除字符串两边空格
     *
     * @param str
     * @return 去除两边空格的字符串
     */
    public static String trim(String str) {
        if (isNull(str)) {
            return str;
        } else {
            return str.replaceAll("^[　 ]+|[　 ]+$", "");
        }
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        return str.matches("^([0-9]+)$");
    }

    public static int parseInt(Object param) {
        int value = 0;
        if (param instanceof Integer) {
            value = ((Integer) param).intValue();
        } else if (param instanceof String) {
            String str = (String) param;
            value = Integer.parseInt(str);
        } else if (param instanceof BigDecimal) {
            value = ((BigDecimal) param).intValue();
        }
        return value;
    }
}
