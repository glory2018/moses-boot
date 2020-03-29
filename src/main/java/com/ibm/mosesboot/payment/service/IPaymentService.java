package com.ibm.mosesboot.payment.service;

import com.ibm.mosesboot.payment.entity.SalaryPO;
import com.ibm.mosesboot.payment.vo.SalaryVO;

import java.util.List;

/**
 * @author Moses
 * @date 2019/7/28
 */
public interface IPaymentService {
    public List<Integer> getYearList();

    public List<SalaryPO> getIncrementList(SalaryVO vo);

    public List<SalaryPO> getDeductionList(SalaryVO vo);

    public List<SalaryPO> getPredictionList(SalaryVO vo);

    SalaryVO getSalaryVo();
}
