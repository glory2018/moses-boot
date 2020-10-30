/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.assignment.SalaryPrediction
 * @version V1.0
 */
package com.moses.framework.assignment;

import com.google.common.collect.Lists;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.notNull;
import static org.apache.commons.lang3.math.NumberUtils.isNumber;

/**
 * @author Moses
 * @date 2019/8/3
 */
public class SalaryPrediction {
    public static void main(String[] args) {
        check(args);
        List<SalaryOutput> list = calc(args);
        print(list);
    }

    private static void print(List<SalaryOutput> list) {
        String format = "%5s | %20s | %20s | %20s | %20s";
        System.out.println("a. Increment Report");
        System.out.printf(format, "Year", "Starting Salary", "Number Of Increments", "Increment %", "Increment Amount");
        System.out.println();
        list.stream().forEach(output -> {
            System.out.printf(format, output.getYear(), output.getStartingSalary(), output.getNumberOfIncrements(), output.getIncrementPercentage(), output.getIncrementAmount());
            System.out.println();
        });
        System.out.println("b. Deduction Report");
        System.out.printf(format, "Year", "Starting Salary", "Number Of Deduction", "Deduction %", "Deduction Amount");
        System.out.println();
        list.stream().forEach(output -> {
            System.out.printf(format, output.getYear(), output.getStartingSalary(), output.getNumberOfDeductions(), output.getDeductionPercentage(), output.getDeductionAmount());
            System.out.println();
        });
    }

    private static List<SalaryOutput> calc(String[] args) {
        SalaryInput input = new SalaryInput(parseInt(args[0]), parseInt(args[1]), parseInt(args[2]), parseInt(args[3]), parseInt(args[4]), parseInt(args[5]));
        List<SalaryOutput> resultList = Lists.newArrayList();
        int startingSalary = input.getStartingSalary();
        for (int i = 0; i < input.getYear(); i++) {
            SalaryOutput output = new SalaryOutput();
            int totalIncrementAmount = 0;
            for (int j = 0; j < input.getIncrementFrequency(); j++) {
                totalIncrementAmount += startingSalary * (1 + input.getIncrementFrequency() / 100);
            }
            output.setYear(i + 1);
            output.setStartingSalary(startingSalary);
            output.setIncrementAmount(totalIncrementAmount);
            output.setNumberOfIncrements(input.getIncrementFrequency());
            output.setIncrementPercentage(input.getIncrementPercentage());
            int totalDeductionAmount = 0;
            for (int j = 0; j < input.getIncrementFrequency(); j++) {
                totalDeductionAmount += input.getDeductionAmount();
            }
            output.setYear(i + 1);
            output.setDeductionAmount(totalDeductionAmount);
            output.setDeductionPercentage((totalDeductionAmount / startingSalary) * 100);
            output.setNumberOfDeductions(input.getDeductionFrequency());
            resultList.add(output);
            startingSalary = startingSalary + totalIncrementAmount - totalDeductionAmount;
        }
        return resultList;
    }

    private static void check(String[] args) {
        notNull(args);
        isTrue(args.length == 6);
        isTrue(isNumber(args[0]), "The starting salary must be integer", 0);
        isTrue(isNumber(args[1]), "The increment must be integer", 0);
        isTrue(isNumber(args[2]), "The increment frequency must be integer", 0);  // 4 / 2 / 1
        isTrue(isNumber(args[3]), "The deduction must be integer", 0);
        isTrue(isNumber(args[4]), "The deduction frequency must be integer", 0);  // 4 / 2 / 1
        isTrue(isNumber(args[5]), "The prediction year must be integer", 0);
        isTrue(parseInt(args[0]) >= 1, "");
        isTrue(parseInt(args[1]) >= 0, "");
        isTrue(parseInt(args[3]) >= 0, "");
    }
}