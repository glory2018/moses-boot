/*********************************************
 *
 * Copyright (C) 2018 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.ibm.mosesboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ibm.mosesboot.entity.Ueditor;
import org.apache.ibatis.annotations.Insert;

/**
 * @author Moses *
 * @Date 2019/1/21 15:40
 */
public interface UeditorMapper extends BaseMapper<Ueditor> {
    @Insert("INSERT INTO Ueditor(content) VALUES(#{content})")
    int insert(Ueditor ueditor);
}
