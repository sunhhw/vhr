package com.shw.vhr.security.component;

import com.shw.vhr.common.api.AjaxResult;
import com.shw.vhr.common.util.ServletUtil;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
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
public class RestFulLogoutHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        ServletUtil.restFulResult(response,AjaxResult.success("退出成功"));
    }
}
