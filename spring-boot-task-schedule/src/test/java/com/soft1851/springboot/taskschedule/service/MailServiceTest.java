package com.soft1851.springboot.taskschedule.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailServiceTest {

    @Resource
    private MailService mailService;

    @Test
    void sendSimpleTextMail() {
        String to = "1427177855@qq.com";
        String subject = "SpringBoot发送简单文本邮件";
        String content = "<h3>第一封邮件测试内容</h3>";
        mailService.sendSimpleTextMail(to, subject, content);
    }

    @Test
    void sendHtmlMail() throws Exception {
        String to = "1427177855@qq.com";
        String subject = "SpringBoot发送HTML邮件";
        String content = "<h3>第一封邮件测试内容</h3>";
        mailService.sendHtmlMail(to, subject, content);
    }

    @Test
    void sendAttachmentMail() throws Exception {
        String to = "1427177855@qq.com";
        String subject = "SpringBoot发送附件邮件";
        String content = "<h3>第一封邮件测试内容</h3>";
        String filePath = "F:\\temp\\songList.xlsx";
        mailService.sendAttachmentMail(to, subject, content, filePath, filePath);
    }

    @Test
    void sendImgMail() throws Exception {
        String to = "1427177855@qq.com";
        String subject = "SpringBoot发送图片邮件";
        String content = "<h3>第一封邮件测试内容</h3><br/><img src=\"cid:img01\" />";
        String imgPath = "F:\\我的\\5.图片\\avatar\\14.jpg";
        Map<String, String> imgMap = new HashMap<>();
        //以键值对的形式存入
        imgMap.put("img01", imgPath);
        mailService.sendImgMail(to, subject, content, imgMap);
    }
}