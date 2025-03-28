package com.example.demo.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Data
@NoArgsConstructor
/**
 * 覆寫原有spring security的UserDetails，將我我們自己的登入物件寫進去
 */
public class UserDetailBean implements UserDetails {
    
    //登入物件
    private UserBean user;

    // 覆盖UserDetails接口中的getAuthorities方法，返回用户的权限集合
    // 这里返回null，表示未实现获取权限的逻辑
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    
    @Override
    public String getPassword() {
        return user.getPwd();
    }

    /**
     * 登入可能用email
     */
    @Override
    public String getUsername() {
        return user.getUserName();
    }

    /**
     * 帳戶驗證時間是否過期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 帳戶是否被鎖定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用戶憑證是否到期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 判斷客戶是否有啟用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
