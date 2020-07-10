package com.yju.bbs.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties")
@MapperScan(basePackages = "com.yju.bbs.mapper")
public class DataAccessConfig {

   @Autowired
   private ApplicationContext applicationContext;

   @Bean
   public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
      SqlSessionFactoryBean sqlBean = new SqlSessionFactoryBean();
      sqlBean.setDataSource(dataSource);
      sqlBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));
      return sqlBean.getObject();
   }

   @Bean
   public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
      return new SqlSessionTemplate(sqlSessionFactory);
   }

   @Bean
   @ConfigurationProperties(prefix = "spring.datasource.hikari")
   public HikariConfig hikariConfig() {
      return new HikariConfig();
   }

   @Bean
   public DataSource dataSource() throws Exception {
      DataSource dataSource = new HikariDataSource(hikariConfig());
      return dataSource;
   }
}
