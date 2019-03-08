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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "test";
    }
}