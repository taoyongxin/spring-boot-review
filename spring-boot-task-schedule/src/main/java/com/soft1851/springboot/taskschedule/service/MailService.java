package com.soft1851.springboot.taskschedule.service;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * @author Tao
 * @version 1.0
 * @ClassName MailService
 * @Description TODO
 * @date 2020-05-15 15:13
 **/
public interface MailService {
    /**
     * 发送简单的文本邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleTextMail(String to, String subject, String content);

    /**
     * 发送HTML邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content) throws MessagingException;

    /**
     * 发送附件邮箱
     *
     * @param to
     * @param subject
     * @param content
     * @param fileArr
     * @throws MessagingException
     */
    void sendAttachmentMail(String to, String subject, String content, String... fileArr) throws MessagingException;

    /**
     * 发送图片邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param imgMap
     * @throws MessagingException
     */
    void sendImgMail(String to, String subject, String content, Map<String, String> imgMap) throws MessagingException;
}
