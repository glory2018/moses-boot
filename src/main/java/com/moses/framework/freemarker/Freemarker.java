package com.moses.framework.freemarker;

import com.moses.framework.freemarker.bean.RichObject;
import com.moses.framework.samples.export.entity.TemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
            return configuration.getTemplate(templateName, "UTF-8");
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
            template.setOutputEncoding("UTF-8");
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

    public static String getRichContent(RichObject richObject, String content) throws Exception {
        richObject.setHtml(content);
        RichHtmlHandler richHtmlHandler = WordGeneratorWithFreemarker.createRichHtmlHandler(richObject);
        List<RichHtmlHandler> richHtmlHandlerList = new ArrayList<RichHtmlHandler>();
        richHtmlHandlerList.add(richHtmlHandler);
        return richHtmlHandler.getHandledDocBodyBlock();
    }

    public static RichObject getRichObject(TemplateConfig templateConfig) {
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
