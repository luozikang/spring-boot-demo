package org.lzk.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(name = "active",prefix = "spring.profiles",havingValue="xmlsignal")
@Configuration
@MapperScan("org.lzk.mybatis.dao")
public class MybatisConfig {

}
