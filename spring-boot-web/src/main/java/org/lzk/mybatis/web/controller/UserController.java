package org.lzk.mybatis.web.controller;

import org.lzk.mybatis.web.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/6 23:21
 * @description:
 */
@RestController
public class UserController {
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public User getUser(){
        User user = new User();
        user.setAge(10);
        user.setUserName("lzk");
        return user;
    }
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public List<User> getUsers(){
        User user = new User();
        user.setAge(10);
        user.setUserName("lzk");
        return Arrays.asList(user);
    }

    @RequestMapping(name="/addUser", method= RequestMethod.POST)
    public String addUser(User user) {
        return user.toString();
    }

    @RequestMapping(value="/param/{param}", method= RequestMethod.GET)
    public String param(@PathVariable(value = "param") String name) {
        return name;
    }



}
