package com.soft1851.springboot.taskschedule.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Demo2
 * @Description TODO
 * @date 2020-05-14 19:50
 **/
@Component
public class Demo2 {
    private DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");

    /**
     * fixedRate:固定频率执行  上一次开始执行时间点之后 3秒再执行。
     */
    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime() {
        System.out.println(Thread.currentThread().getName() + "现在时间： " + dft.format(LocalDateTime.now()));
    }

    /**
     * fixedDelay:固定延时 上一次执行完毕时间点之后 2秒再执行。
     */
    @Scheduled(fixedDelay = 2000)
    public void reportCurrentTime2() {
        System.out.println(Thread.currentThread().getName() + "现在时间： " + dft.format(LocalDateTime.now()));
    }

    /**
     * 第一次延迟3秒后执行，之后按fixedDelay的规则每2秒执行一次
//     */
    @Scheduled(initialDelay = 3000, fixedDelay = 2000)
    public void reportCurrentTime3() {
        System.out.println(Thread.currentThread().getName() + "现在时间： " + dft.format(LocalDateTime.now()));
    }

    /**
     * 通过cron表达式定义规则
     */
    @Scheduled(cron = "0/5 * * * * *")
    public void reportCurrentTime4() {
        System.out.println(Thread.currentThread().getName() + "现在时间： " + dft.format(LocalDateTime.now()));
    }

    @Scheduled(cron = "0 10 10 ? * 2")
    public void reportCurrentTime5() {
        System.out.println(Thread.currentThread().getName() + "现在时间： " + dft.format(LocalDateTime.now()));
    }
}
