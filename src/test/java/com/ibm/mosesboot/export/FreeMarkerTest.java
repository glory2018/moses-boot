/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.export.FreeMarkerTest
 * @version V1.0
 */
package com.ibm.mosesboot.export;
/**
 * @author Moses
 * @date 2019/12/3
 */

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * 1.创建配置实例
 * 2.获得模板
 * 3.创建数据模型[数据模型可以是List、Map对象 注意:Map类型的key必须是String类型]
 * 4.将模板和数据模型合并
 *
 * @author 郑清
 */
public class FreeMarkerTest {
    public void testCreateHtml() throws Exception {
        //①创建配置对象
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);//注意:这里需要传递一个版本
        File f = new File("E:/eclipse-workspace/JavaWeb_workspace/JavaWeb/src/main/webapp/test");
        //②读取模板文件夹
        cfg.setDirectoryForTemplateLoading(f);//设置要加载的模板文件的路径
        //③设置模板的编码格式
        cfg.setDefaultEncoding("UTF-8");
        //④获取模板对象
        Template template = cfg.getTemplate("hello.ftl");//hello.ftl是模板名称
        //⑤创建数据模型(这里使用map类型) --[数据模型可以是List、Map对象 注意:Map类型的key必须是String类型]
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "郑清");
        HashMap<String, Object> map2 = new HashMap<>();//map2存储的是a标签的href和显示名字
        map2.put("href", "https://www.baidu.com");
        map2.put("name", "百度");
        map.put("a", map2);
        //⑥将模板和数据模型合并 --> 输出模板,生成文件
        PrintWriter pw = new PrintWriter(new File(f, "hello.html"));
        template.process(map, pw);//合并 map:数据模型 pw:输出流对象
        pw.close();//关闭流
    }
}
