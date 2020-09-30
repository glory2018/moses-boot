/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.email.MailServiceTest
 * @version V1.0
 */
package com.moses.framework.samples.email;

import com.moses.framework.samples.email.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @author Moses
 * @date 2020/3/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    @Autowired
    private MailService mailService;

    @Test
    public void testSend() {
        String to = "279290810@qq.com";
        mailService.send(to, "模板邮件", UUID.randomUUID().toString().toUpperCase());
    }
}