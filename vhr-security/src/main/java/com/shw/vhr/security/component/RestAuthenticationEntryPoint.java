package com.shw.vhr.security.component;

import cn.hutool.json.JSONUtil;
import com.shw.vhr.common.api.AjaxResult;
import com.shw.vhr.common.api.ResultCode;
import com.shw.vhr.common.util.ServletUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义返回结果：未登录或登录过期
 *
 * @author shw
 * @date 2020/12/14
 */
@Service
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ServletUtil.restFulResult(response, AjaxResult.failed(ResultCode.UNAUTHENTICATION));
    }
}