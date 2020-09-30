/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.service.impl.SalaryPOServiceImpl
 * @version V1.0
 */
package com.moses.framework.samples.export.service.impl;

import com.moses.framework.freemarker.RichHtmlHandler;
import com.moses.framework.freemarker.WordGeneratorWithFreemarker;
import com.moses.framework.freemarker.bean.RichObject;
import com.moses.framework.samples.export.entity.TemplateConfig;
import com.moses.framework.samples.export.entity.Ueditor;
import com.moses.framework.samples.export.mapper.UeditorMapper;
import com.moses.framework.samples.export.service.IUeditorService;
import com.moses.framework.samples.export.service.TemplateConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
    @Autowired
    private TemplateConfigService templateConfigService;

    @Override
    public void save(Ueditor ueditor) {
        ueditorMapper.updateById(ueditor);
    }

    @Override
    public Ueditor findUeditorById(Integer id) {
        return ueditorMapper.findUeditorById(id);
    }

    @Override
    public void export(Integer id, HttpServletResponse response) throws Exception {
        String templatePath = UeditorServiceImpl.class.getResource("/ftl").getPath();
        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8");
        logger.debug("------templatePath-------" + templatePath);
        Ueditor ueditor = findUeditorById(id);
        HashMap<String, Object> data = getData(ueditor);
        TemplateConfig templateConfig = templateConfigService.selectByPrimaryKey(ueditor.getTemplateId());
        String templateName = templateConfig.getTemplateName();
        getRichContent(templateConfig, data, ueditor.getContent());
        WordGeneratorWithFreemarker.createDoc(templatePath, templateName + ".ftl", data, response);
    }

    private HashMap<String, Object> getData(Ueditor ueditor) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("code", ueditor.getId());
        data.put("name", ueditor.getTitle());
        data.put("note", ueditor.getNote());
        return data;
    }

    private String getRichContent(TemplateConfig templateConfig, HashMap<String, Object> data, String content) throws Exception {
        RichObject richObject = getRichObject(templateConfig);
        richObject.setHtml(content);
        RichHtmlHandler richHtmlHandler = WordGeneratorWithFreemarker.createRichHtmlHandler(richObject);
        List<RichHtmlHandler> richHtmlHandlerList = new ArrayList<RichHtmlHandler>();
        richHtmlHandlerList.add(richHtmlHandler);
        data.put("content", richHtmlHandler.getHandledDocBodyBlock());
        data.put("imagesXmlHrefString", WordGeneratorWithFreemarker.getXmlImgHref(richHtmlHandlerList));
        data.put("imagesBase64String", WordGeneratorWithFreemarker.getImagesBase64String(richHtmlHandlerList));
        return richHtmlHandler.getHandledDocBodyBlock();
    }

    private RichObject getRichObject(TemplateConfig templateConfig) {
        RichObject richObject = new RichObject();
        //--------------------此处可以spring配置文件配置，也可以直接读取属性文件获取------------------
        richObject.setDocSrcLocationPrex("file:///C:/" + templateConfig.getLocationPrex());
        richObject.setDocSrcParent(templateConfig.getTemplateName() + ".files");
        richObject.setNextPartId(templateConfig.getNextPartId());
        richObject.setShapeidPrex("_x56fe__x7247__x0020");
        richObject.setTypeid("#_x0000_t75");
        richObject.setSpidPrex("_x0000_i");
        richObject.setWebAppliction(false);
        //-----------------------------------------
        return richObject;
    }
}