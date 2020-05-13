package com.soft1851.springbootjpa.repository;

import com.soft1851.springbootjpa.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Tao
 */
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    /**
     * 多表联查
     * @param clazzId
     * @return
     */
    @Query("select c.clazzName as clazzName ,t.teacherId as teacherId, t.teacherName as teacherName " +
            "from Clazz c,Teacher t where c.teacherId = t.teacherId and c.clazzId = ?1")
    List<TeacherInfo> findTeacherInfo(Integer clazzId);

}
