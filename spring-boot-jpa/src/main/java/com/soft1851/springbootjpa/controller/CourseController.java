package com.soft1851.springbootjpa.controller;

import com.soft1851.springbootjpa.model.Course;
import com.soft1851.springbootjpa.repository.CourseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName CourseController
 * @Description TODO
 * @date 2020-05-14 17:31
 **/
@RestController
@RequestMapping(value = "/api/course")
public class CourseController {
    @Resource
    private CourseRepository courseRepository;

    @GetMapping()
    public Course findCourse(@RequestParam("courseName") String courseName){
        return courseRepository.findCourseByCourseName(courseName);
    }
}
