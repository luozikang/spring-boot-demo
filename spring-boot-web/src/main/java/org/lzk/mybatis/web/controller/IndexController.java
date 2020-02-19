package org.lzk.mybatis.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/15 16:00
 * @description:
 */
@Controller
public class IndexController {
    @RequestMapping("/path/{path}")
    public String path(@PathVariable("path") String path){

        return path;
    }
}
