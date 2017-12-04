package com.boot.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/21/16
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MailSenderService {
    @Autowired
    private org.springframework.mail.javamail.JavaMailSender mailSender;
    public void sendSimpleEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("yeguoxing730@163.com");//发送者.
        message.setTo("yeguoxing730@163.com");//接收者.
        message.setSubject("测试邮件（邮件主题）");//邮件主题.
        message.setText("这是邮件内容");//邮件内容.
        mailSender.send(message);//发送邮件
    }
    public void sendAttachmentsEmail() throws MessagingException {
        //这个是javax.mail.internet.MimeMessage下的，不要搞错了。
        MimeMessage mimeMessage =  mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //基本设置.
        helper.setFrom("412887952@qq.com");//发送者.
        helper.setTo("1473773560@qq.com");//接收者.
        helper.setSubject("测试附件（邮件主题）");//邮件主题.
        helper.setText("这是邮件内容（有附件哦.）");//邮件内容.

        //org.springframework.core.io.FileSystemResource下的:
        //附件1,获取文件对象.
        FileSystemResource file1 = new FileSystemResource(new File("C:\\IDEA\\ideaWorkspaces\\sprintboot\\springbootmvc\\src\\main\\resources\\application.properties"));
        //添加附件，这里第一个参数是在邮件中显示的名称，也可以直接是head.jpg，但是一定要有文件后缀，不然就无法显示图片了。
        helper.addAttachment("头像1.jpg", file1);
        //附件2
        FileSystemResource file2 = new FileSystemResource(new File("C:\\IDEA\\ideaWorkspaces\\sprintboot\\springbootmvc\\src\\main\\resources\\logback-spring.xml"));
        helper.addAttachment("头像2.jpg", file2);

        mailSender.send(mimeMessage);
    }
//    public void sendTemplateMail() throws Exception {
//
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//        //基本设置.
//        helper.setFrom("412887952@qq.com");//发送者.
//        helper.setTo("1473773560@qq.com");//接收者.
//        helper.setSubject("模板邮件（邮件主题）");//邮件主题.
//
//        Map<String, Object> model = new HashMap<String, Object>();
//        model.put("username", "林峰");
//
//
////        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("email.ftl");//加载资源文件
//        //实际开发中这个定义一个bean进行使用，上一个代码就是定义为bean进行加入的，这里为了方便直接new使用。
//        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//        configurer.setTemplateLoaderPath("classpath:templates");
//       Template template = freeMarkerConfigurer.getConfiguration().getTemplate("email.ftl");//加载资源文件
//
//        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
//        helper.setText(html, true);
//
//        mailSender.send(mimeMessage);
//    }
}
