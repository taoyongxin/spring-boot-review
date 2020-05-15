package com.soft1851.springboot.taskschedule.task;

import com.soft1851.springboot.taskschedule.model.User;
import com.soft1851.springboot.taskschedule.repository.UserRepository;
import com.soft1851.springboot.taskschedule.service.MailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tao
 * @version 1.0
 * @ClassName MailTask
 * @Description TODO
 * @date 2020-05-15 16:20
 **/
//@Component
public class MailTask {
//    private int count = 0;

    @Resource
    private MailService mailService;
    @Resource
    private UserRepository userRepository;


    String name="Tao_";

    @Resource
    private TemplateEngine templateEngine;

    @Scheduled(cron = "0 04 22 * * ?")
    private void process(){
        List<User> userList = userRepository.findUsersByBirthday();
        for (User user:userList){
            System.out.println("发送了给"+(user.getUsername())+"一封邮件");

//            String to = user.getMail();
//            String subject = user.getUsername()+",生日快乐！";
//            String content = "<h3>测试定时邮箱</h3>";
//            mailService.sendSimpleTextMail(to, subject, content);

            Context context = new Context();
            context.setVariable("siteTitle", name);
            context.setVariable("permalink", "");
            context.setVariable("title", "寄来的贺卡《生日快乐》");
            context.setVariable("author", "生日祝福语");
            context.setVariable("text", "你的开心我知道，我的烦恼你知道。你的愿望我知道，我的感动你知道。你的生日我知道，我的祝福你收到。让友谊为快乐开道，幸福平安将你围绕！");

            String to=user.getMail();
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
}
