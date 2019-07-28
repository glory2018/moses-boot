package com.ibm.mosesboot.service;

import com.ibm.mosesboot.entity.Frequently;
import com.ibm.mosesboot.entity.Payment;
import com.ibm.mosesboot.entity.SalaryVo;

import java.util.List;

/**
 * @author Moses
 * @date 2019/7/28
 */
public interface IPaymentService {
    public  List<Frequently> getFrequentlyList();
    public  List<Integer> getYearList();
    public List<Payment> getIncrementList(SalaryVo vo);
    public List<Payment> getDeductionList(SalaryVo vo);
    public List<Payment> getPredictionList(SalaryVo vo);
    SalaryVo getSalaryVo();
}
