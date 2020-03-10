package org.lzk.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactorySecond",
        transactionManagerRef="transactionManagerSecond",
        basePackages= { "org.lzk.jpa.dao.test2" })
public class SecondConfig {
    @Autowired
    @Qualifier("dataSourceSecond")
    private DataSource dataSourceSecond;

    @Autowired
    @Qualifier("vendorProperties")
    private Map<String, Object> vendorProperties;

    @Bean(name = "entityManagerFactorySecond")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecond (  EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSourceSecond)
                .properties(vendorProperties)
                .packages("org.lzk.jpa.entity")
                .persistenceUnit("SecondPersistenceUnit")
                .build();
    }

    @Bean(name = "entityManagerSecond")
    public EntityManager entityManagerSecond( EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySecond(builder).getObject().createEntityManager();
    }

    @Bean(name = "transactionManagerSecond")
    PlatformTransactionManager transactionManagerSecond(  EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySecond(builder).getObject());
    }
}