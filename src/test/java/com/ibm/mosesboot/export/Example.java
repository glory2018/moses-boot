/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.export.Example
 * @version V1.0
 */
package com.ibm.mosesboot.export;

import com.ibm.mosesboot.freemarker.RichHtmlHandler;
import com.ibm.mosesboot.freemarker.WordGeneratorWithFreemarker;
import com.ibm.mosesboot.freemarker.bean.RichObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Moses
 * @date 2020/3/29
 */
public class Example {
    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    //创建富文本
    private static String getContent(String templatePath) {
        StringBuilder sb = new StringBuilder();
        sb.append("<img style='height:100px;width:200px;display:block;' src='" + templatePath + "\\1.png' />");
        sb.append("<p>《人月神话》内容源于作者Brooks在IBM公司任System计算机系列以及其庞大的软件系统OS项目经理时的实践经验。");
        sb.append("<img style='height:100px;width:200px;display:block;' src='" + templatePath + "\\2.png' />");
        sb.append("<p>1.1编程系统产品</p><p>1.2职业的乐趣</p><p>1.3职业的苦恼</p>");
        return sb.toString();
    }

    private static HashMap<String, Object> getData() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("code", "20200329");
        data.put("name", "freemarker导出word");
        data.put("note", "<p>《人月神话》，是由清华大学出版社于2002年11月出版的一本关于计算机软件的图书，作者是布鲁克斯(FrederickP.Brooks.Jr.) ，译者是汪颖。</p>");
        return data;
    }

    private static RichObject getRichObject(String templateName, String locationPrex, String nextPartId) {
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

    public static void main(String[] agrs) throws Exception {
        String templatePath = Example.class.getResource("/ftl").getPath();
        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8");//这里我的路径有空格添加此处理
        logger.debug("------templatePath-------" + templatePath);
        //用map存放数据
        HashMap<String, Object> data = getData();
        RichObject richObject = getRichObject("template", "213792E5", "01D605E0.15DC7170");
        richObject.setHtml(getContent(templatePath));
        //-----------------------------------------
        RichHtmlHandler richHtmlHandler = WordGeneratorWithFreemarker.createRichHtmlHandler(richObject);
        List<RichHtmlHandler> richHtmlHandlerList = new ArrayList<RichHtmlHandler>();
        richHtmlHandlerList.add(richHtmlHandler);
        data.put("imagesXmlHrefString", WordGeneratorWithFreemarker.getXmlImgHref(richHtmlHandlerList));
        data.put("imagesBase64String", WordGeneratorWithFreemarker.getImagesBase64String(richHtmlHandlerList));
        data.put("content", richHtmlHandler.getHandledDocBodyBlock());
        String docFilePath = "C:\\temp\\template.doc";
        WordGeneratorWithFreemarker.createDoc(templatePath, "template.ftl", data, docFilePath);
    }
}