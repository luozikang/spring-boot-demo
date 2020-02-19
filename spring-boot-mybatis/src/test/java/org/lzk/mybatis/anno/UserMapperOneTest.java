package org.lzk.mybatis.anno;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzk.mybatis.common.UserParam;
import org.lzk.mybatis.dao.anno.UserMapper;
import org.lzk.mybatis.model.User;
import org.lzk.mybatis.model.UserSexEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * spring.profiles.active=xmlsignal
 */
public class UserMapperOneTest {
    @Autowired
    private UserMapper userMapper;


    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new User("aa111", "a123456", UserSexEnum.WOMAN));
    }

    @Test
    public void testGetAll() {
//        UserParam userParam = new UserParam();
//        userParam.setUserSex("WOMAN");
//        userParam.setUserName("aa111");
//        userParam.setCurrentPage(0);
        List<User> users= userMapper.getList();
        System.out.println(users);
    }


    @Test
    public void testGetUserByName() {
        User user  = userMapper.selectUserByNameNoPre("aa111");
        User user2 = userMapper.selectUserByNamePre("aa111");
        System.out.println(user);
        System.out.println(user2);
    }



    @Test
    public void testPage() {
        UserParam userParam=new UserParam();
        userParam.setUserSex("WOMAN");
        userParam.setUserName("aa111");
        userParam.setCurrentPage(0);
//        List<User> users=userMapper.getList(userParam);
//        long count=userMapper.getCount(userParam);
//        Page page = new Page(count,users);
//        System.out.println(page);
    }
}