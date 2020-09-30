package com.moses.framework.samples.export.mapper;

import com.moses.framework.samples.export.entity.Abroad;

public interface AbroadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Abroad record);

    int insertSelective(Abroad record);

    Abroad selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Abroad record);

    int updateByPrimaryKey(Abroad record);
}