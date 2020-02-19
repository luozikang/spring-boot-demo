package org.lzk.mybatis.web.controller;

import org.lzk.mybatis.web.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/7 15:53
 * @description:
 */
@RestController
@RequestMapping("/hibernate")
public class HibernateValidateController {
    @PostMapping(value = "/hello")
    public User hello(@Valid  User user, BindingResult result){
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode()+ "-" + error.getDefaultMessage());
            }
        }else{
            user= new User();
        }
        return user;
    }
}
