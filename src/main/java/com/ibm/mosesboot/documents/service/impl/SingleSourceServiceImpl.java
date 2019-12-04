/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.service.impl.SalaryPOServiceImpl
 * @version V1.0
 */
package com.ibm.mosesboot.documents.service.impl;

import com.ibm.mosesboot.documents.entity.SingleSource;
import com.ibm.mosesboot.documents.entity.TemplateConfig;
import com.ibm.mosesboot.documents.mapper.SingleSourceMapper;
import com.ibm.mosesboot.documents.service.SingleSourceService;
import com.ibm.mosesboot.documents.service.TemplateConfigService;
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
@Service("singleSourceService")
public class SingleSourceServiceImpl implements SingleSourceService {
    private static final Logger logger = LoggerFactory.getLogger(SingleSourceServiceImpl.class);
    @Autowired
    private TemplateConfigService templateConfigService;
    @Resource
    SingleSourceMapper singleSourceMapper;

    @Override
    public void export(HttpServletRequest request, HttpServletResponse response, String tmplId, String prjId) throws Exception {
        //用map存放数据
        HashMap<String, Object> data = getData(prjId);
        //
        TemplateConfig templateConfig = templateConfigService.selectByPrimaryKey(tmplId);
        String templateName = templateConfig.getTemplateName();
        SingleSource singleSource = singleSourceMapper.selectByPrimaryKey("98C881BBCAA75AC6E0530300A8C02C6D");
        data.put("purchaseBasisList", getRichContent(templateConfig,singleSource.getRichContent()));
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
        Map map = singleSourceMapper.getProjectInfo(projectId);
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("projectCode", "100000000014711");
        data.put("title", "关于中国移动2019年至2020年XX设\r备/产品/服务集中采购方案的汇报");
        data.put("signDept", "采购共享服务中心");
        data.put("signDate", DateUtil.getDate("yyyy年MM月dd日"));
        data.put("dept", "采集一部");
        data.put("about", "xxx");
        data.put("projectName", "测试单一来源1");
        data.put("procurementContents", "xxxxx");
        data.put("procurementScale", "xx");
        data.put("procurementAmount", "21,321");
        data.put("firstPurchase", "是");
        data.put("suppliersName", "xxx");
        data.put("supportUnit", "xx");
        data.put("serviceUnit", "xx");
        data.put("completionTime", "2019年12月");
        data.put("reason", "<p>    \t    本项目符合《中国移动通信集团有限公司采购实施管理办法》中规定的10种单一来源采购场景中XXXXXXXXX场景要求，与XXXX公司进行谈判。 &nbsp; \n" +
                "如果是特殊场景，请说明采用单一来源谈判方式的原因及需求审批层级。\n" +
                "</p>");
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

