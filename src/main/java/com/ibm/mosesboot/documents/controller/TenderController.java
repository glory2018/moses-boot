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

import com.ibm.mosesboot.documents.entity.PlanTender;
import com.ibm.mosesboot.documents.service.TenderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/tender")
public class TenderController {
    @Resource
    private TenderService tenderService;

    @GetMapping("/findById")
    public String findById(Model model) {
        PlanTender planTender = tenderService.selectByPrimaryKey(1);
        model.addAttribute("planTender", planTender);
        return "purchase/planTender";
    }
}
