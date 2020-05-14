package com.soft1851.springbootjpa.controller;

import com.soft1851.springbootjpa.model.Student;
import com.soft1851.springbootjpa.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName StudentController
 * @Description TODO
 * @date 2020-05-14 17:34
 **/
@RestController
@RequestMapping(value = "/api/student")
public class StudentController {
    @Resource
    private StudentRepository studentRepository;

    @GetMapping()
    public List<Student> getStudents(@RequestParam("clazzId") int id){
        return studentRepository.findByClazzId(id);

    }
}
