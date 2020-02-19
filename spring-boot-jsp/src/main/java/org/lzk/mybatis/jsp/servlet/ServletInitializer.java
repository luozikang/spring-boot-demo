package org.lzk.mybatis.jsp.servlet;

import org.lzk.mybatis.jsp.JSPAppliaction;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JSPAppliaction.class);
    }
}