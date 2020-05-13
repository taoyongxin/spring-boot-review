package com.soft1851.springbootjpa.repository;

import com.soft1851.springbootjpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName UserRepository
 * @Description TODO
 * @date 2020-05-13 15:29
 **/
public interface UserRepository extends JpaRepository<User,Long> , JpaSpecificationExecutor<User> {
    /**
     * 按userName和password相等查询唯一记录
     * @param userName
     * @param password
     * @return
     */
    User findByUserNameEqualsAndPasswordEquals(String userName,String password);

    /**
     * 按nickName模糊查询一组记录
     * @param nickName
     * @return
     */
    List<User> findUsersByNickNameLike(String nickName);

    /**
     * 查询年龄大于指定age的所有用户
     * @param age
     * @return
     */
    List<User> findUsersByAgeGreaterThan(int age);

    /**
     * 自定义JPQL查询，类似 Hibernate的 HQL语法，在接口上使用 @Query
     * @param id
     * @return
     */
    @Query("select u from User u where u.id = ?1")
    User findById(long id);


    /**
     * 按id修改nickName
     * @param nickName
     * @param id
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update test.user set nick_name = ?1 where id=?2", nativeQuery = true)
    int updateNickName(String nickName,long id);

    /**
     * 插入
     * @param userName
     * @param password
     * @param email
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = "insert into test.user(user_name,password,email) value (:userName, :password, :email)",nativeQuery = true)
    int insertUser(@Param("userName") String userName,@Param("password") String password,@Param("email") String email);

//    /**
//     * 当然如果感觉使用原生 SQL 更习惯，它也是支持的，需要再添加一个参数 nativeQuery = true。
//     * @param nickName
//     * @param pageable
//     * @return
//     */
//    @Query(value = "select * from test.user u where u.nick_name = ?1", nativeQuery = true)
//    Page<User> findByNickName(String nickName,Pageable pageable);

    /**
     * 根据nickName查询数据
     * 上面的 1 代表的是方法参数里面的顺序，如果有多个参数也可以按照这个方式添加
     *  1、2、3….。除了按照这种方式传参外，还可以使用 @Param 来支持。
     * @param nickName
     * @param pageable
     * @return
     */
    @Query("select u from User u where u.nickName = :nickName")
    Page<User> findByNickName(@Param("nickName") String nickName,Pageable pageable);

    /**
     * 根据id修改userName
     * 涉及到删除和修改需要加上 @Modifying
     * 也可以根据需要添加 @Transactional 对事务的支持、操作超时设置等
     * @param userName
     * @param id
     * @return
     */
    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
    @Modifying
    @Query("update User set userName = ?1 where id = ?2")
    int modifyById(String userName,Long id);

    /**
     * 根据id删除用户
     * @param id
     */
    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteUserById(Long id);

    /**
     * 根据password查询数据
     * 使用已命名的查询 定义对应的方法
     * @param password
     * @return
     */
    List<User> findByPassword(String password);

    /**
     * 根据nickName查询数据
     * 使用已命名的查询 定义对应的方法
     * @param nickName
     * @return
     */
    List<User> findByNickName(String nickName);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    @Query("select u from User u")
    Page<User> findALL(Pageable pageable);

    /**
     * 在查询的方法中，需要传入参数 Pageable，当查询中有多个参数的时候 Pageable 建议作为最后一个参数传入
     * Pageable 是 Spring 封装的分页实现类，使用的时候需要传入页数、每页条数和排序规则，
     * Page 是 Spring 封装的分页对象，封装了总页数、分页数据等。返回对象除使用 Page 外，还可以使用 Slice 作为返回值。
     * @param nickName
     * @param email
     * @param pageable
     * @return
     */
    Page<User> findByNickNameAndEmail(String nickName,String email,Pageable pageable);

    //限制查询*******************

    /**
     * 按照升序 查询第一个元素
     * @return
     */
    User findFirstByOrderByUserNameAsc();

    /**
     * 按照降序 查询年龄最大的
     * @return
     */
    User findTopByOrderByAgeDesc();

    /**
     * 查看 前十条数据
     * @param nickName
     * @param pageable
     * @return
     */
    Page<User> queryFirst10ByNickName(String nickName,Pageable pageable);

    /**
     * 查看 前十条数据
     * @param nickName
     * @param pageable
     * @return
     */
    List<User> findTop10ByNickName(String nickName,Pageable pageable);

    //复杂查询**************************************

}
