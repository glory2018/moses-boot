package com.moses.framework.samples.payment.service;

import com.moses.framework.samples.payment.entity.SalaryPO;
import com.moses.framework.samples.payment.vo.SalaryVO;

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
