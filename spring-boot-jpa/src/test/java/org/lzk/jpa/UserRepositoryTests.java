package org.lzk.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzk.jpa.dao.test.UserRepository;
import org.lzk.jpa.entity.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Resource
    private UserRepository userRepository;

    @Test
    public void test()  {
//        SharedEntityManagerCreator
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

//        userRepository.save(new User("aa","aa@126.com","aa","aa123456",formattedDate));
//        userRepository.save(new User("bb","bb@126.com","bb","bb123456",formattedDate));
//        userRepository.save(new User("cc","cc@126.com","cc","cc123456",formattedDate));
        List<User> all = userRepository.findAll();
        System.out.println(all.size());
//        int size = (int) all;
        Assert.isTrue(3==userRepository.findAll().size(),"list size = 9");
//        Assert.isTrue("bb".equals(userRepository.findByUserNameOrEmail("bb","cc@126.com").getNickName()),"list size = 9");

//        userRepository.delete(userRepository.findByUserName("aa1"));
    }

    @Test
    public void testPageQuery()  {
        int page=1,size=2;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<User> all = userRepository.findAll(pageable);
        System.out.println(all);

        Page<User> aa = userRepository.findByNickName("aa", pageable);
        System.out.println(aa);
    }

}