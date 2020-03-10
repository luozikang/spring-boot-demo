package org.lzk.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzk.jpa.dao.test1.UserRepository1;
import org.lzk.jpa.dao.test2.UserRepository2;
import org.lzk.jpa.entity.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MulitJpaTest {

    @Resource
    private UserRepository1 userTest1Repository;
    @Resource
    private UserRepository2 userTest2Repository;

    @Test
    public void testSave() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userTest1Repository.save(new User("aa", "aa123456", "aa@126.com", "aa", formattedDate));
        userTest1Repository.save(new User("bb", "bb123456", "bb@126.com", "bb", formattedDate));
        userTest2Repository.save(new User("cc", "cc123456", "cc@126.com", "cc", formattedDate));
    }

    @Test
    public void testDelete() throws Exception {
        userTest1Repository.deleteAll();
        userTest2Repository.deleteAll();
    }

}
