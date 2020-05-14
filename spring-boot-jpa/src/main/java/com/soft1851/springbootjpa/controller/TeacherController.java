package com.soft1851.springbootjpa.controller;

import com.soft1851.springbootjpa.model.Teacher;
import com.soft1851.springbootjpa.repository.TeacherRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName TeacherController
 * @Description TODO
 * @date 2020-05-14 17:43
 **/
@RestController
@RequestMapping(value = "/api/teacher")
public class TeacherController {
    @Resource
    private TeacherRepository teacherRepository;

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable int id){
        return teacherRepository.findTeacherByIdEquals(id);
    }
}
