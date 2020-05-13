package com.soft1851.springbootjpa.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Message
 * @Description TODO
 * @date 2020-05-12 20:54
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer msgId;

    @Column(nullable = false)
    private String msgText;

    @Column(nullable = true,length = 32)
    private String msgSummary;
}
