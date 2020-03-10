package org.lzk.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    @Autowired
    private JpaProperties jpaProperties;



    @Autowired
    private HibernateProperties hibernateProperties;

    @Bean(name = "vendorProperties")
    public Map<String, Object> getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }


    @Primary
    @ConfigurationProperties("datasource.one")
    @Bean(name = "dataSourceFirst")
    public DataSource dataSourceFirst() {
        return DataSourceBuilder.create().build();
    }



    @ConfigurationProperties("datasource.two")
    @Bean(name = "dataSourceSecond")
    public DataSource dataSourceSecond() {
        return DataSourceBuilder.create().build();
    }

    @ConfigurationProperties("datasource.third")
    @Bean(name = "dataSourceThird")
    public DataSource dataSourceThird() {
        return DataSourceBuilder.create().build();
    }
}
