/*********************************************
 *
 * Copyright (C) 2019 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.ibm.mosesboot.moses.controller;
/**
 * @author Moses *
 * @Date 2019/1/2 23:34
 */

import com.ibm.mosesboot.moses.service.IPaymentService;
import com.ibm.mosesboot.moses.vo.Frequently;
import com.ibm.mosesboot.moses.vo.SalaryVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/payment")
public class PaymentController {
    @Resource
    private IPaymentService paymentService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("frequentlyList", Frequently.values());
        model.addAttribute("yearList", paymentService.getYearList());
        model.addAttribute("vo", paymentService.getSalaryVo());
        return "salary/payment_list";
    }

    @PostMapping("/list")
    public String list(Model model, @ModelAttribute SalaryVO vo) {
        model.addAttribute("frequentlyList", Frequently.values());
        model.addAttribute("yearList", paymentService.getYearList());
        model.addAttribute("incrementList", paymentService.getIncrementList(vo));
        model.addAttribute("deductionList", paymentService.getDeductionList(vo));
        model.addAttribute("predictionList", paymentService.getPredictionList(vo));
        model.addAttribute("vo", paymentService.getSalaryVo());
        return "salary/payment_list";
    }
}
