package com.shw.vhr.security.component;

import com.shw.vhr.common.api.AjaxResult;
import com.shw.vhr.common.util.ServletUtil;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shw
 * @date 2020/12/3 20:12
 * 登陆失败回调
 */
@Service
public class RestFulFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (exception instanceof LockedException) {
            ServletUtil.restFulResult(response, AjaxResult.failed("账户被锁定，请联系管理员"));
        } else if (exception instanceof CredentialsExpiredException) {
            ServletUtil.restFulResult(response, AjaxResult.failed("密码过期，请联系管理员"));
        } else if (exception instanceof AccountExpiredException) {
            ServletUtil.restFulResult(response, AjaxResult.failed("账号过期，请联系管理员"));
        }else if (exception instanceof DisabledException) {
            ServletUtil.restFulResult(response, AjaxResult.failed("账户被禁用，请联系管理员"));
        }else if (exception instanceof BadCredentialsException) {
            ServletUtil.restFulResult(response, AjaxResult.failed("用户名或者密码输入错误，请联系管理员"));
        }
    }
}
