/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.asynchronous.UserController
 * @version V1.0
 */
package com.moses.framework.samples.thread.controller;

import com.moses.framework.samples.thread.service.AsyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Moses
 * @date 2020/3/30
 */
@Controller
@RequestMapping("/async")
public class AsyncController {
    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);
    @Autowired
    private AsyncTask task;

    @GetMapping("async_task")
    public String exeTask(Model model) throws InterruptedException, ExecutionException {
        final CountDownLatch latch = new CountDownLatch(3);
        long begin = System.currentTimeMillis();
        Future<List> task1 = task.task1(latch);
        Future<String> task2 = task.task2(latch);
        Future<String> task3 = task.task3(latch);
        latch.await();
        long end = System.currentTimeMillis();
        String result = "执行总耗时=" + (end - begin) + ";" + task1.get().get(0) + ";" + task2.get() + ";" + task3.get();
        logger.info(result);
        model.addAttribute("result", result);
        return "/asynchronous/task";
    }
}