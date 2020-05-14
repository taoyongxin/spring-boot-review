package com.soft1851.springboot.taskschedule.task;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Demo1
 * @Description TODO
 * @date 2020-05-14 19:48
 **/
//@Component
public class Demo1 {
    private int count = 0;

    @Scheduled(cron = "*/5 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task running " + (count++));
    }
}
