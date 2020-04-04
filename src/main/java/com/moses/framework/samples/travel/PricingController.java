/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.travel.PricingController
 * @version V1.0
 */
package com.moses.framework.samples.travel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Moses
 * @date 2020/4/4
 */
@Controller
@RequestMapping(value = "/pricing")
public class PricingController {
    @GetMapping("/")
    public String index(Model model) {
        return "pricing/index";
    }
}