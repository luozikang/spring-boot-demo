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
        entityManagerFactoryRef="entityManagerFactoryThird",
        transactionManagerRef="transactionManagerThird",
        basePackages= { "org.lzk.jpa.dao.test" })
public class ThirdConfig {
    @Autowired
    @Qualifier("dataSourceThird")
    private DataSource dataSourceThird;

    @Autowired
    @Qualifier("vendorProperties")
    private Map<String, Object> vendorProperties;

    @Bean(name = "entityManagerFactoryThird")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryThird (  EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSourceThird)
                .properties(vendorProperties)
                .packages("org.lzk.jpa.entity")
                .persistenceUnit("ThirdPersistenceUnit")
                .build();
    }

    @Bean(name = "entityManagerThird")
    public EntityManager entityManagerThird(  EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryThird(builder).getObject().createEntityManager();
    }

    @Bean(name = "transactionManagerThird")
    PlatformTransactionManager transactionManagerThird(  EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryThird(builder).getObject());
    }
}