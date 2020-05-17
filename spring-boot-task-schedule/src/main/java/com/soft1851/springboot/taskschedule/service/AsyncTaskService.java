package com.soft1851.springboot.taskschedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Tao
 */
@Service
@Slf4j
public class AsyncTaskService {
    @Async
    public void asyncTask(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("处理数据中");
    }
}
