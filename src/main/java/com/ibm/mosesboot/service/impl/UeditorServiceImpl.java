/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.service.impl.SalaryPOServiceImpl
 * @version V1.0
 */
package com.ibm.mosesboot.service.impl;

import com.ibm.mosesboot.entity.Ueditor;
import com.ibm.mosesboot.mapper.UeditorMapper;
import com.ibm.mosesboot.service.IUeditorService;
import com.ibm.mosesboot.util.rich.richText2Docx.RichText2Docx;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author Moses
 * @date 2019/7/28
 */
@Service("ueditorService")
public class UeditorServiceImpl implements IUeditorService {
    @Resource
    private UeditorMapper ueditorMapper;

    @Override
    public void save(Ueditor ueditor) {
        ueditorMapper.insert(ueditor);
    }

    @Override
    public void export(Ueditor ueditor) {
        RichText2Docx text2Docx = new RichText2Docx();
        String data = ueditor.getContent();
        String path = "D:\\temp\\test.docx";
        try {
            text2Docx.resolveHtml(data, path);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

