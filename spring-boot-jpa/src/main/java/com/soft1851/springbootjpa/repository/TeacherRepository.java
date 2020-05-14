package com.soft1851.springbootjpa.repository;

import com.soft1851.springbootjpa.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tao
 */
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    Teacher findTeacherByIdEquals(int id);

//    /**
//     * 多表联查
//     * @param clazzId
//     * @return
//     */
//    @Query("select c.clazzName as clazzName ,t.teacherId as teacherId, t.teacherName as teacherName " +
//            "from Clazz c,Teacher t where c.teacherId = t.teacherId and c.clazzId = ?1")
//    List<TeacherInfo> findTeacherInfo(Integer clazzId);
}
