package com.soft1851.springboot.encrypt.repository;

import com.soft1851.springboot.encrypt.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
@SpringBootTest
class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;
    @Test
    void findByPassword() {
        List<User> userList = userRepository.findByPassword("111");
        System.out.println(userList);
    }
}