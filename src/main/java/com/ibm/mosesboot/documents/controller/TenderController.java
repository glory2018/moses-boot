/*********************************************
 *
 * Copyright (C) 2019 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.ibm.mosesboot.documents.controller;

import com.ibm.mosesboot.documents.entity.PlanTender;
import com.ibm.mosesboot.documents.service.TenderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    @Resource
    private TenderService tenderService;

    @GetMapping("/")
    public String simpleDemo() {
        return "/documents/tender";
    }

    @GetMapping("/findById")
    public String findById(Model model) {
        PlanTender planTender = tenderService.selectByPrimaryKey(1);
        model.addAttribute("planTender", planTender);
        return "documents/tender";
    }

    @RequestMapping("/exportPlanTender/{id}")
    public void exportPlanTender(@PathVariable Integer id, HttpServletResponse response, HttpServletRequest request) throws Exception {
        PlanTender planTender = tenderService.selectByPrimaryKey(id);
        tenderService.export(planTender, response, request);
    }

    @PostMapping("/save")
    public String save(@RequestBody PlanTender planTender) {
        tenderService.save(planTender);
        return "documents/tender";
    }
}
