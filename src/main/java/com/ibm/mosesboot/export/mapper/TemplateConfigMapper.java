package com.ibm.mosesboot.export.mapper;

import com.ibm.mosesboot.export.entity.TemplateConfig;
import org.apache.ibatis.annotations.Select;

public interface TemplateConfigMapper {
    @Select("select * from T_DOC_TEMPLATE_CONFIG where TEMPLATE_ID = #{templateId}")
    TemplateConfig selectByPrimaryKey(Integer templateId);
}