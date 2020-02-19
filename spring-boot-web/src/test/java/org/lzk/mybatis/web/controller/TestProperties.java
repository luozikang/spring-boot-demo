package org.lzk.mybatis.web.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzk.mybatis.web.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/7 16:37
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProperties {
    /**
     * configurationProperties 作用在本初始化后调用对应bean的set方法，注入属性
     */

    @Value("${lzk.title}")
    private String title;
    @Autowired
    private UserConfig userConfig;

    @Test
    public void testSingle() {
        System.out.println(title);
        System.out.println(userConfig);
        Assert.assertEquals(title,"纯洁的微笑");
    }
}
