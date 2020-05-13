package com.soft1851.springbootjpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Student
 * @Description TODO
 * @date 2020-05-13 21:21
 **/
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(nullable = false)
    private Integer clazzId;

    @Column(length = 128,nullable = true)
    private String studentName;

    @Column(length = 128,nullable = true)
    private String hometown;

    @Column
    private LocalDateTime birthday;

//    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
//    @JoinColumn(name = "clazz_id")
//    private Clazz clazz;
}
