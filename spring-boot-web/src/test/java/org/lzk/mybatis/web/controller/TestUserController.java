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
public class TestUserController {


    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.
                standaloneSetup(new UserController()).
                build();
    }

    @Test
    public void getUser() throws Exception {
        mockMvc.
                perform(MockMvcRequestBuilders.post("/user").accept(MediaType.APPLICATION_JSON_UTF8)).
                andDo(print());
    }

    @Test
    public void addUser() throws Exception {
        String contentAsString = mockMvc.
                perform(MockMvcRequestBuilders.post("/addUser").param("name","lzk2").param("age","12").accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : " + contentAsString);
    }

    @Test
    public void users() throws Exception {
        String contentAsString = mockMvc.
                perform(MockMvcRequestBuilders.post("/users").accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : " + contentAsString);
    }

    @Test
    public void param() throws Exception {
        String contentAsString = mockMvc.
                perform(MockMvcRequestBuilders.get("/param/java").accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : " + contentAsString);
    }


}
