package com.soft1851.springboot.configuration.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SecuredServerController
 * @Description TODO
 * @date 2020-05-12 16:49
 **/
@RestController
@Slf4j
class SecuredServerController {

    @RequestMapping("/secured")
    public String secured() {
        log.info("Inside secured()");
        return "Hello user !!! : " + LocalDateTime.now();
    }
}