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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
        return "/ueditor/simpleDemo";
    }

    @PostMapping("/ftlExport")
    public void ftlExport(Model model, @ModelAttribute Ueditor ueditor) throws Exception {
        ueditorService.export(ueditor);
    }
}
