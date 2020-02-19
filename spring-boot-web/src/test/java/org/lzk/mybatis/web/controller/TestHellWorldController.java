package org.lzk.mybatis.web.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/5 15:04
 * @description:
 */

@SpringBootTest
public class TestHellWorldController {


    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.
                standaloneSetup(new HelloWorldController()).
                build();
    }

    @Test
    public void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello?name=小明").accept(MediaType.APPLICATION_JSON_UTF8)).
                andDo(print());
    }
    @Test
    public void getHello2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello?name=小明")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("小红")));
    }
}
