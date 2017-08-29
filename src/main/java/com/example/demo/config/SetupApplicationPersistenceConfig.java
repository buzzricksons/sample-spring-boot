package com.example.demo.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan("com.example.demo")
@ComponentScan("com.example.demo")
public class SetupApplicationPersistenceConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
     public DataSourceTransactionManager transactionManager() {
         return new DataSourceTransactionManager(dataSource);
     }

     @Bean
     public SqlSessionFactory sqlSessionFactory() throws Exception {
         SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
         sessionFactory.setDataSource(dataSource);
         SqlSessionFactory factory = sessionFactory.getObject();
         return factory;
     }

     @Bean
     public SqlSession sqlSessionTemplate() throws Exception {
         return new SqlSessionTemplate(sqlSessionFactory());
     }

}