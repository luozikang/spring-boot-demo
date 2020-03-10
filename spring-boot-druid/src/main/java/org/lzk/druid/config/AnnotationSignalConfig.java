package org.lzk.druid.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "active",prefix = "spring.profiles",havingValue="mybatisSignal")
@MapperScan("org.lzk.druid.dao.signal")
public class AnnotationSignalConfig {

}