/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.exam.sky.Test4
 * @version V1.0
 */
package com.moses.framework.exam.antiy;

/**
 * @author Moses
 * @date 2020/4/8
 */
public class Test4 {
    /**
     * 每杯北冰洋汽水的售价为 5 元。顾客排队购买你的产品，（按账单 支付的顺序）， 每位顾客只能买一杯柠檬水，然后向你付 5 元、10 元或 20元。
     * 你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 元。
     * 注意，一开始你手头没有任何零钱。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     * 例如：输入：[5,5,5,10,20] 输出：false （当客户支付20元时，商店只有两张5元,无法找零）
     * 输入：[5,10,20] 输出：false (当客户支付20元时，商店只有10元，无法找零)
     */
    public static boolean charge(int[] bills) {
        boolean res = true;
        int money[] = {0, 0};
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:
                    money[0]++;
                    continue;
                case 10:
                    if (money[0] < 1) {
                        return false;
                    } else {
                        money[0]--;
                        money[1]++;
                    }
                    continue;
                case 20:
                    if (money[0] >= 1 && money[1] >= 1) {
                        money[0]--;
                        money[1]--;
                    } else if (money[0] >= 3) {
                        money[0] = money[0] - 3;
                    } else {
                        res = false;
                    }
                    continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] bill_1 = new int[]{5, 5, 20};
        int[] bill_2 = new int[]{5, 10, 5, 5, 5, 20, 5, 20};
        int[] bill_3 = new int[]{5, 10, 5, 10, 5, 20};
        int[] bill_4 = new int[]{5, 10, 5, 5, 5, 20, 10};
        System.out.println(charge(bill_1));
        System.out.println(charge(bill_2));
        System.out.println(charge(bill_3));
        System.out.println(charge(bill_4));
    }
}