package org.lzk.mybatis.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/5 15:04
 * @description:
 */

@SpringBootTest
public class TestHibernateValidateController {


    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.
                standaloneSetup(new HibernateValidateController()).
                build();
    }

    @Test
    public void hello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/hibernate/hello").param("userName","uname").param("age","400").accept(MediaType.APPLICATION_JSON_UTF8)).andReturn();
    }

}
