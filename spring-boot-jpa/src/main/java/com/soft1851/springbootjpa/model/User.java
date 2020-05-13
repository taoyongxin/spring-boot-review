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
 * @ClassName User
 * @Description
 * unique唯一约束 四种主键生成策略：
 * TABLE, //使用一个额外的数据库表来保存主键
 * SEQUENCE,//使用序列的方式，且其底层数据库要支持序列，一般有postgres、Oracle等
 * IDENTITY,//主键由数据库生成，一般为自增型主键，支持的有MySql和Sql Server
 * AUTO//由程序来决定主键规则
 * @date 2020-05-13 15:12
 **/
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * 除了使用 @Query 注解外，还可以预先定义好一些查询，并为其命名，然后在Repository 中添加相同命名的方法。
 * 通过 @NamedQueries 注解可以定义多个命名 Query，@NamedQuery 的 name 属性定义了 Query 的名称，
 * 注意加上 Entity 名称 . 作为前缀，query 属性定义查询语句。
 */
@NamedQueries({
        @NamedQuery(name = "User.findByPassword",query = "select u from User u where u.password = ?1"),
        @NamedQuery(name = "User.findByNickName",query = "select u from User u where u.nickName = ?1")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * nullable = false为非空约束，unique = true是唯一约束
     */
    @Column(nullable = false,unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(length = 32)
    private String nickName;

    @Column
    private Integer age;

    @Column
    private LocalDateTime regTime;
}
