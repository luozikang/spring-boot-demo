package org.lzk.mybatis.dao.anno.two;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.lzk.mybatis.common.UserParam;
import org.lzk.mybatis.dao.anno.one.User1Mapper;
import org.lzk.mybatis.model.User;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

public interface User2Mapper {
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


    @SelectProvider(type = UserSql.class, method = "getList")
    List<User> getList2(UserParam userParam);


    @SelectProvider(type = User1Mapper.UserSql.class, method = "getCount")
    long getCount(UserParam userParam);


    static class UserSql {
        public String getList(UserParam userParam) {
            StringBuffer sql = new StringBuffer("select id, userName, passWord, user_sex as userSex, nick_name as nickName");
            sql.append(" from users where 1=1 ");
            if (userParam != null) {
                if (!StringUtils.isEmpty(userParam.getUserName())) {
                    sql.append(" and userName = #{userName}");
                }
                if (!StringUtils.isEmpty(userParam.getUserSex())) {
                    sql.append(" and user_sex = #{userSex}");
                }
            }
            sql.append(" order by id desc");
            sql.append(" limit " + userParam.getBeginLine() + "," + userParam.getPageSize());
            return sql.toString();
        }
        public String getCount(UserParam userParam) {
            String sql= new SQL(){{
                SELECT("count(1)");
                FROM("users");
                if (!StringUtils.isEmpty(userParam.getUserName())) {
                    WHERE("userName = #{userName}");
                }
                if (!StringUtils.isEmpty(userParam.getUserSex())) {
                    WHERE("user_sex = #{userSex}");
                }
                //从这个 toString 可以看出，其内部使用高效的 StringBuilder 实现 SQL 拼接
            }}.toString();


            return sql;
        }
    }

}
