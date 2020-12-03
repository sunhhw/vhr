package com.shw.vhr.config;

import com.shw.vhr.security.config.SecurityConfig;
import com.shw.vhr.service.impl.HrServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author shw
 * @date 2020/12/1 20:41
 */
@Configuration
@EnableWebSecurity
public class VhrSecurityConfig extends SecurityConfig {

    @Autowired
    private HrServiceImpl hrService;

//    @Override
//    @Bean
//    public UserDetailsService userDetailsService() {
//        //获取登录用户信息
//        return username -> hrService.loadUserByUsername(username);
//    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return hrService;
    }
}
