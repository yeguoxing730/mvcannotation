package com.mvc4.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/21/16
 * Time: 9:46 AM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/mail")
public class MailController {

    @Resource
    com.mvc4.email.MailSenderService mailSenderService;
    @RequestMapping("/sendSimpleMail")
    public @ResponseBody
    String sendMail(){
        mailSenderService.sendSimpleEmail();
        return "send mail success";
    }
    /**
     * 返回html模板.
     */
    @RequestMapping("/sendAttachmentMail")
    public @ResponseBody
    String sendAttachmentMail() throws MessagingException {
        mailSenderService.sendAttachmentsEmail();
        return "send attachement mail success";
    }
}
