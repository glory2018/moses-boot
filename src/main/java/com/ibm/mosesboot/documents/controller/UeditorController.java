/*********************************************
 *
 * Copyright (C) 2019 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.ibm.mosesboot.documents.controller;
/**
 * @author Moses *
 * @Date 2019/1/2 23:34
 */

import com.ibm.mosesboot.documents.entity.Ueditor;
import com.ibm.mosesboot.documents.service.IUeditorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping(value = "/ueditor")
public class UeditorController {
    @Resource
    private IUeditorService ueditorService;

    @GetMapping("/")
    public String simpleDemo() {
        return "/documents/ueditor";
    }

    @PostMapping("/save")
    public String save(Model model, @ModelAttribute Ueditor ueditor) {
        ueditorService.save(ueditor);
        return "/ueditor/simpleDemo";
    }

    @RequestMapping("/ftlExport/{id}")
    public void ftlExport(@PathVariable Integer id, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Ueditor u = ueditorService.findUeditorById(id);
        ueditorService.export(u, response, request);
    }

    @RequestMapping("/downloadFile")
    private String downloadFile(HttpServletResponse response) {
        String downloadFilePath = "D:\\temp\\aa.docx";//被下载的文件在服务器中的路径,
        String fileName = "aaaaaaaaaaaaaaa.docx";//被下载文件的名称
        File file = new File(downloadFilePath);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }
}
