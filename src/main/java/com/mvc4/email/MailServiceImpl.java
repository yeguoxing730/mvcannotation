package com.mvc4.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Component
public class MailServiceImpl implements MailService , ApplicationRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        logger.info("MailServiceImpl|sendSimpleMail|发送邮件request|to:{},subject:{},content:{}",to,subject,content);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            logger.info("MailServiceImpl|sendSimpleMail|发送邮件成功|to:{},subject:{},content:{}",to,subject,content);
        } catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
        }
    }

    @Override
    public void sendSimpleMail(List<String> batchUsers, String subject, String content) {
        logger.info("MailServiceImpl|sendSimpleMail|批量发送邮件request|batchUsers:{},subject:{},content:{}",batchUsers,subject,content);
        if(CollectionUtils.isEmpty(batchUsers)){
            logger.warn("MailServiceImpl|sendSimpleMail|批量发送邮件接受人列表为空");
        }
        batchUsers.forEach(toUser->{
            sendSimpleMail(toUser,subject,content);
        });
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        logger.info("MailServiceImpl|sendHtmlMail|发送HTML邮件|to:{},subject:{},content:{}",to,subject,content);
        MimeMessage message = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            setMessageInfo(helper,from,to,subject,content,true);
            mailSender.send(message);
            logger.info("MailServiceImpl|sendHtmlMail|发送HTML邮件成功|to:{},subject:{},content:{}",to,subject,content);
        } catch (MessagingException e) {
            logger.error("发送html邮件时发生异常！", e);
        }
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        logger.info("MailServiceImpl|sendAttachmentsMail|发送带附件的邮件|to:{},subject:{},content:{},filePath:{}",to,subject,content,filePath);
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            setMessageInfo(helper,from,to,subject,content,true);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
           // 添加多个附件可以使用多条 helper.addAttachment(fileName, file)
            mailSender.send(message);
            logger.info("MailServiceImpl|sendAttachmentsMail|发送带附件的邮件成功|to:{},subject:{},content:{},filePath:{}",to,subject,content,filePath);
        } catch (MessagingException e) {
            logger.error("发送带附件的邮件时发生异常！", e);
        }
    }

    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
        logger.info("MailServiceImpl|sendAttachmentsMail|发送嵌套静态资源的邮件|to:{},subject:{},content:{},filePath:{},resPath:{},rscId:{}",to,subject,content,rscPath,rscId);
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            setMessageInfo(helper,from,to,subject,content,true);
            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);
            mailSender.send(message);
            logger.info("MailServiceImpl|sendAttachmentsMail|发送嵌套静态资源的邮件成功|to:{},subject:{},content:{},filePath:{},resPath:{},rscId:{}",to,subject,content,rscPath,rscId);
        } catch (MessagingException e) {
            logger.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
    }

    /**
     * 设置邮件信息
     * @param helper
     * @param from  发送人
     * @param to    接收人
     * @param subject 主体
     * @param content 内容
     * @param isHtml  是否html邮件
     * @throws MessagingException
     */
    private void setMessageInfo(MimeMessageHelper helper,String from,String to,String subject,String content,boolean isHtml) throws MessagingException{
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, isHtml);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.sendSimpleMail("yeguoxing730@163.com","test simple mail"," hello this is simple mail");
    }
}
