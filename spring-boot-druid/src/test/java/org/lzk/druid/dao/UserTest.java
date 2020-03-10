package org.lzk.druid.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzk.druid.dao.signal.UserMapper;
import org.lzk.druid.entity.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Resource
    UserMapper userMapper;

    @Test
    public void testGetAllUsers() {
        List<User> list =userMapper.getList();
        System.out.println(list);

    }
}
