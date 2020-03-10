package org.lzk.jpa.dao.test2;

import org.lzk.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository2 extends JpaRepository<User,Long> {
    //jpa规范根据方法名生成查询语句
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);


    //jpa自定义查询语句

    /**
     * hql
     * @param pageable
     * @return
     */
    @Query("select u from User u")
    Page<User> findHqlAll(Pageable pageable);



    /**
     * sql
     * @param nickName
     * @param pageable
     * @return
     */
    @Query(value = "select * from user u where u.nick_name = ?1" ,nativeQuery = true)
    Page<User> findByNickName1(String nickName, Pageable pageable);

    @Query("select u from User u where u.nickName = :nickName")
    Page<User> findByNickName(@Param("nickName") String nickName, Pageable pageable);



    //分页查询

    /**
     * 包含数据总量，查询数据库两次
     * @param pageable
     * @return
     */
    Page<User> findAll(Pageable pageable);

    /**
     * 不含数据总量，查询数据库一次
     * @param nickName
     * @param email
     * @param pageable
     * @return
     */
    Slice<User> findByNickNameAndEmail(String nickName, String email, Pageable pageable);


    @Transactional(timeout = 10)
    @Modifying
    @Query("update User set userName = :userName where id = :id")
    int modifyById(@Param("userName") String userName, @Param("id") Long id);


    @Transactional
    @Modifying
    @Query("delete from User where id = :id")
    void deleteById(@Param("id") Long id);


    /**
     * 对应 entity中NamedQueries
     * @param passWord
     * @return
     */
    List<User> findByPassWord(String passWord);
    List<User> findByNickName(String nickName);


    /**
     * 限制查询
     * @return
     */
    User findFirstByOrderByLastnameAsc();

    User findTopByOrderByAgeDesc();

    Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);

    List<User> findFirst10ByLastname(String lastname, Sort sort);

    List<User> findTop10ByLastname(String lastname, Pageable pageable);

}

//
//    And	findByLastnameAndFirstname	… where x.lastname = ?1 and x.firstname = ?2
//        Or	findByLastnameOrFirstname	… where x.lastname = ?1 or x.firstname = ?2
//        Is，Equals	findByFirstnameIs，findByFirstnameEquals	… where x.firstname = ?1
//        Between	findByStartDateBetween	… where x.startDate between ?1 and ?2
//        LessThan	findByAgeLessThan	… where x.age < ?1
//        LessThanEqual	findByAgeLessThanEqual	… where x.age ⇐ ?1
//        GreaterThan	findByAgeGreaterThan	… where x.age > ?1
//        GreaterThanEqual	findByAgeGreaterThanEqual	… where x.age >= ?1
//        After	findByStartDateAfter	… where x.startDate > ?1
//        Before	findByStartDateBefore	… where x.startDate < ?1
//        IsNull	findByAgeIsNull	… where x.age is null
//        IsNotNull，NotNull	findByAge(Is)NotNull	… where x.age not null
//        Like	findByFirstnameLike	… where x.firstname like ?1
//        NotLike	findByFirstnameNotLike	… where x.firstname not like ?1
//        StartingWith	findByFirstnameStartingWith	… where x.firstname like ?1 (parameter bound with appended %)
//        EndingWith	findByFirstnameEndingWith	… where x.firstname like ?1 (parameter bound with prepended %)
//        Containing	findByFirstnameContaining	… where x.firstname like ?1 (parameter bound wrapped in %)
//        OrderBy	findByAgeOrderByLastnameDesc	… where x.age = ?1 order by x.lastname desc
//        Not	findByLastnameNot	… where x.lastname <> ?1
//        In	findByAgeIn(Collection ages)	… where x.age in ?1
//        NotIn	findByAgeNotIn(Collection age)	… where x.age not in ?1
//        TRUE	findByActiveTrue()	… where x.active = true
//        FALSE	findByActiveFalse()	… where x.active = false
//        IgnoreCase	findByFirstnameIgnoreCase	… where UPPER(x.firstame) = UPPER(?1)