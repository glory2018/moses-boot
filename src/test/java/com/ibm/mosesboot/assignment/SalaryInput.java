/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.assignment.SalaryInput
 * @version V1.0
 */
package com.moses.framework.samples.assignment;

/**
 * @author Moses
 * @date 2019/8/3
 */
public class SalaryInput {
    private int startingSalary;
    private int incrementPercentage;
    private int incrementFrequency;
    private int deductionAmount;
    private int deductionFrequency;
    private int year;

    public SalaryInput(int startingSalary, int incrementPercentage, int incrementFrequency, int deductionAmount, int deductionFrequency, int year) {
        this.startingSalary = startingSalary;
        this.incrementPercentage = incrementPercentage;
        this.incrementFrequency = incrementFrequency;
        this.deductionAmount = deductionAmount;
        this.deductionFrequency = deductionFrequency;
        this.year = year;
    }

    public int getStartingSalary() {
        return startingSalary;
    }

    public void setStartingSalary(int startingSalary) {
        this.startingSalary = startingSalary;
    }

    public int getIncrementPercentage() {
        return incrementPercentage;
    }

    public void setIncrementPercentage(int incrementPercentage) {
        this.incrementPercentage = incrementPercentage;
    }

    public int getIncrementFrequency() {
        return incrementFrequency;
    }

    public void setIncrementFrequency(int incrementFrequency) {
        this.incrementFrequency = incrementFrequency;
    }

    public int getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(int deductionAmount) {
        this.deductionAmount = deductionAmount;
    }

    public int getDeductionFrequency() {
        return deductionFrequency;
    }

    public void setDeductionFrequency(int deductionFrequency) {
        this.deductionFrequency = deductionFrequency;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
