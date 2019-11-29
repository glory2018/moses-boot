package com.ibm.mosesboot.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;

/**
 * Created by wesley on 2017-05-10.
 * Freemarker对象
 */
public class Freemarker {
    private static final Logger logger = LoggerFactory.getLogger(Freemarker.class);
    private static Configuration configuration = null;

    /**
     * 获取单例对象
     *
     * @param templatePath ftl模板文件所在路径
     * @return
     * @throws IOException
     */
    private static Configuration getInstance(String templatePath) throws IOException {
        logger.debug("Freemarker getInstance");
        if (configuration == null) {
            configuration = new Configuration(Configuration.getVersion());
            configuration.setDirectoryForTemplateLoading(new File(templatePath));
            configuration.setDefaultEncoding("utf-8");
        }
        return configuration;
    }

    /**
     * 获取模板对象
     *
     * @param templateName 模板文件名称
     * @return
     */
    private static Template getTemplate(String templateName) {
        logger.debug("Freemarker getTemplate");
        try {
            Template template = configuration.getTemplate(templateName);
            template.setEncoding("UTF-8");
            return template;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 基于文件的输出
     *
     * @param templatePath 模板所在路径 xxx/xxx/template
     * @param templateName 模板名字 xxx.ftl
     * @param dataMap      数据集合
     * @param outputStream 文件流new FileOutputStream(new File(outPath))|response.getOutputStream()
     */
    public static void fprint(String templatePath, String templateName, Map<String, Object> dataMap, OutputStream outputStream) {
        logger.debug("Freemarker fprint file");
        try {
            getInstance(templatePath);
            Template template = getTemplate(templateName);
            Writer out = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            template.process(dataMap, out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
