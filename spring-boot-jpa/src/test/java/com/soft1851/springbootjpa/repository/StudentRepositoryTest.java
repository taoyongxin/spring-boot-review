package com.soft1851.springbootjpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest
class StudentRepositoryTest {

    @Resource
    private StudentRepository studentRepository;

    @Test
    void findByStudentId() {
//        Student student = studentRepository.findByStudentId(1001);
//        System.out.println(student);
    }
}