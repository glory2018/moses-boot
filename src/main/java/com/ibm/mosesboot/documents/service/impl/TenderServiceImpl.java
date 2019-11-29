/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.service.impl.SalaryPOServiceImpl
 * @version V1.0
 */
package com.ibm.mosesboot.documents.service.impl;

import com.ibm.mosesboot.documents.entity.PlanTender;
import com.ibm.mosesboot.documents.mapper.PlanTenderMapper;
import com.ibm.mosesboot.documents.service.TenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Moses
 * @date 2019/7/28
 */
@Service("tenderService")
public class TenderServiceImpl implements TenderService {
    private static final Logger logger = LoggerFactory.getLogger(TenderServiceImpl.class);
    @Resource
    private PlanTenderMapper planTenderMapper;

    @Override
    public PlanTender selectByPrimaryKey(Integer id) {
        return planTenderMapper.selectByPrimaryKey(id);
    }
}

