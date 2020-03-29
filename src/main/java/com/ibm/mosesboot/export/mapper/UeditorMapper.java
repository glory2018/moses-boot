/*********************************************
 *
 * Copyright (C) 2018 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.ibm.mosesboot.export.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ibm.mosesboot.export.entity.Ueditor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author Moses *
 * @Date 2019/1/21 15:40
 */
public interface UeditorMapper extends BaseMapper<Ueditor> {
    @Override
    @Insert("INSERT INTO T_DOC_UEDITOR(id,templateId,title,note,content) VALUES(#{id},#{templateId},#{title},#{note},#{content})")
    int insert(Ueditor ueditor);

    @Select("select * from T_DOC_UEDITOR where id = #{id}")
    Ueditor findUeditorById(Integer id);
}
