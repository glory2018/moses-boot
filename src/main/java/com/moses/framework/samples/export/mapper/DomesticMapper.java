package com.moses.framework.samples.export.mapper;

import com.moses.framework.samples.export.entity.Domestic;

public interface DomesticMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Domestic record);

    int insertSelective(Domestic record);

    Domestic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Domestic record);

    int updateByPrimaryKey(Domestic record);
}