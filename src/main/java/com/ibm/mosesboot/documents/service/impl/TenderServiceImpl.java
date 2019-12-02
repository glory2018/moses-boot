/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.service.impl.SalaryPOServiceImpl
 * @version V1.0
 */
package com.ibm.mosesboot.documents.service.impl;

import com.ibm.mosesboot.documents.entity.PlanTender;
import com.ibm.mosesboot.documents.mapper.PlanTenderMapper;
import com.ibm.mosesboot.documents.service.TenderService;
import com.ibm.mosesboot.documents.util.DateUtil;
import com.ibm.mosesboot.freemarker.RichHtmlHandler;
import com.ibm.mosesboot.freemarker.WordGeneratorWithFreemarker;
import com.ibm.mosesboot.freemarker.bean.RichObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Moses
 * @date 2019/7/28
 */
@Service("tenderService")
public class TenderServiceImpl implements TenderService {
    private static final Logger logger = LoggerFactory.getLogger(TenderServiceImpl.class);
    @Resource
    private PlanTenderMapper planTenderMapper;

    @Override
    public PlanTender selectByPrimaryKey(Integer id) {
        return planTenderMapper.selectByPrimaryKey(id);
    }

    @Override
    public void export(PlanTender planTender, HttpServletResponse response, HttpServletRequest request) throws Exception {
        //用map存放数据
        HashMap<String, Object> data = getData();
        String templateName = planTender.getTemplateName();
        RichObject richObject = getRichObject(planTender.getLocationPrex(), templateName, planTender.getNextPartId());
        richObject.setHtml(planTender.getContent());
        RichHtmlHandler richHtmlHandler = WordGeneratorWithFreemarker.createRichHtmlHandler(richObject);
        List<RichHtmlHandler> richHtmlHandlerList = new ArrayList<RichHtmlHandler>();
        richHtmlHandlerList.add(richHtmlHandler);
//        data.put("title", richHtmlHandler.getHandledDocBodyBlock());
        String templatePath = Class.class.getResource("/ftl").getPath();
        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8");
        logger.debug("------templatePath-------" + templatePath);
        WordGeneratorWithFreemarker.createDoc(templatePath, templateName + ".ftl", data, response);
    }

    private HashMap<String, Object> getData() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("projectCode", "200000000002168");
        data.put("dateYear", "2019");
        data.put("projectName", "开发测试-自动选流程-大于500万");
        data.put("projectType", "汇报");
        data.put("projectSign", "采购共享服务中心");
        data.put("dateDayCN", DateUtil.getDate("yyyy年MM月dd日"));
        data.put("dept", "开发部");
        data.put("procurementContents", "xxx");
        data.put("procurementScale", "xxx");
        data.put("procurementAmount", "700");
        data.put("firstPurchase", "xx");
        data.put("procurementMode", "公开招标-资格预审");
        data.put("pretrialMethod", "xx");
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

    @Override
    public void save(PlanTender planTender) {
        planTenderMapper.updateByPrimaryKeySelective(planTender);
    }

    private RichObject getRichObject(String locationPrex, String templateName, String nextPartId) {
        RichObject richObject = new RichObject();
        //--------------------此处可以spring配置文件配置，也可以直接读取属性文件获取------------------
        //从mht文件中找
        richObject.setDocSrcLocationPrex("file:///C:/" + locationPrex);
        richObject.setDocSrcParent(templateName + ".files");
        richObject.setNextPartId(nextPartId);
        richObject.setShapeidPrex("_x56fe__x7247__x0020");
        richObject.setTypeid("#_x0000_t75");
        richObject.setSpidPrex("_x0000_i");
        richObject.setWebAppliction(false);
        //-----------------------------------------
        return richObject;
    }
}

