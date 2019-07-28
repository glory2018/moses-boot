/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.service.impl.PaymentServiceImpl
 * @version V1.0
 */
package com.ibm.mosesboot.service.impl;

import com.ibm.mosesboot.entity.Frequently;
import com.ibm.mosesboot.entity.Payment;
import com.ibm.mosesboot.entity.SalaryVo;
import com.ibm.mosesboot.service.IPaymentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Moses
 * @date 2019/7/28
 */
@Service("paymentService")
public class PaymentServiceImpl implements IPaymentService {
    @Override
    public List<Payment> getIncrementList(SalaryVo vo) {
        List<Payment> paymentList = new ArrayList<Payment>();
        Double curSalary = vo.getSalary();
        Double incrementRate = vo.getIncrement() * (12 / vo.getIncrementFrequently());
        for (int i = 1; i <= vo.getPrediction(); i++) {
            Payment payment = new Payment();
            payment.setYear(i);
            payment.setSalary(curSalary);
            payment.setNumber(curSalary * incrementRate);
            payment.setPercentage(incrementRate * 100);
            curSalary = curSalary * (1 + incrementRate);
            payment.setAmount(curSalary);
            paymentList.add(payment);
        }
        return paymentList;
    }

    @Override
    public List<Payment> getDeductionList(SalaryVo vo) {
        List<Payment> paymentList = new ArrayList<Payment>();
        Double curSalary = vo.getSalary();
        Double deductionRate = vo.getDeduction() * (12 / vo.getDeductionFrequently());
        for (int i = 1; i <= vo.getPrediction(); i++) {
            Payment payment = new Payment();
            payment.setYear(i);
            payment.setSalary(curSalary);
            payment.setNumber(curSalary * deductionRate);
            payment.setPercentage(deductionRate * 100);
            curSalary = curSalary * (1 - deductionRate);
            payment.setAmount(curSalary);
            paymentList.add(payment);
        }
        return paymentList;
    }

    @Override
    public List<Payment> getPredictionList(SalaryVo vo) {
        List<Payment> paymentList = new ArrayList<Payment>();
        Double curSalary = vo.getSalary();
        Double incrementRate = vo.getIncrement() * (12 / vo.getIncrementFrequently());
        Double deductionRate = vo.getDeduction() * (12 / vo.getDeductionFrequently());
        for (int i = 1; i <= vo.getPrediction(); i++) {
            Payment payment = new Payment();
            payment.setYear(i);
            payment.setSalary(curSalary);
            payment.setIncrementAmount(curSalary * incrementRate);
            payment.setDeductionAmount(curSalary * deductionRate);
            curSalary = curSalary * (1 + incrementRate - deductionRate);
            payment.setAmount(curSalary);
            paymentList.add(payment);
        }
        return paymentList;
    }

    @Override
    public SalaryVo getSalaryVo() {
        SalaryVo vo = new SalaryVo();
        vo.setSalary(1000.00);
        vo.setIncrement(0.3);
        vo.setIncrementFrequently(12);
        vo.setDeduction(0.2);
        vo.setDeductionFrequently(12);
        vo.setPrediction(3);
        return vo;
    }

    @Override
    public List<Frequently> getFrequentlyList() {
        List<Frequently> frequentlyList = new ArrayList<Frequently>();
        String[] names = {"monthly", "quarterly", "half-yearly", "annually"};
        Integer[] nums = {1, 3, 6, 12};
        for (int i = 0; i < 4; i++) {
            Frequently frequently = new Frequently();
            frequently.setName(names[i]);
            frequently.setNum(nums[i]);
            frequentlyList.add(frequently);
        }
        return frequentlyList;
    }

    @Override
    public List<Integer> getYearList() {
        List<Integer> predictionList = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            predictionList.add(i + 1);
        }
        return predictionList;
    }
}

