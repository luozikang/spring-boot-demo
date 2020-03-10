package org.lzk.druid.controller;

import org.lzk.druid.dao.signal.UserMapper;
import org.lzk.druid.entity.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@ConditionalOnProperty(name = "active",prefix = "spring.profiles",havingValue="mybatisSignal")
@Controller
public class HelloWorld {
    @Resource
    UserMapper userMapper;

    @GetMapping("/users")
    @ResponseBody
    public List<User> users(){
        return userMapper.getList();
    }
}
