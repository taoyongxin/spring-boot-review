package com.soft1851.springboot.taskschedule.repository;

import com.soft1851.springboot.taskschedule.model.Cron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tao
 * @version 1.0
 * @ClassName CronRepository
 * @Description TODO
 * @date 2020-05-15 20:13
 **/
public interface CronRepository extends JpaRepository<Cron,Integer> {
    /**
     * 根据cronId查询
     * @param cronId
     * @return
     */
    Cron findCronByCronIdEquals(int cronId);

    /**
     * 根据id修改cron
     * @param cron
     * @param id
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update test2.cron set cron = ?1 where cron_id = ?2",nativeQuery = true)
    void updateCron(String cron, int id);

}
