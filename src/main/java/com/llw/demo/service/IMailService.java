package com.llw.demo.service;

/**
 * @description:
 * @author: llw
 * @date: 2018-12-30
 */
public interface IMailService {

    public void sendSimpleMail(String toAddr, String subject, String content) throws Exception;

    public void sendInlineResourceMail(String toAddr, String subject, String content) throws Exception;

    public void sendAttachmentsMail(String toAddr, String subject, String content) throws Exception;

}
