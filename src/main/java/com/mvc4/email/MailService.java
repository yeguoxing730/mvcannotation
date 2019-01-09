package com.mvc4.email;

import java.util.List;

/**
 * 发送邮件服务
 */
public interface MailService {
    /**
     * 发送简单邮件
     *
     * @param to      接收人
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送简单邮件
     *
     * @param batchUsers 接收人列表
     * @param subject    主题
     * @param content    内容
     */
    void sendSimpleMail(List<String> batchUsers, String subject, String content);

    /**
     * 发送html格式邮件
     *
     * @param to      接收人
     * @param subject 主题
     * @param content 内容
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     *
     * @param to       接收人
     * @param subject  主题
     * @param content  内容
     * @param filePath 文件路径
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * 发送带静态资源的邮件
     *
     * @param to      接收人
     * @param subject 主题
     * @param content 内容
     * @param rscPath
     * @param rscId
     */
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
