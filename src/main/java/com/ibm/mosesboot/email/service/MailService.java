package com.ibm.mosesboot.email.service;

/**
 * @author Moses
 * @date 2020/3/28
 */
public interface MailService {
    public void send(String to, String subject, String text);
}
