package com.shw.vhr.controller;

import com.shw.vhr.common.api.ResultCode;
import com.shw.vhr.common.exception.ApiException;
import com.shw.vhr.mbg.model.Hr;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author shw
 * @date 2020/11/29 0:51
 */
@RestController
@RequestMapping("/hello")
@Api(tags = "Hello管理")
public class Hello {

    @ApiOperation("返回姓名123")
    @PostMapping("/world")
    public Hr hello(Hr hr, @RequestParam(value = "n1", required = true) String name) {
        System.out.println(name);
        boolean flag = true;
        if (flag) {
            throw new ApiException(ResultCode.UN);
        }
        System.out.println(hr);
        hr.setAge(11);
        hr.setGender(1);
        hr.setName("张三111");
        return hr;
    }

    @ApiOperation("测试异常")
    @PostMapping("/exce")
    public String hi(@RequestBody Hr hr) {
        System.out.println(hr);
        boolean flag = true;
        if (flag) {
            throw new ApiException("测试异常");
        }
        return "ok";
    }

    @ApiOperation("测试")
    @PostMapping("/exce22")
    public String his(@RequestBody Hr hr) {
        boolean flag = true;
        if (flag) {
            throw new ApiException("测试异常");
        }
        return "ok";
    }
}
