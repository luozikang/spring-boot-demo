package org.lzk.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;



@ConditionalOnProperty(name = "active",prefix = "spring.profiles",havingValue="annomulit")
@Configuration
@MapperScan(basePackages = "org.lzk.mybatis.dao.anno.one", sqlSessionTemplateRef  = "oneAnnoSqlSessionTemplate")
public class Annotation1Config {

    @Bean(name = "oneAnnoDataSource")
    @Primary
    @ConfigurationProperties(prefix = "datasource.anno2")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oneAnnoSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("oneAnnoDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("org.lzk.mybatis.model");

        return bean.getObject();
    }

    @Bean(name = "oneAnnoTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("oneAnnoDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "oneAnnoSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("oneAnnoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}