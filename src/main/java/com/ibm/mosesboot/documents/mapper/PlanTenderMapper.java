package com.ibm.mosesboot.documents.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ibm.mosesboot.documents.entity.PlanTender;

public interface PlanTenderMapper extends BaseMapper<PlanTender> {
    int deleteByPrimaryKey(Integer id);

    @Override
    int insert(PlanTender record);

    int insertSelective(PlanTender record);

    PlanTender selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlanTender record);

    int updateByPrimaryKeyWithBLOBs(PlanTender record);

    int updateByPrimaryKey(PlanTender record);
}
