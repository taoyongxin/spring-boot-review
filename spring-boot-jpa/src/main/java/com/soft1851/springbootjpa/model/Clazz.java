package com.soft1851.springbootjpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Clazz
 * @Description TODO
 * @date 2020-05-13 21:11
 **/
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clazzId;

    @Column(length = 128,nullable = true)
    private String clazzName;

    @Column(nullable = true)
    private Integer teacherId;
//
//    @OneToMany(mappedBy = "clazz",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private List<Student> studentList;
}
