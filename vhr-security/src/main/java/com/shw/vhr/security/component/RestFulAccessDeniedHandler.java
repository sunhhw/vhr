package com.shw.vhr.security.component;

import com.shw.vhr.common.api.AjaxResult;
import com.shw.vhr.common.util.ServletUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shw
 * @date 2020/12/3 22:19
 * 没有权限登陆时
 */
@Service
public class RestFulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ServletUtil.restFulResult(response, AjaxResult.failed(accessDeniedException.getMessage()));
    }
}
