package com.soft1851.springbootjpa.repository;

import com.soft1851.springbootjpa.model.Clazz;
import com.soft1851.springbootjpa.model.Course;
import com.soft1851.springbootjpa.model.Student;
import com.soft1851.springbootjpa.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ClazzRepositoryTest {

    @Resource
    private TeacherRepository teacherRepository;
    @Resource
    private ClazzRepository clazzRepository;
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private CourseRepository courseRepository;

    @Test
    void testOneToOne() {
        List<Teacher> teachers = teacherRepository.findAll();
        teachers.forEach(System.out::println);
    }

    @Test
    void testOneToMany() {
//        恶汉模式
        Clazz clazz = clazzRepository.findClazzByIdEquals(2);
        System.out.println(clazz);

//        懒汉模式
//        List<Student> students = studentRepository.findByClazzId(1);
//        Clazz clazz = clazzRepository.findClazzByIdEquals(1);
//        clazz.setStudentList(students);
//        System.out.println(clazz);
    }

    @Test
    void testManyToMany() {
        List<Student> students = studentRepository.findByClazzId(2);
        students.forEach(student -> {
            System.out.println(student.getId() + "," + student.getStudentName() + "," + student.getAge());
            List<Course> courseList = student.getCourseList();
            courseList.forEach(course -> {
                System.out.println(course.getId() + "," + course.getCourseName());
            });
        });

//        Course course = courseRepository.findCourseByCourseName("Springboot");
//        System.out.println(course);
    }
}