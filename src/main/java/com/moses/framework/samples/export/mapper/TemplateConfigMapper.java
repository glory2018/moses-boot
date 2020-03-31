package com.moses.framework.samples.export.mapper;

import com.moses.framework.samples.export.entity.TemplateConfig;
import org.apache.ibatis.annotations.Select;

public interface TemplateConfigMapper {
    @Select("select * from T_DOC_TEMPLATE_CONFIG where TEMPLATE_ID = #{templateId}")
    TemplateConfig selectByPrimaryKey(Integer templateId);
}