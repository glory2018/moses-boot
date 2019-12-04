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
 * Created by wesley on 2017-05-10.
 * 演示例子
 */
public class ClientExample {
    private static final Logger logger = LoggerFactory.getLogger(ClientExample.class);

    public static void main(String[] agrs) throws Exception {
        //用map存放数据
        HashMap<String, Object> data = new HashMap<String, Object>();
        //创建富文本
        StringBuilder sb = new StringBuilder();
        sb.append("<div>");
        sb.append("<img style='height:100px;width:200px;display:block;' src='D:\\temp\\1.png' />");
        sb.append("</br><span>wesley 演示 导出富文本！@@#######￥￥%%%%………………&&&**~~~~~~&&&&&&&&、、、、、、、、</span>");
        sb.append("</br><span>----多图分割线---</span>");
        sb.append("</br><img style='height:100px;width:200px;display:block;' src='D:\\temp\\2.png' />");
        sb.append("</br><span>中国梦，幸福梦！</span>");
        sb.append("</div>");
        RichObject richObject = new RichObject();
        richObject.setHtml(sb.toString());
        //--------------------此处可以spring配置文件配置，也可以直接读取属性文件获取------------------
        //从mht文件中找
        richObject.setDocSrcLocationPrex("file:///C:/268BA2D4");
        richObject.setDocSrcParent("test.files");
        richObject.setNextPartId("01D5AADE.67ACB0D0");
        richObject.setShapeidPrex("_x56fe__x7247__x0020");
        richObject.setTypeid("#_x0000_t75");
        richObject.setSpidPrex("_x0000_i");
        richObject.setWebAppliction(false);
        //-----------------------------------------
        RichHtmlHandler richHtmlHandler = WordGeneratorWithFreemarker.createRichHtmlHandler(richObject);
        List<RichHtmlHandler> richHtmlHandlerList = new ArrayList<RichHtmlHandler>();
        richHtmlHandlerList.add(richHtmlHandler);
        data.put("imagesXmlHrefString", WordGeneratorWithFreemarker.getXmlImgHref(richHtmlHandlerList));
        logger.debug("------imagesXmlHrefString-------" + WordGeneratorWithFreemarker.getXmlImgHref(richHtmlHandlerList));
        data.put("imagesBase64String", WordGeneratorWithFreemarker.getImagesBase64String(richHtmlHandlerList));
        logger.debug("------imagesBase64String-------" + WordGeneratorWithFreemarker.getImagesBase64String(richHtmlHandlerList));
        data.put("projectCode", "1234");
        data.put("title", "演示demo");
        data.put("list", richHtmlHandler.getHandledDocBodyBlock());
        String docFilePath = "D:\\test.doc";
        String templatePath = Class.class.getResource("/ftl").getPath();
        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8");//这里我的路径有空格添加此处理
        logger.debug("------templatePath-------" + templatePath);
        WordGeneratorWithFreemarker.createDoc(templatePath, "test.ftl", data, docFilePath);
    }
}
