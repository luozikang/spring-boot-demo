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
        entityManagerFactoryRef="entityManagerFactoryFirst",
        transactionManagerRef="transactionManagerFirst",
        basePackages= { "org.lzk.jpa.dao.test1" })
public class FirstConfig {
    @Autowired
    @Qualifier("dataSourceFirst")
    private DataSource dataSourceFirst;

    @Autowired
    @Qualifier("vendorProperties")
    private Map<String, Object> vendorProperties;

    @Bean(name = "entityManagerFactoryFirst")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryFirst ( EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSourceFirst)
                .properties(vendorProperties)
                .packages("org.lzk.jpa.entity")
                .persistenceUnit("FirstPersistenceUnit")
                .build();
    }

    @Bean(name = "entityManagerFirst")
    public EntityManager entityManagerFirst( EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryFirst(builder).getObject().createEntityManager();
    }

    @Bean(name = "transactionManagerFirst")
    PlatformTransactionManager transactionManagerFirst( EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryFirst(builder).getObject());
    }
}