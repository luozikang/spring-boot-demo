package org.lzk.druid.dao.one;

import org.apache.ibatis.annotations.*;
import org.lzk.druid.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper1 {
    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

    @Select("SELECT * FROM users WHERE user_sex = #{user_sex}")
    List<User> getListByUserSex(@Param("user_sex") String userSex);


    @Select("SELECT * FROM users WHERE username=#{username} AND user_sex = #{user_sex}")
    List<User> getListByNameAndSex(Map<String, Object> map);


    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(User user);


//    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
//    void update(User user);

    @Update("<script>"+
            "update users"+
            "<set>"+
            "<if test='userName != null'>userName=#{userName},</if>"+
            "<if test='nickName != null'>nick_name=#{nickName},</if>"+
            "</set>"+
            "where id=#{id}"+
            "</script>")
            void update(User user);


    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex",  column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    List<User> getList();




    // This example creates a prepared statement, something like select * from teacher where name = ?;
    @Select("Select * from users where userName = #{name} limit 1")
    User selectUserByNamePre(@Param("name") String name);

    // This example creates n inlined statement, something like select * from teacher where name = 'someName';
    @Select("Select * from users where userName = '${name}' limit 1")
    User selectUserByNameNoPre(@Param("name") String name);







}
