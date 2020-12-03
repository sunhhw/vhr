package com.shw.vhr.common.util;

import cn.hutool.json.JSONUtil;
import com.shw.vhr.common.api.AjaxResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shw
 * @date 2020/12/3 19:51
 */
public class ServletUtil {

    public static <T> void restFulResult(HttpServletResponse response, AjaxResult<T> msg) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try {
            response.getWriter().println(JSONUtil.parse(msg));
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
