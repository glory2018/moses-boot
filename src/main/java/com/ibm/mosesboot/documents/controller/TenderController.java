/*********************************************
 *
 * Copyright (C) 2019 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.ibm.mosesboot.documents.controller;

import com.ibm.mosesboot.documents.service.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 招标
 *
 * @author Moses
 */
@Controller
@RequestMapping(value = "/tender")
public class TenderController {
    @Autowired
    private TenderService tenderService;

    @GetMapping("/")
    public String simpleDemo() {
        return "/documents/tender";
    }

    @GetMapping(value = "/export")
    public void export(HttpServletRequest request, HttpServletResponse response,
                       @RequestParam(value = "tmplId", required = false) String tmplId,
                       @RequestParam(value = "prjId", required = false) String prjId) {
        try {
            tenderService.export(request, response, tmplId, prjId);
        } catch (Exception e) {
//            throw new Exception();
        }
    }
}
