package com.ibm.mosesboot.export;

import com.ibm.mosesboot.bean.RichObject;
import com.ibm.mosesboot.util.WordGeneratorWithFreemarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wesley on 2017-05-10.
 * 演示例子
 */
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] agrs) throws Exception{
        //用map存放数据
        HashMap<String, Object> data = new HashMap<String, Object>();
        //创建富文本
        StringBuilder sb = new StringBuilder();
        sb.append("<div>");
        sb.append("</br><span>wesley 演示 导出富文本！@@#######￥￥%%%%………………&&&**~~~~~~&&&&&&&&、、、、、、、、</span>");
        sb.append("</br><span>中国梦，幸福梦！</span>");
        sb.append("</div>");

        RichObject richObject = new RichObject();
        richObject.setHtml(sb.toString());
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
        data.put("datetime","2017-05-10");
        data.put("title","演示demo");
        data.put("context", richHtmlHandler.getHandledDocBodyBlock());

        String docFilePath = "D:\\temp\\招标方案.doc";
        String templatePath = Class.class.getResource("/ftl").getPath();
        templatePath = java.net.URLDecoder.decode(templatePath,"utf-8");//这里我的路径有空格添加此处理
        logger.debug("------templatePath-------"+templatePath);
        WordGeneratorWithFreemarker.createDoc(templatePath,"template.ftl",data,docFilePath);
    }
}
