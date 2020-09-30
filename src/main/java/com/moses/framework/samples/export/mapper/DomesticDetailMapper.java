package com.moses.framework.samples.export.mapper;

import com.moses.framework.samples.export.entity.DomesticDetail;

import java.util.List;

public interface DomesticDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DomesticDetail record);

    int insertSelective(DomesticDetail record);

    DomesticDetail selectByPrimaryKey(Integer id);

    List<DomesticDetail> selectList(Integer id);

    int updateByPrimaryKeySelective(DomesticDetail record);

    int updateByPrimaryKey(DomesticDetail record);
}