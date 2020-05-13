package com.soft1851.springbootjpa.dao;


import com.soft1851.springbootjpa.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    void testSave() {
        Message message = Message.builder()
                .msgText("后端")
                .msgSummary("SpringMvc")
                .build();
        //保存单个对象
        messageRepository.save(message);

        List<Message> messages = new ArrayList<>(Arrays.asList(
                Message.builder()
                        .msgText("前端")
                        .msgSummary("Uniapp")
                        .build(),
                Message.builder()
                        .msgText("前端")
                        .msgSummary("Vuex")
                        .build(),
                Message.builder()
                        .msgText("软件1851")
                        .msgSummary("学习学习")
                        .build()
                ));
        //保存多个
        messageRepository.saveAll(messages);
    }

    /**
     * 根据摘要查询
     */
    @Test
    void findByMsgSummary() {
        List<Message> messageList = messageRepository.findByMsgSummary("沉迷学习");
        System.out.println(messageList);

    }

    /**
     * 根据内容或者摘要查询
     */
    @Test
    void findByMsgTextOrMsgSummary() {
        List<Message> messageList = messageRepository.findByMsgTextOrMsgSummary("移动端","沉迷学习");
        System.out.println(messageList);
    }

    /**
     * 根据text查询
     */
    @Test
    void findByMsgTextLike() {
        List<Message> messageList = messageRepository.findByMsgTextLike("软件1851");
        System.out.println(messageList);
    }

    /**
     * 查询比指定id小的数据的集合
     */
    @Test
    void findDistinctByMsgIdLessThan() {
        List<Message> messageList = messageRepository.findDistinctByMsgIdLessThan(3);
        System.out.println(messageList);
    }


    @Test
    void findByMsgTextAndMsgSummary() {
        List<Message> messageList = messageRepository.findByMsgTextAndMsgSummary("软件1851","沉迷学习");
        System.out.println(messageList);
    }

    @Test
    void messageRepository() {
        List<Message> messageList = messageRepository.findByMsgIdBetween(1,3);
        System.out.println(messageList);
    }

    @Test
    void findDistinctByMsgIdGreaterThan() {
        List<Message> messageList = messageRepository.findDistinctByMsgIdGreaterThan(2);
        System.out.println(messageList);
    }

    @Test
    void countByMsgText() {
        System.out.println(messageRepository.countByMsgText("前端"));
    }

    @Test
    void findByMsgTextIgnoreCase() {
        List<Message> messageList = messageRepository.findByMsgTextIgnoreCase("aaa");
        System.out.println(messageList);
    }

    @Test
    void findByMsgTextOrderByMsgTextDesc() {
        List<Message> messageList = messageRepository.findByMsgTextOrderByMsgTextDesc("后端");
        System.out.println(messageList);
    }

    @Test
    void findByMsgTextNotLike() {
        List<Message> messageList = messageRepository.findByMsgTextNotLike("后端");
        System.out.println(messageList);
    }


}