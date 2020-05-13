package com.soft1851.springbootjpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Teacher
 * @Description TODO
 * @date 2020-05-13 21:23
 **/
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

    @Column(length = 128,nullable = true)
    private String teacherName;

    @Column(nullable = true)
    private Integer clazzId;



}
