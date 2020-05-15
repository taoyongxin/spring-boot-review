package com.soft1851.springboot.taskschedule.task;


import com.soft1851.springboot.taskschedule.service.MailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SchedulerTask
 * @Description 定时发送邮件
 * @Author Tao
 * @Date 2020/5/15
 **/
//@Component
public class SchedulerTask {
    private int count=0;
    String name="Tao_";
    @Resource
    private MailService mailService;
    @Resource
    private TemplateEngine templateEngine;
    /**
     * 每隔一分钟执行一次
     */
    @Scheduled(cron="*/30 * * * * ?")
    private void process(){
        System.out.println("发送了第"+(count++)+"封邮件");
        //创建邮件字段
        Context context = new Context();
        context.setVariable("siteTitle", name);
        context.setVariable("permalink", "");
        context.setVariable("title", "寄来的贺卡《生日快乐》");
        context.setVariable("author", "生日祝福语");
        context.setVariable("text", "你的开心我知道，我的烦恼你知道。你的愿望我知道，我的感动你知道。你的生日我知道，我的祝福你收到。让友谊为快乐开道，幸福平安将你围绕！");

        String to="1427177855@qq.com";
        String  subject=name+"寄来的贺卡《生日快乐》";
        // 将字段加载到页面模板中
        String emailContent = templateEngine.process("sendMail", context);
        // 添加附件
        String filePath = "F:\\我的\\5.图片\\avatar\\happy.png";
        Map<String, String> imgMap = new HashMap<>();
        //以键值对的形式存入
        imgMap.put("img01", filePath);
        try {
            mailService.sendImgMail(to,subject,emailContent, imgMap);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}