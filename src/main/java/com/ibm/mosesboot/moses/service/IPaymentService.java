package com.ibm.mosesboot.moses.service;

import com.ibm.mosesboot.moses.pojo.SalaryPO;
import com.ibm.mosesboot.moses.vo.SalaryVO;

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
