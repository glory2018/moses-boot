/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.service.impl.SalaryPOServiceImpl
 * @version V1.0
 */
package com.ibm.mosesboot.documents.service.impl;

import com.ibm.mosesboot.documents.entity.TemplateConfig;
import com.ibm.mosesboot.documents.mapper.TemplateConfigMapper;
import com.ibm.mosesboot.documents.service.TemplateConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Moses
 * @date 2019/7/28
 */
@Service("templateConfigService")
public class TemplateConfigServiceImpl implements TemplateConfigService {
    private static final Logger logger = LoggerFactory.getLogger(TemplateConfigServiceImpl.class);
    @Resource
    private TemplateConfigMapper templateConfigMapper;

    @Override
    public TemplateConfig selectByPrimaryKey(String templateId) {
        return templateConfigMapper.selectByPrimaryKey(templateId);
    }

    @Override
    public void save(TemplateConfig templateConfig) {
        templateConfigMapper.updateByPrimaryKeySelective(templateConfig);
    }
}

