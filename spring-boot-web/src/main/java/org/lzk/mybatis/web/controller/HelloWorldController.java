package org.lzk.mybatis.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/5 14:39
 * @description:
 */
@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(String name ){
        return "hello world "+name;
    }


}
