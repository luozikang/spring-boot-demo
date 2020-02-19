package org.lzk.mybatis.service;

import org.lzk.mybatis.dao.UserRepository;
import org.lzk.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * 测试注入多数据源
 */
@Repository
public class MulitUserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate primaryJdbcTemplate;

    @Autowired
    private JdbcTemplate secondaryJdbcTemplate;



    @Override
    public int save(User user) {
        int update = mulitSave(user);
        return update;
    }

    private int mulitSave(User user) {
        int update = secondaryJdbcTemplate.update("INSERT INTO users(name, password, age) values(?, ?, ?)",
                user.getName(), user.getPassword(), user.getAge());
        return primaryJdbcTemplate.update("INSERT INTO users(name, password, age) values(?, ?, ?)",
                user.getName(), user.getPassword(), user.getAge())+update;

    }


    @Override
    public int update(User user) {
        return 1;
    }

    @Override
    public int delete(long id) {
        return 1;
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public List<User> findALL() {
        return Collections.emptyList();
        // return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper(User.class));
    }

    static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setAge(rs.getInt("age"));
            return user;
        }
    }
}