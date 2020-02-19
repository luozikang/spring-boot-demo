package org.lzk.mybatis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzk.mybatis.dao.UserMapper;
import org.lzk.mybatis.common.Page;
import org.lzk.mybatis.common.UserParam;
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
    public void testPage() {
        UserParam userParam=new UserParam();
        userParam.setUserSex("WOMAN");
        userParam.setUserName("aa111");
        userParam.setCurrentPage(0);
        List<User> users=userMapper.getList(userParam);
        long count=userMapper.getCount(userParam);
        Page page = new Page(count,users);
        System.out.println(page);
    }
}