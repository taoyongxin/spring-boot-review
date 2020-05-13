package com.soft1851.springbootjpa.service;

import com.soft1851.springbootjpa.dto.UserDetailParam;
import com.soft1851.springbootjpa.model.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class UserDetailServiceTest {
    @Resource
    private UserDetailService userDetailService;
    @Test
    void findByCondition() {
        int page=0,size=10;
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
        UserDetailParam param=new UserDetailParam();
        param.setIntroduction("程序员");
        param.setMinAge(10);
        param.setMaxAge(30);
        Page<UserDetail> page1=userDetailService.findByCondition(param,pageable);
        for (UserDetail userDetail:page1){
            System.out.println("userDetail: "+userDetail.toString());
        }
    }
}