package com.soft1851.springboot.taskschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Tao
 */
@SpringBootApplication
@EnableScheduling
public class SpringBootTaskScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTaskScheduleApplication.class, args);
    }

}
