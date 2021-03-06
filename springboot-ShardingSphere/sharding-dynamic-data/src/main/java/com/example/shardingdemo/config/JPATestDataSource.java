package com.example.shardingdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Auther: huhy
 * @Date: 2020/7/15 17:51
 * @Description:
 */
@Data
@ConfigurationProperties(prefix = "spring.shardingsphere.datasource.druid.test")
@Component
public class JPATestDataSource {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private String databaseName;

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    public DataSource createDataSource() {
        DruidDataSource result = new DruidDataSource();
        result.setDriverClassName(getDriverClassName());
        result.setUrl(getUrl());
        result.setUsername(getUsername());
        result.setPassword(getPassword());
        return result;
    }
}
