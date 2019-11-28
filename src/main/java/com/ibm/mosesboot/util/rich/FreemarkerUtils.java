/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.util.FreemarkerUtils
 * @version V1.0
 */
package com.ibm.mosesboot.util.rich;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author Moses
 * @date 2019/11/27
 */
public class FreemarkerUtils {
    public static String getTemplate(String template, Map<String, Object> map) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        String templatePath = FreemarkerUtils.class.getResource("/").getPath() + "/templates";
        cfg.setDirectoryForTemplateLoading(new File(templatePath));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        Template temp = cfg.getTemplate(template);
        StringWriter stringWriter = new StringWriter();
        temp.process(map, stringWriter);
        return stringWriter.toString();
    }

    public static Template getTemplate(String template) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        String templatePath = FreemarkerUtils.class.getResource("/").getPath() + "/ftl/";
        cfg.setDirectoryForTemplateLoading(new File(templatePath));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        return cfg.getTemplate(template);
    }
}
