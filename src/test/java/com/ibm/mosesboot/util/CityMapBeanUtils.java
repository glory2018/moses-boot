package com.moses.framework.samples.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * BeanUtils工具类,扩展BeanUtils功能并增加其他对Bean的处理的工具类
 *
 * @author caixiangning@fang.com
 * <p>
 * 2017-12-13
 */
public class CityMapBeanUtils extends BeanUtils {
    /**
     * 对象拷贝
     *
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }

    /**
     * 集合拷贝
     *
     * @param sourceList
     * @param targetList
     * @param clazz
     * @return
     */
    public static <T, E> List<E> copyProperties(List<T> sourceList, List<E> targetList,
                                                Class<E> clazz) {
        for (T t : sourceList) {
            E element = null;
            try {
                element = clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(t, element);
            targetList.add(element);
        }
        return targetList;
    }

    /**
     * 判断某个对象的各个属性是否为空,如果为空则返回null否则返回原对象
     *
     * @param obj
     * @return
     */
    public static <T> T BeanValidate(T obj) {
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if ("serialVersionUID".equals(f.getName())) {
                    continue;
                }
                if (f.get(obj) != null) {
                    return obj;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
