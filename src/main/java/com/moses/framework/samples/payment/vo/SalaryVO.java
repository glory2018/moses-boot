/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.entity.Payment
 * @version V1.0
 */
package com.moses.framework.samples.payment.vo;

/**
 * @author Moses
 * @date 2019/7/28
 */
public class SalaryVO {
    private Double salary;
    private Integer incrementFrequently;
    private Double increment;
    private Integer deductionFrequently;
    private Double deduction;
    private Integer prediction;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getIncrementFrequently() {
        return incrementFrequently;
    }

    public void setIncrementFrequently(Integer incrementFrequently) {
        this.incrementFrequently = incrementFrequently;
    }

    public Double getIncrement() {
        return increment;
    }

    public void setIncrement(Double increment) {
        this.increment = increment;
    }

    public Integer getDeductionFrequently() {
        return deductionFrequently;
    }

    public void setDeductionFrequently(Integer deductionFrequently) {
        this.deductionFrequently = deductionFrequently;
    }

    public Double getDeduction() {
        return deduction;
    }

    public void setDeduction(Double deduction) {
        this.deduction = deduction;
    }

    public Integer getPrediction() {
        return prediction;
    }

    public void setPrediction(Integer prediction) {
        this.prediction = prediction;
    }
}
