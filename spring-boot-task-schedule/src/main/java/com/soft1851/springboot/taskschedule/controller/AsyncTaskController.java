package com.soft1851.springboot.taskschedule.controller;

import com.soft1851.springboot.taskschedule.service.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName AsyncTaskController
 * @Description TODO
 * @date 2020-05-16 18:55
 **/
@RestController
@Slf4j
public class AsyncTaskController {
    @Resource
    private AsyncTaskService asyncTaskService;

    @RequestMapping("/asyncTask")
    public String asyncTask(){
        log.info("========启动========");
        asyncTaskService.asyncTask();
        log.info("========结束========");
        return "测试异步任务";
    }
}
