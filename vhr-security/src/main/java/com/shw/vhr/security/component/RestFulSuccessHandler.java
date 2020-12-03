package com.shw.vhr.security.component;

import com.shw.vhr.common.api.AjaxResult;
import com.shw.vhr.common.util.ServletUtil;
import com.shw.vhr.security.bo.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shw
 * @date 2020/12/3 20:04
 * 登陆成功后的回调
 */
@Service
public class RestFulSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        loginUser.getHr().setPassword(null);
        ServletUtil.restFulResult(response, AjaxResult.success(loginUser.getHr()));
    }
}
