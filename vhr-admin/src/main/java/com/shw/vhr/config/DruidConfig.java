package com.shw.vhr.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.shw.vhr.config.properties.DruidProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author shw
 * @date 2020/11/28 2:23
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dataSource(DruidProperties druidProperties) {
        DruidDataSource build = DruidDataSourceBuilder.create().build();
        return druidProperties.dataSource(build);
    }

}
