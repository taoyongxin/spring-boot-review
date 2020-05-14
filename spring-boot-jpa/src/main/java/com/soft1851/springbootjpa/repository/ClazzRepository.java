package com.soft1851.springbootjpa.repository;

import com.soft1851.springbootjpa.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tao
 * @version 1.0
 * @ClassName ClazzRepository
 * @Description TODO
 * @date 2020-05-14 16:26
 **/
public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
    /**
     * 根据id查询班级
     *
     * @param id
     * @return
     */
    Clazz findClazzByIdEquals(int id);
}