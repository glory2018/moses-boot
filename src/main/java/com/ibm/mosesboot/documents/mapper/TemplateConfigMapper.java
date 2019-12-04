package com.ibm.mosesboot.documents.mapper;

import com.ibm.mosesboot.documents.entity.TemplateConfig;

public interface TemplateConfigMapper {
    int deleteByPrimaryKey(String templateId);

    int insert(TemplateConfig record);

    int insertSelective(TemplateConfig record);

    TemplateConfig selectByPrimaryKey(String templateId);

    int updateByPrimaryKeySelective(TemplateConfig record);

    int updateByPrimaryKey(TemplateConfig record);
}