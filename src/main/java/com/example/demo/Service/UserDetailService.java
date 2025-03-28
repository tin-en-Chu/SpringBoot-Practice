package com.example.demo.Service;

import com.example.demo.bean.UserBean;
import com.example.demo.bean.UserDetailBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBean user = new UserBean( 1,"Kyle","123456789");
        if (user == null) {
            log.info("username not found");
            throw new UsernameNotFoundException("username not found");
        }
        UserDetailBean UserDetailBean = new UserDetailBean();
        UserDetailBean.setUser(user);
        return UserDetailBean;
    }
}
