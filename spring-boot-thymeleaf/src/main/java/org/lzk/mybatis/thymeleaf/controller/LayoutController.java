package org.lzk.mybatis.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/7 21:41
 * @description:
 */
@Controller

public class LayoutController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/fragment")
    public String fragment() {
        return "fragment";
    }
    @RequestMapping("/layout")
    public String layout() {
        return "layout";
    }


    @RequestMapping("/home")
    public String home() {
        return "home";
    }
    @RequestMapping("static/{html}")
    public String html(@PathVariable String html){
        return "layout/"+html;
    }
}
