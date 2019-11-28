/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.service.impl.SalaryPOServiceImpl
 * @version V1.0
 */
package com.ibm.mosesboot.service.impl;

import com.ibm.mosesboot.bean.RichObject;
import com.ibm.mosesboot.entity.Ueditor;
import com.ibm.mosesboot.export.RichHtmlHandler;
import com.ibm.mosesboot.mapper.UeditorMapper;
import com.ibm.mosesboot.service.IUeditorService;
import com.ibm.mosesboot.util.WordGeneratorWithFreemarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Moses
 * @date 2019/7/28
 */
@Service("ueditorService")
public class UeditorServiceImpl implements IUeditorService {
    private static final Logger logger = LoggerFactory.getLogger(UeditorServiceImpl.class);
    @Resource
    private UeditorMapper ueditorMapper;

    @Override
    public void save(Ueditor ueditor) {
        ueditorMapper.insert(ueditor);
    }

    @Override
    public void export(Ueditor ueditor) throws Exception {
        Ueditor u = ueditorMapper.findUeditorById(ueditor.getId());
        //用map存放数据
        HashMap<String, Object> data = new HashMap<String, Object>();
        RichObject richObject = new RichObject();
        richObject.setHtml(u.getContent());
        //--------------------此处可以spring配置文件配置，也可以直接读取属性文件获取------------------
        //从mht文件中找
        richObject.setDocSrcLocationPrex("file:///C:/213792E5");
        richObject.setDocSrcParent("template.files");
        richObject.setNextPartId("01D5A60A.35177070");
        richObject.setShapeidPrex("_x56fe__x7247__x0020");
        richObject.setTypeid("#_x0000_t75");
        richObject.setSpidPrex("_x0000_i");
        richObject.setWebAppliction(false);
        //-----------------------------------------
        RichHtmlHandler richHtmlHandler = WordGeneratorWithFreemarker.createRichHtmlHandler(richObject);
        List<RichHtmlHandler> richHtmlHandlerList = new ArrayList<RichHtmlHandler>();
        richHtmlHandlerList.add(richHtmlHandler);
        data.put("name", "wesley");
        data.put("datetime", "2017-05-10");
        data.put("title", "演示demo");
        data.put("context", richHtmlHandler.getHandledDocBodyBlock());
        String docFilePath = "招标方案.doc";
        String templatePath = Class.class.getResource("/ftl").getPath();
        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8");
        logger.debug("------templatePath-------" + templatePath);
        WordGeneratorWithFreemarker.createDoc(templatePath, "template.ftl", data, docFilePath);
    }
}

