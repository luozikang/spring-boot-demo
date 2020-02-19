package org.lzk.mybatis.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzk.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MulitUserRepositoryTest {
    @Autowired
    @Qualifier("mulitUserRepositoryImpl")
    private UserRepository userRepository;
    @Test
    public void testSave() {
        User user =new User("neo","123456",30);
        userRepository.save(user);
    }

}
