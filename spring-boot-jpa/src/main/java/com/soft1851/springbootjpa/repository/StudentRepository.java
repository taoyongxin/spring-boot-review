package com.soft1851.springbootjpa.repository;

import com.soft1851.springbootjpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName StudentRepository
 * @Description TODO
 * @date 2020-05-13 22:31
 **/
public interface StudentRepository extends JpaRepository<Student,Integer> {
    /**
     * 根据id查询数据
     * @param studentId
     * @return
     */
    Student findByStudentId(int studentId);

    /**
     * 按studentName和hometown相等查询唯一记录
     * @param studentName
     * @param hometown
     * @return
     */
    Student findByStudentNameEqualsAndHometownEquals(String studentName, String hometown);

    /**
     * 按studentName模糊查询一组记录
     * @param studentName
     * @return
     */
    List<Student> findStudentsByStudentNameLike(String studentName);


    /**
     * 自定义JPQL查询
     * @param studentId
     * @return
     */
    @Query("select s from Student s where s.studentId = ?1")
    Student findByStudentId(Integer studentId);

    /**
     * 按id修改studentName
     * @param studentName
     * @param studentId
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update test.student set student_name = ?1 where student_id=?2", nativeQuery = true)
    int updateStudentName(String studentName,Integer studentId);


    /**
     * 插入
     * @param studentName
     * @param hometown
     * @param clazzId
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = "insert into test.student(student_name,hometown,clazz_id) value (:studentName, :hometown, :clazzId)",nativeQuery = true)
    int insertStudent(@Param("studentName") String studentName, @Param("hometown") String hometown, @Param("clazzId") Integer clazzId);


    /**
     * 根据studentName查询数据
     * @param studentName
     * @param pageable
     * @return
     */
    @Query("select s from Student s where s.studentName = :studentName")
    Page<Student> findByStudentName(@Param("studentName") String studentName, Pageable pageable);


    /**
     *
     * 根据studentId删除学生
     * @param studentId
     */
    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
    @Modifying
    @Query("delete from Student where studentId = ?1")
    void deleteStudentByStudentId(Integer studentId);

    /**
     * 分页查询 根据班级id
     * @param clazzId
     * @param pageable
     * @return
     */
    Page<Student> findByClazzId(Integer clazzId, Pageable pageable);


}
