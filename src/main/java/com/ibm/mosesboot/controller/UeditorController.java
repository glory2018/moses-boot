/*********************************************
 *
 * Copyright (C) 2019 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.ibm.mosesboot.controller;
/**
 * @author Moses *
 * @Date 2019/1/2 23:34
 */

import com.ibm.mosesboot.entity.Ueditor;
import com.ibm.mosesboot.service.IUeditorService;
import org.docx4j.org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.docx4j.org.apache.poi.poifs.filesystem.DocumentEntry;
import org.docx4j.org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;

@Controller
@RequestMapping(value = "/ueditor")
public class UeditorController {
    @Resource
    private IUeditorService ueditorService;

    @GetMapping("/demo")
    public String demo() {
        return "/ueditor/simpleDemo";
    }

    @PostMapping("/save")
    public String save(Model model, @ModelAttribute Ueditor ueditor) {
        ueditorService.save(ueditor);
        return "/ueditor/demo";
    }

    @PostMapping("/ftlExport")
    public void ftlExport(Model model, @ModelAttribute Ueditor ueditor) {
        ueditorService.export(ueditor);
    }

    @PostMapping("/poiExport")
    public void poiExport(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Ueditor ueditor) {
        try {
            //word内容
            String content = ueditor.getContent();
            byte b[] = content.getBytes("GBK");  //这里是必须要设置编码的，不然导出中文就会乱码。
            ByteArrayInputStream bais = new ByteArrayInputStream(b);//将字节数组包装到流中

            /*
             * 关键地方
             * 生成word格式 */
            POIFSFileSystem poifs = new POIFSFileSystem();
            DirectoryEntry directory = poifs.getRoot();
            DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
            //输出文件
            request.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");//导出word格式
            response.addHeader("Content-Disposition", "attachment;filename=" +
                    new String(ueditor.getTitle().getBytes("GB2312"), "iso8859-1") + ".docx");
            ServletOutputStream ostream = response.getOutputStream();
            poifs.writeFilesystem(ostream);
            bais.close();
            ostream.close();
            poifs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
