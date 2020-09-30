/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.exam.sky.Test3
 * @version V1.0
 */
package com.moses.framework.samples.exam.antiy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Moses
 * @date 2020/4/8
 */
public class Test3 {
    /**
     * 一个整形数组，包括仅一对重复数字
     * 输出重复数字的下标，时间复杂度不超过O(N)
     * 例如[1 3 9 2 3 7] 重复数字为3， 重复下标位置为4
     */
    public static int findDuplicate(String[] nums) {
        int index = 0;
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                index = i;
            } else {
                map.put(nums[i], nums[i]);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String[] array = new String[]{"1", "3", "9", "2", "3", "7"};
        System.out.println(findDuplicate(array));
    }
}