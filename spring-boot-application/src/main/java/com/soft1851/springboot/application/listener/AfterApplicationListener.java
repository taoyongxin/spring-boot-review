package com.soft1851.springboot.application.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;

/**
 * @author Tao
 * @version 1.0
 * @ClassName AfterApplicationListener
 * @Description
 * @date 2020-05-12 20:11
 **/
@Order()
@Slf4j
public class AfterApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("After Hello World: " + event.getApplicationContext().getId() + ",timestamp: " + event.getTimestamp());
    }
}