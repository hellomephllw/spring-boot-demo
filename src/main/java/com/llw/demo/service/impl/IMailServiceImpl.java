package com.llw.demo.service.impl;

import com.llw.demo.service.IMailService;
import com.happy.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: llw
 * @date: 2018-12-30
 */
@Service
public class IMailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.fromAddr}")
    private String fromAddr;

    @Override
    public void sendSimpleMail(String toAddr, String subject, String content) throws Exception {
        MailUtil.sendSimpleMail(mailSender, "", fromAddr, toAddr, subject, content);
    }

    @Override
    public void sendInlineResourceMail(String toAddr, String subject, String content) throws Exception {
        MailUtil.sendInlineResourceMail(mailSender, "", fromAddr, toAddr, subject, content, "");
    }

    @Override
    public void sendAttachmentsMail(String toAddr, String subject, String content) throws Exception {
        MailUtil.sendAttachmentsMail(mailSender, "", fromAddr, toAddr, subject, content, "", "");
    }

}
