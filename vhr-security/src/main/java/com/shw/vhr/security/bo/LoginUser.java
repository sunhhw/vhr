package com.shw.vhr.security.bo;

import com.shw.vhr.mbg.model.Hr;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author shw
 * @date 2020/12/2 23:25
 */
public class LoginUser implements UserDetails {

    private Hr hr;

    public Hr getHr() {
        return hr;
    }

    public void setHr(Hr hr) {
        this.hr = hr;
    }

    public LoginUser(Hr hr) {
        this.hr = hr;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return hr.getPassword();
    }

    @Override
    public String getUsername() {
        return hr.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "hr=" + hr +
                '}';
    }
}
