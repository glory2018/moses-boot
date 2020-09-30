/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.service.impl.SalaryPOServiceImpl
 * @version V1.0
 */
package com.moses.framework.samples.export.service.impl;

import com.moses.framework.freemarker.Freemarker;
import com.moses.framework.freemarker.WordGeneratorWithFreemarker;
import com.moses.framework.freemarker.bean.RichObject;
import com.moses.framework.samples.export.entity.Abroad;
import com.moses.framework.samples.export.entity.AbroadDetail;
import com.moses.framework.samples.export.entity.TemplateConfig;
import com.moses.framework.samples.export.mapper.AbroadDetailMapper;
import com.moses.framework.samples.export.mapper.AbroadMapper;
import com.moses.framework.samples.export.service.AbroadService;
import com.moses.framework.samples.export.service.TemplateConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @author Moses
 * @date 2019/7/28
 */
@Service("insuranceService")
public class AbroadServiceImpl implements AbroadService {
    @Resource
    private AbroadMapper abroadMapper;
    @Resource
    private AbroadDetailMapper abroadDetailMapper;
    @Autowired
    private TemplateConfigService templateConfigService;

    @Override
    public void save(Abroad insurance) {
        abroadMapper.updateByPrimaryKey(insurance);
    }

    @Override
    public Abroad findById(Integer id) {
        return abroadMapper.selectByPrimaryKey(id);
    }

    @Override
    public void export(Integer id, HttpServletResponse response) throws Exception {
        String templatePath = UeditorServiceImpl.class.getResource("/ftl").getPath();
        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8");
        Abroad insurance = findById(id);
        HashMap<String, Object> data = getData(insurance);
        TemplateConfig templateConfig = templateConfigService.selectByPrimaryKey(insurance.getTemplateId());
        RichObject richObject = Freemarker.getRichObject(templateConfig);
        data.put("infoList", Freemarker.getRichContent(richObject, insurance.getInfoList()));
        data.put("cosremark", Freemarker.getRichContent(richObject, insurance.getCosremark()));
        WordGeneratorWithFreemarker.createDoc(templatePath, templateConfig.getTemplateName() + ".ftl", data, response);
    }

    private HashMap<String, Object> getData(Abroad insurance) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("projectNameCN", insurance.getProjectNameCN());
        data.put("countryCodeName", insurance.getCountryCodeName());
        data.put("policyInsured", insurance.getPolicyInsured());
        data.put("passwdSetDate", insurance.getPasswdSetDate());
        data.put("groupEquity", insurance.getGroupEquity());
        data.put("shareCNPCView", insurance.getShareCNPCView());
        List<AbroadDetail> list = abroadDetailMapper.selectList(insurance.getId());
        data.put("list", list);
        data.put("Linfen", "yes");
        data.put("LinfenRate", "100");
        data.put("costPrem", "100");
        data.put("costCnpc", "111");
        data.put("brokercname", insurance.getBrokercname());
        data.put("deduction", insurance.getDeduction());
        data.put("billComName", insurance.getBillComName());
        data.put("chief", insurance.getChief());
        data.put("sumpaid", insurance.getSumpaid());
        data.put("operateuser", insurance.getOperateuser());
        data.put("claimDate", insurance.getClaimDate());
        return data;
    }
}

