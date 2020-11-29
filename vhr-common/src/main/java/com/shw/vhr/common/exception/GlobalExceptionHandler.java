package com.shw.vhr.common.exception;

import com.shw.vhr.common.api.AjaxResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author shw
 * @date 2020/11/29 16:24
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public AjaxResult apiHandler(ApiException e) {
        System.out.println(111);
        if (e.getResultCode() != null) {
            return AjaxResult.failed(e.getResultCode());
        }
        return AjaxResult.failed(e.getMessage());
    }

}
