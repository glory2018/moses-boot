/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.service.impl.SalaryPOServiceImpl
 * @version V1.0
 */
package com.ibm.mosesboot.documents.service.impl;

import com.ibm.mosesboot.documents.entity.TemplateConfig;
import com.ibm.mosesboot.documents.mapper.PlanTenderMapper;
import com.ibm.mosesboot.documents.service.TemplateConfigService;
import com.ibm.mosesboot.documents.service.TenderService;
import com.ibm.mosesboot.documents.util.DateUtil;
import com.ibm.mosesboot.freemarker.RichHtmlHandler;
import com.ibm.mosesboot.freemarker.WordGeneratorWithFreemarker;
import com.ibm.mosesboot.freemarker.bean.RichObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Moses
 * @date 2019/7/28
 */
@Service("tenderService")
public class TenderServiceImpl implements TenderService {
    private static final Logger logger = LoggerFactory.getLogger(TenderServiceImpl.class);
    @Autowired
    private TemplateConfigService templateConfigService;
    @Resource
    PlanTenderMapper planTenderMapper;

    @Override
    public void export(HttpServletRequest request, HttpServletResponse response, String tmplId, String prjId) throws Exception {
        //用map存放数据
        HashMap<String, Object> data = getData(prjId);
        //
        TemplateConfig templateConfig = templateConfigService.selectByPrimaryKey(tmplId);
        String templateName = templateConfig.getTemplateName();
//        getRichContent(templateConfig,"");
        String templatePath = Class.class.getResource("/ftl").getPath();
        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8");
        logger.debug("------templatePath-------" + templatePath);
        WordGeneratorWithFreemarker.createDoc(templatePath, templateName + ".ftl", data, response);
    }

    private String getRichContent(TemplateConfig templateConfig, String content) throws Exception {
        RichObject richObject = getRichObject(templateConfig);
        richObject.setHtml(content);
        RichHtmlHandler richHtmlHandler = WordGeneratorWithFreemarker.createRichHtmlHandler(richObject);
        List<RichHtmlHandler> richHtmlHandlerList = new ArrayList<RichHtmlHandler>();
        richHtmlHandlerList.add(richHtmlHandler);
        return richHtmlHandler.getHandledDocBodyBlock();
    }

    private HashMap<String, Object> getData(String projectId) {
        Map map = planTenderMapper.getProjectInfo(projectId);
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("projectCode", "200000000002168");
        data.put("dateYear", "2019");
        data.put("evaluationMethod", "xx");
        data.put("bidDivision", "xx");
        data.put("evaluationWeight", "xx");
        data.put("suppliersNumber", "xx");
        data.put("winningNumber", "xx");
        data.put("biddingAgency", "xx");
        data.put("serviceUnit", "xx");
        data.put("completionTime", "2019年12月");
        return data;
    }

    private RichObject getRichObject(TemplateConfig templateConfig) {
        RichObject richObject = new RichObject();
        //--------------------此处可以spring配置文件配置，也可以直接读取属性文件获取------------------
        //从mht文件中找
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

