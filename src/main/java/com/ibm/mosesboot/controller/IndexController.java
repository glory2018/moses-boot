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

import com.ibm.mosesboot.service.IPaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class IndexController {
    @Resource
    private IPaymentService paymentService;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("frequentlyList", paymentService.getFrequentlyList());
        model.addAttribute("yearList", paymentService.getYearList());
        model.addAttribute("vo", paymentService.getSalaryVo());
        return "payment_list";
    }
}