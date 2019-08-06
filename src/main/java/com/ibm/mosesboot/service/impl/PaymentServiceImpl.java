/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.service.impl.SalaryPOServiceImpl
 * @version V1.0
 */
package com.ibm.mosesboot.service.impl;

import com.ibm.mosesboot.po.SalaryPO;
import com.ibm.mosesboot.service.IPaymentService;
import com.ibm.mosesboot.vo.SalaryVO;
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
    public List<SalaryPO> getIncrementList(SalaryVO vo) {
        List<SalaryPO> paymentList = new ArrayList<SalaryPO>();
        Double curSalary = vo.getSalary();
        Double incrementRate = vo.getIncrement() * (12 / vo.getIncrementFrequently());
        for (int i = 1; i <= vo.getPrediction(); i++) {
            SalaryPO payment = new SalaryPO();
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
    public List<SalaryPO> getDeductionList(SalaryVO vo) {
        List<SalaryPO> paymentList = new ArrayList<SalaryPO>();
        Double curSalary = vo.getSalary();
        Double deductionRate = vo.getDeduction() * (12 / vo.getDeductionFrequently());
        for (int i = 1; i <= vo.getPrediction(); i++) {
            SalaryPO payment = new SalaryPO();
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
    public List<SalaryPO> getPredictionList(SalaryVO vo) {
        List<SalaryPO> paymentList = new ArrayList<SalaryPO>();
        Double curSalary = vo.getSalary();
        Double incrementRate = vo.getIncrement() * (12 / vo.getIncrementFrequently());
        Double deductionRate = vo.getDeduction() * (12 / vo.getDeductionFrequently());
        for (int i = 1; i <= vo.getPrediction(); i++) {
            SalaryPO payment = new SalaryPO();
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
    public SalaryVO getSalaryVo() {
        SalaryVO vo = new SalaryVO();
        vo.setSalary(1000.00);
        vo.setIncrement(0.3);
        vo.setIncrementFrequently(12);
        vo.setDeduction(0.2);
        vo.setDeductionFrequently(12);
        vo.setPrediction(3);
        return vo;
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

