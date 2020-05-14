package com.soft1851.springbootjpa.model;

import lombok.Data;

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
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "teacher_name", nullable = false, length = 30)
    private String teacherName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clazz_id", referencedColumnName = "id")
    private Clazz clazz;
}
