package com.moses.framework.samples.email.service;

/**
 * @author Moses
 * @date 2020/3/28
 */
public interface MailService {
    /**
     * 发送邮件
     *
     * @param to      收件人
     * @param subject 主题
     * @param text    内容
     */
    public void send(String to, String subject, String text);
}
