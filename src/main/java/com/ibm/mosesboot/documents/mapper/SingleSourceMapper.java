package com.ibm.mosesboot.documents.mapper;

import com.ibm.mosesboot.documents.entity.SingleSource;

import java.util.Map;

public interface SingleSourceMapper {
    int deleteByPrimaryKey(String richId);

    int insert(SingleSource record);

    int insertSelective(SingleSource record);

    SingleSource selectByPrimaryKey(String richId);

    int updateByPrimaryKeySelective(SingleSource record);

    int updateByPrimaryKeyWithBLOBs(SingleSource record);

    int updateByPrimaryKey(SingleSource record);

    Map getProjectInfo(String projectId);
}
