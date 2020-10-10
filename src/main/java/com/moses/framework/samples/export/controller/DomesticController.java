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

import com.moses.framework.samples.export.entity.Domestic;
import com.moses.framework.samples.export.entity.DomesticDetail;
import com.moses.framework.samples.export.service.DomesticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/domestic")
public class DomesticController {
    @Resource
    private DomesticService domesticService;

    @GetMapping("/{id}")
    public String domestic(Model model, @PathVariable Integer id) {
        Domestic domestic = domesticService.findById(id);
        model.addAttribute("domestic", domestic);
        List<DomesticDetail> list = domesticService.getDetailList(id);
        model.addAttribute("detailList", list);
        return "/documents/domestic";
    }

    @ResponseBody
    @PostMapping("/save")
    public void save(@RequestBody(required = false) Domestic domestic) {
        domesticService.save(domestic);
    }

    @RequestMapping("/ftlExport/{id}")
    public void ftlExport(@PathVariable Integer id, HttpServletResponse response) throws Exception {
        domesticService.export(id, response);
    }
}
