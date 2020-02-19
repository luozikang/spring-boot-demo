package org.lzk.mybatis.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/7 19:40
 * @description:
 */
@Controller
public class ThymeleafController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("message", "http://www.ityouknow.com");
        return "hello";
    }
}
