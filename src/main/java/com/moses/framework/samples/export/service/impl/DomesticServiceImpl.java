/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.service.impl.SalaryPOServiceImpl
 * @version V1.0
 */
package com.moses.framework.samples.export.service.impl;

import com.moses.framework.freemarker.Freemarker;
import com.moses.framework.freemarker.WordGeneratorWithFreemarker;
import com.moses.framework.freemarker.bean.RichObject;
import com.moses.framework.samples.export.entity.Domestic;
import com.moses.framework.samples.export.entity.DomesticDetail;
import com.moses.framework.samples.export.entity.TemplateConfig;
import com.moses.framework.samples.export.mapper.DomesticDetailMapper;
import com.moses.framework.samples.export.mapper.DomesticMapper;
import com.moses.framework.samples.export.service.DomesticService;
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
@Service("domesticService")
public class DomesticServiceImpl implements DomesticService {
    @Resource
    private DomesticMapper domesticMapper;
    @Resource
    private DomesticDetailMapper domesticDetailMapper;
    @Autowired
    private TemplateConfigService templateConfigService;

    @Override
    public void save(Domestic insurance) {
        domesticMapper.updateByPrimaryKey(insurance);
    }

    @Override
    public Domestic findById(Integer id) {
        return domesticMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DomesticDetail> getDetailList(Integer id) {
        return domesticDetailMapper.selectList(id);
    }

    @Override
    public void export(Integer id, HttpServletResponse response) throws Exception {
        String templatePath = UeditorServiceImpl.class.getResource("/ftl").getPath();
        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8");
        Domestic insurance = findById(id);
        HashMap<String, Object> data = getData(insurance);
        TemplateConfig templateConfig = templateConfigService.selectByPrimaryKey(insurance.getTemplateId());
        RichObject richObject = Freemarker.getRichObject(templateConfig);
        data.put("infoList", Freemarker.getRichContent(richObject, insurance.getInfoList()));
        data.put("cosremark", Freemarker.getRichContent(richObject, insurance.getCosremark()));
        WordGeneratorWithFreemarker.createDoc(templatePath, templateConfig.getTemplateName() + ".ftl", data, response);
    }

    private HashMap<String, Object> getData(Domestic insurance) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("projectNameCN", insurance.getProjectNameCN());
        data.put("cn", insurance.getCountryCodeName());
        data.put("policyInsured", insurance.getPolicyInsured());
        data.put("passwdSetDate", insurance.getPasswdSetDate());
        data.put("groupEquity", insurance.getGroupEquity());
        data.put("shareCNPC", insurance.getShareCNPC());
        List<DomesticDetail> detailList = getDetailList(insurance.getId());
        data.put("list", detailList);
        data.put("ESGP", insurance.geteSGP());
        data.put("linfen", insurance.getLinfen());
        data.put("cost", insurance.getCost());
        data.put("brokercname", insurance.getBrokercname());
        data.put("deduction", insurance.getDeduction());
        data.put("billComName", insurance.getBillComName());
        data.put("chief", insurance.getChief());
        data.put("sumpaid", insurance.getSumpaid());
        data.put("operateuser", insurance.getOperateuser());
        data.put("claimDate", insurance.getClaimDate());
        return data;
    }
//    private List<Map> getList(List<DomesticDetail> detailList) {
//        List<Map> list = new ArrayList<>();
//        for(DomesticDetail detail:detailList){
//            Map map = new HashMap<>();
//            map.put("riskName", detail.getRiskName());
//            map.put("", detail.getRiskName());
//            map.put("", detail.getRiskName());
//            map.put("", detail.getRiskName());
//        }
//    }
}

