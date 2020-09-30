/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.assignment.SalaryOutput
 * @version V1.0
 */
package com.moses.framework.samples.assignment;

/**
 * @author Moses
 * @date 2019/8/3
 */
public class SalaryOutput {
    private int year;
    private int startingSalary;
    private int numberOfIncrements;
    private int incrementPercentage;
    private int incrementAmount;
    private int numberOfDeductions;
    private int deductionPercentage;
    private int deductionAmount;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStartingSalary() {
        return startingSalary;
    }

    public void setStartingSalary(int startingSalary) {
        this.startingSalary = startingSalary;
    }

    public int getNumberOfIncrements() {
        return numberOfIncrements;
    }

    public void setNumberOfIncrements(int numberOfIncrements) {
        this.numberOfIncrements = numberOfIncrements;
    }

    public int getIncrementPercentage() {
        return incrementPercentage;
    }

    public void setIncrementPercentage(int incrementPercentage) {
        this.incrementPercentage = incrementPercentage;
    }

    public int getIncrementAmount() {
        return incrementAmount;
    }

    public void setIncrementAmount(int incrementAmount) {
        this.incrementAmount = incrementAmount;
    }

    public int getNumberOfDeductions() {
        return numberOfDeductions;
    }

    public void setNumberOfDeductions(int numberOfDeductions) {
        this.numberOfDeductions = numberOfDeductions;
    }

    public int getDeductionPercentage() {
        return deductionPercentage;
    }

    public void setDeductionPercentage(int deductionPercentage) {
        this.deductionPercentage = deductionPercentage;
    }

    public int getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(int deductionAmount) {
        this.deductionAmount = deductionAmount;
    }
}