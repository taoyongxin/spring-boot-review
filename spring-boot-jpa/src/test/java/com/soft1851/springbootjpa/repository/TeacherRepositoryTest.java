package com.soft1851.springbootjpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
@SpringBootTest
class TeacherRepositoryTest {

    @Resource
    private TeacherRepository teacherRepository;

    @Test
    void findTeacherInfo() {
        List<TeacherInfo> teacherInfos = teacherRepository.findTeacherInfo(1);
        for (TeacherInfo teacherInfo:teacherInfos){
            System.out.println("teacherInfo:"+teacherInfo.getClazzName()+"-"+teacherInfo.getTeacherName()+
                    "-id:"+teacherInfo.getTeacherId());
        }
    }
}