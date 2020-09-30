package com.moses.framework.samples.export.mapper;

import com.moses.framework.samples.export.entity.AbroadDetail;

import java.util.List;

public interface AbroadDetailMapper {
    int insert(AbroadDetail record);

    int insertSelective(AbroadDetail record);

    List<AbroadDetail> selectList(Integer id);
}