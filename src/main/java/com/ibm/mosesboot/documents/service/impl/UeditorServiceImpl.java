/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.service.impl.SalaryPOServiceImpl
 * @version V1.0
 */
package com.ibm.mosesboot.documents.service.impl;

import com.ibm.mosesboot.documents.entity.Ueditor;
import com.ibm.mosesboot.documents.mapper.UeditorMapper;
import com.ibm.mosesboot.documents.service.IUeditorService;
import com.ibm.mosesboot.freemarker.RichHtmlHandler;
import com.ibm.mosesboot.freemarker.WordGeneratorWithFreemarker;
import com.ibm.mosesboot.freemarker.bean.RichObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
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
    public void export(Ueditor ueditor, HttpServletResponse response, HttpServletRequest request) throws Exception {
        //用map存放数据
        HashMap<String, Object> data = new HashMap<String, Object>();
        RichObject richObject = new RichObject();
        richObject.setHtml(ueditor.getContent());
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
        data.put("title", ueditor.getTitle());
        data.put("context", richHtmlHandler.getHandledDocBodyBlock());
        String docFilePath = "招标方案.doc";
        String templatePath = Class.class.getResource("/ftl").getPath();
        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8");
        logger.debug("------templatePath-------" + templatePath);
        WordGeneratorWithFreemarker.createDoc(templatePath, "template.ftl", data, response);
    }

    /**
     * 处理IE/Edge（win10）浏览器中文乱码
     *
     * @param request
     * @param fileName
     * @return
     */
    public static String dealFileName(HttpServletRequest request, String fileName) {
        try {
            String codeFileName = "";
            String agent = request.getHeader("User-Agent");
            if (agent == null) {
                return fileName;
            }
            agent = agent.toUpperCase();
            if (null == agent) {
                codeFileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            } else if (-1 != agent.indexOf("MSIE") || -1 != agent.indexOf("TRIDENT") || -1 != agent.indexOf("EDGE")) {
                codeFileName = URLEncoder.encode(fileName, "UTF-8");
            } else {
                codeFileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            }
            return codeFileName;
        } catch (Exception e) {
            logger.error(e.getMessage());// logger
            return fileName;
        }
    }

    @Override
    public Ueditor findUeditorById(Integer id) {
        return ueditorMapper.findUeditorById(id);
    }
}

