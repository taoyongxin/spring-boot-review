package com.soft1851.springbootjpa.repository;

import com.soft1851.springbootjpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tao
 */
public interface CourseRepository extends JpaRepository<Course, Integer> {
    /**
     * 根据课程名称查询
     *
     * @param courseName
     * @return
     */
    Course findCourseByCourseName(String courseName);
}