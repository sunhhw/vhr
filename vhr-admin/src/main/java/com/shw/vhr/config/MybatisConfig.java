package com.shw.vhr.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author shw
 * @date 2020/11/29 21:23
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.shw.vhr.mbg.mapper","com.shw.vhr.dao"})
public class MybatisConfig {

}
