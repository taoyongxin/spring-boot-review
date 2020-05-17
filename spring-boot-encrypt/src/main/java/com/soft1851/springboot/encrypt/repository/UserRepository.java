package com.soft1851.springboot.encrypt.repository;

import com.soft1851.springboot.encrypt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName UserRepository
 * @Description TODO
 * @date 2020-05-16 22:22
 **/
public interface UserRepository  extends JpaRepository<User,Integer> {

    /**
     * 根据密码查询
     * @param password
     * @return
     */
    List<User> findByPassword(String password);
}