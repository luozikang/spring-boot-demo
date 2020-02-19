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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;



@ConditionalOnProperty(name = "active",prefix = "spring.profiles",havingValue="annomulit")
@Configuration
@MapperScan(basePackages = "org.lzk.mybatis.dao.anno.two", sqlSessionTemplateRef  = "twoAnnoSqlSessionTemplate")
public class Annotation2Config {



    @Bean(name = "twoAnnoDataSource")
    @ConfigurationProperties(prefix = "datasource.anno1")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }



    @Bean(name = "twoAnnoSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("twoAnnoDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("org.lzk.mybatis.model");
        return bean.getObject();
    }




    @Bean(name = "twoAnnoTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("twoAnnoDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }




    @Bean(name = "twoAnnoSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("twoAnnoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }




}