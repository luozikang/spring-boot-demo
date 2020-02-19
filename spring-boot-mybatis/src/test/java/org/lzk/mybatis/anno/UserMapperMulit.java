package org.lzk.mybatis.anno;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzk.mybatis.common.Page;
import org.lzk.mybatis.common.UserParam;
import org.lzk.mybatis.dao.anno.one.User1Mapper;
import org.lzk.mybatis.dao.anno.two.User2Mapper;
import org.lzk.mybatis.model.User;
import org.lzk.mybatis.model.UserSexEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * spring.profiles.active=xmlmulit
 */
public class UserMapperMulit {
    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;


    @Test
    public void testInsert() throws Exception {
        user1Mapper.insert(new User("aa111", "a123456", UserSexEnum.WOMAN));
        user2Mapper.insert(new User("aa111", "a123456", UserSexEnum.WOMAN));
    }


    @Test
    public void testPage() {
        UserParam userParam=new UserParam();
        userParam.setUserSex("WOMAN");
        userParam.setUserName("aa111");
        userParam.setCurrentPage(0);
        List<User> users=user1Mapper.getList2(userParam);
        long count=user1Mapper.getCount(userParam);
        Page page = new Page(count,users);
        System.out.println(page);
    }
}