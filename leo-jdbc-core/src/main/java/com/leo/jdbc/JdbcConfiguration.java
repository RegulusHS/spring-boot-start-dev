package com.leo.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

//xml 替代方式
@Configuration  //spring支持 —— 体现出来springboot的整合
@EnableConfigurationProperties(JdbcProperties.class) //启用配置文件 -> Object属性映射
public class JdbcConfiguration {

    @Bean //spring根据方法创建对象的时候,参数可以注入
    public DataSource dataSource(JdbcProperties jdbcProperties) {
        System.out.println("自动装载了数据库连接池 ");
        DruidDataSource dataSource = new DruidDataSource();
        // 数据库连接配置 —— 配置文件里面的东西?
        dataSource.setUrl(jdbcProperties.getUrl());
        dataSource.setUsername(jdbcProperties.getUsername());
        dataSource.setPassword(jdbcProperties.getPassword());
        dataSource.setDriverClassName(jdbcProperties.getDriverClassName());
        return dataSource;
    }

    @Bean   //xml定义: <bean ... > —— 方法的返回值交给spring托管bean,bean名称就是方法名
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);  //spring 封装的数据库访问工具 —— 需要指定一个数据源
    }

}
