package com.soft1851.springbootjpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Tao
 * @version 1.0
 * @ClassName CourseStudent
 * @Description TODO
 * @date 2020-05-13 21:20
 **/
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer courseId;

    @Column(nullable = false)
    private Integer studentId;
}
