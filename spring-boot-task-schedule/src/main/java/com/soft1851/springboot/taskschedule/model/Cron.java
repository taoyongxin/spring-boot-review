package com.soft1851.springboot.taskschedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Cron
 * @Description TODO
 * @date 2020-05-15 20:07
 **/
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cronId;

    @Column(name = "cron_name",nullable = false,length = 30)
    private String cronName;

    @Column(name = "cron",nullable = false,length = 50)
    private String cron;
}
