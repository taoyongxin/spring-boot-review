package com.soft1851.springboot.taskschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * 当启动主类不配置开启异步注解@EnableAsync的时候，
 * 浏览器访问请求，需要等待 5s 才会返回结果。当我们开启异步的时候，
 * 浏览器立马显示结果，让调用的 service 方法去异步执行，
 * 控制台等待 5s 显示处理数据中。
 * @author Tao
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync

public class SpringBootTaskScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTaskScheduleApplication.class, args);
    }

}
