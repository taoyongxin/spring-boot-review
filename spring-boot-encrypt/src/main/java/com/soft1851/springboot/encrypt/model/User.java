package com.soft1851.springboot.encrypt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Tao
 * @version 1.0
 * @ClassName User
 * @Description TODO
 * @date 2020-05-16 22:21
 **/
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "birthday",nullable = false)
    private LocalDateTime birthday;

    @Column(name = "mail",nullable = false)
    private String mail;
}