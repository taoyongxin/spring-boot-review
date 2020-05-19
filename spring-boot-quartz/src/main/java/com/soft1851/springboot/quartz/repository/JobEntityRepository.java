package com.soft1851.springboot.quartz.repository;

import com.soft1851.springboot.quartz.model.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yujie_Zhao
 * @ClassName JobEntityRepository
 * @Description Job实体接口
 * @Date 2020/5/18  22:07
 * @Version 1.0
 **/
public interface JobEntityRepository extends JpaRepository<JobEntity, Integer> {

    /**
     * 根据id获取Job
     *
     * @param id
     * @return
     */
    JobEntity getById(Integer id);

}
