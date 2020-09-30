/*********************************************
 *
 * Copyright (C) 2019 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.moses.framework.samples.export.controller;
/**
 * @author Moses *
 * @Date 2019/1/2 23:34
 */

import com.moses.framework.samples.export.entity.Abroad;
import com.moses.framework.samples.export.service.AbroadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/abroad")
public class AbroadController {
    @Resource
    private AbroadService insuranceService;

    @GetMapping("/{id}")
    public String abroad(Model model, @PathVariable Integer id) {
        Abroad insurance = insuranceService.findById(id);
        model.addAttribute("abroad", insurance);
        return "/documents/abroad";
    }

    @ResponseBody
    @PostMapping("/save")
    public void save(@RequestBody(required = false) Abroad insurance) {
        insuranceService.save(insurance);
    }

    @RequestMapping("/ftlExport/{id}")
    public void ftlExport(@PathVariable Integer id, HttpServletResponse response) throws Exception {
        insuranceService.export(id, response);
    }
}
