package com.soft1851.springbootjpa.repository;

import com.soft1851.springbootjpa.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Resource
    private UserRepository userRepository;

    @Test
    void insertUser() {
        User user = User.builder()
                .userName("aaa")
                .email("1427177855@qq.com")
                .password("888888")
                .nickName("Tao")
                .age(20)
                .regTime(LocalDateTime.now())
                .build();
        userRepository.save(user);

        List<User> userList = new ArrayList<>();
        for (int i = 1; i <= 20 ;i++){
            User user1 = User.builder()
                    .userName("user"+i)
                    .email("user"+i+"@126.com")
                    .password("888666")
                    .nickName("nickName"+i)
                    .age(new Random().nextInt(50))
                    .regTime(LocalDateTime.now())
                    .build();
            userList.add(user1);
        }
        userRepository.saveAll(userList);
        assertEquals(21,userRepository.findAll().size());
    }

    @Test
    void testSearch() {
        //昵称中含有“nick”的人数
        assertEquals(20,userRepository.findUsersByNickNameLike("%nick%").size());
        User user = userRepository.findByUserNameEqualsAndPasswordEquals("aaa","888888");
        System.out.println(user);
        //查询userName为"aaa'，密码为"888888"的用户
        assertNotNull(userRepository.findByUserNameEqualsAndPasswordEquals("aaa","888888"));
        //查询年龄大于20的所有用户
        log.info(String.valueOf(userRepository.findUsersByAgeGreaterThan(20).size()));
        //自定义的JPQL查询，根据id查询
        assertEquals("aaa",userRepository.findById(1L).getUserName());
    }

    @Test
    void testUpdate() {
        User user = User.builder()
                .id(1L)
                .userName("aaa修改")
                .email("1427177855@126.com")
                .password("999999")
                .nickName("aaa修改昵称")
                .age(12)
                .regTime(LocalDateTime.now())
                .build();
        userRepository.saveAndFlush(user);

        //可以自定义SQL实现更新
        int n = userRepository.updateNickName("新的昵称",1L);
        assertEquals(1,n);
    }

    @Test
    void testInsert() {
        int n = userRepository.insertUser("newUserName","1234567890","1555555@qq.com");
        assertEquals(1,n);
    }

    @Test
    void testDelete() {
        //自带删除方法
        userRepository.deleteById(3L);
    }


    @Test
    void testSelect() {
        // 查询所有
//        userRepository.findAll().forEach(user -> log.info(user.toString()));
        // 分页查询全部，返回封装了的分页信息， jpa页码从0开始
        Page<User> pageInfo = userRepository.findAll(
                PageRequest.of(1,3, Sort.Direction.ASC,"id"));
        log.info("总记录数: {}",pageInfo.getTotalElements());
        log.info("当前页记录数: {}",pageInfo.getNumberOfElements());
        log.info("每页记录数: {}",pageInfo.getSize());
        log.info("获取总页数: {}",pageInfo.getTotalPages());
        log.info("查询结果: {}",pageInfo.getContent());
        log.info("当前页（从0开始计）: {}",pageInfo.getNumber());
        log.info("是否为首页: {}",pageInfo.isFirst());
        log.info("是否为尾页: {}",pageInfo.isLast());
        // 条件查询
        User user = User.builder()
                .userName("user1")
                .build();
        List<User> users = userRepository.findAll(Example.of(user));
        log.info("满足条件的记录有：");
        users.forEach(user1 -> log.info(user1.toString()));

        //单个查询
        User user1 = User.builder()
                .id(2L)
                .build();
        Optional<User> optionalUser = userRepository.findOne(Example.of(user1));
        log.info("单个查询结果: {}",optionalUser.orElse(null));
    }

    /**
     * 测试已命名的查询 使用password查询数据
     */
    @Test
    void findByPassword() {
        List<User> userList = userRepository.findByPassword("999999");
        System.out.println(userList);
    }


    /**
     * 测试查询所有分页查询
     * Sort，控制分页数据的排序，可以选择升序和降序。
     * PageRequest，控制分页的辅助类，可以设置页码、每页的数据条数、排序等。
     */
    @Test
    void findALL() {
        int page = 1,size = 2;
        Pageable pageable = PageRequest.of(page,size,Sort.Direction.DESC,"id");
        Page<User> userList = userRepository.findAll(pageable);
        Page<User> userByNickNameList = userRepository.findByNickName("nickName1",pageable);
        System.out.println(userByNickNameList.getContent());
        System.out.println(userList.getContent());
    }

    @Test
    void findFirstByOrderByUserNameAsc() {
        User user = userRepository.findFirstByOrderByUserNameAsc();
        System.out.println(user);
    }

    @Test
    void findTopByOrderByAgeDesc() {
        User user = userRepository.findTopByOrderByAgeDesc();
        System.out.println(user);
    }

    @Test
    void getNumberOfElements() {
        int page = 1,size = 2;
        Pageable pageable = PageRequest.of(page,size,Sort.Direction.DESC,"id");
        Page<User> userPage = userRepository.queryFirst10ByNickName("nickName1",pageable);
        System.out.println(userPage.getNumberOfElements());
    }

    @Test
    void findTop10ByNickName() {
        int page = 1,size = 2;
        Pageable pageable = PageRequest.of(page,size,Sort.Direction.DESC,"id");
        List<User> userList = userRepository.findTop10ByNickName("nickName1",pageable);
        System.out.println(userList);
    }
}