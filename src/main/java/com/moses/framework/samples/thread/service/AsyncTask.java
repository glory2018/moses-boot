/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @version V1.0
 */
package com.moses.framework.samples.thread.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/**
 * @author Moses
 * @date 2020/3/30
 */
@Component
public class AsyncTask {
    private static final Logger logger = LoggerFactory.getLogger(AsyncTask.class);

    @Async
    public Future<List> task1(final CountDownLatch latch) throws InterruptedException {
        List<String> list = new ArrayList<>();
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        latch.countDown();
        long end = System.currentTimeMillis();
        logger.debug("任务1耗时=" + (end - begin));
        list.add("任务1耗时=" + (end - begin));
        return new AsyncResult<List>(list);
    }

    public Future<String> task2(final CountDownLatch latch) throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        latch.countDown();
        long end = System.currentTimeMillis();
        logger.debug("任务2耗时=" + (end - begin));
        return new AsyncResult<String>("任务2耗时=" + (end - begin));
    }

    public Future<String> task3(final CountDownLatch latch) throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        latch.countDown();
        long end = System.currentTimeMillis();
        logger.debug("任务3耗时=" + (end - begin));
        return new AsyncResult<String>("任务3耗时=" + (end - begin));
    }
}