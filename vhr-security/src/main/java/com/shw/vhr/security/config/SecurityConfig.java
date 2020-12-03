package com.shw.vhr.security.config;

import com.shw.vhr.security.component.*;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author shw
 * @date 2020/12/1 20:53
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭跨站请求
        http.csrf().disable();

        http.authorizeRequests()
                // 设置不拦截接口
                .antMatchers(
                        "/doc.html",
                        "/swagger-ui.html",
                        "/swagger-resources/**",
                        "/v2/api-docs",
                        "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                // 用户登陆的接口名称，默认/login
                .loginProcessingUrl("/doLogin")
                // 登陆失败后跳转的页面路径
                //.loginPage("/login")
                // 登陆成功后
                .successHandler(restFulSuccessHandler)
                // 登陆失败后
                .failureHandler(restFulFailureHandler)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(restFulLogoutHandler)
                .permitAll()
                // 自定义权限拒绝处理类
                .and()
                .exceptionHandling()
                // 没有权限访问时
                .accessDeniedHandler(restFulAccessDeniedHandler)
                // 未登录或登录过期
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

    @Autowired
    private RestFulAccessDeniedHandler restFulAccessDeniedHandler;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private RestFulLogoutHandler restFulLogoutHandler;

    @Autowired
    public RestFulSuccessHandler restFulSuccessHandler;

    @Autowired
    public RestFulFailureHandler restFulFailureHandler;

}
