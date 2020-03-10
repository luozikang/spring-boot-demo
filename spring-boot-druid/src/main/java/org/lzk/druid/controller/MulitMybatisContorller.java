package org.lzk.druid.controller;

import org.lzk.druid.dao.one.UserMapper1;
import org.lzk.druid.dao.two.UserMapper2;
import org.lzk.druid.entity.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@ConditionalOnProperty(name = "active",prefix = "spring.profiles",havingValue="mybatisMulit")
@Controller
public class MulitMybatisContorller {
    @Resource
    UserMapper1 userMapper1;
    @Resource
    UserMapper2 userMapper2;

    @GetMapping("/users")
    @ResponseBody
    public List<User> users(){
        List<User> list = userMapper1.getList();
        list.addAll(userMapper2.getList());
        return list;
    }
}
