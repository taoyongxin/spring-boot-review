package com.soft1851.springbootjpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Clazz
 * @Description TODO
 * @date 2020-05-13 21:11
 **/
@Entity
@Data
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "clazz_name", nullable = false, length = 20)
    private String clazzName;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "clazz_id")
    private List<Student> studentList;
}
