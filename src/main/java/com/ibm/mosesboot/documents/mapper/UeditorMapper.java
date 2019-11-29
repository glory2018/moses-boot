/*********************************************
 *
 * Copyright (C) 2018 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.ibm.mosesboot.documents.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ibm.mosesboot.documents.entity.Ueditor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author Moses *
 * @Date 2019/1/21 15:40
 */
public interface UeditorMapper extends BaseMapper<Ueditor> {
    @Override
    @Insert("INSERT INTO Ueditor(id,name,content) VALUES(#{content},#{content},#{content})")
    int insert(Ueditor ueditor);

    @Select("select * from Ueditor where id = #{id}")
    Ueditor findUeditorById(Integer id);
}
