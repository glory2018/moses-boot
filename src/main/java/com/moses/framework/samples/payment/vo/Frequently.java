package com.moses.framework.samples.payment.vo;

/**
 * @author Moses
 * @date 2019/8/3
 */
public enum Frequently {
    monthly("monthly", 1), quarterly("quarterly", 3), half("half", 6), annually("annually", 12);
    private String name;
    private int num;

    Frequently(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
