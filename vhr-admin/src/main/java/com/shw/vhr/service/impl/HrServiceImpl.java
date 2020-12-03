package com.shw.vhr.service.impl;

import com.shw.vhr.security.bo.LoginUser;
import com.shw.vhr.mbg.mapper.HrMapper;
import com.shw.vhr.mbg.model.Hr;
import com.shw.vhr.mbg.model.HrExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shw
 * @date 2020/12/1 21:06
 */
@Service
public class HrServiceImpl implements UserDetailsService {

    @Autowired
    private HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HrExample hrExample = new HrExample();
        hrExample.createCriteria().andUsernameEqualTo(username);
        List<Hr> hrs = hrMapper.selectByExample(hrExample);
        if (hrs != null && hrs.size() > 0) {
            return new LoginUser(hrs.get(0));
        }
        throw new UsernameNotFoundException("用户名为空");
    }

}
