package com.shw.vhr.controller;

import com.shw.vhr.common.api.AjaxResult;
import com.shw.vhr.mbg.mapper.HrMapper;
import com.shw.vhr.mbg.model.Hr;
import com.shw.vhr.mbg.model.HrExample;
import io.swagger.annotations.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

/**
 * @author shw
 * @date 2020/11/29 21:51
 */
@RestController
public class HrController {

    @Autowired
    private HrMapper mapper;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public AjaxResult<List<Hr>> hello() {

        HrExample example = new HrExample();
        HrExample.Criteria criteria = example.createCriteria();
        criteria.andAddressEqualTo("深圳南山");
        List<Hr> hrs = mapper.selectByExample(example);
        return AjaxResult.success(hrs);
    }

}
