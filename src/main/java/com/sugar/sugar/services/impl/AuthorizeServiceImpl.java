package com.sugar.sugar.services.impl;

import com.sugar.sugar.entity.Account;
import com.sugar.sugar.mapper.UserMapper;
import com.sugar.sugar.services.AuthorizeService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AuthorizeServiceImpl implements AuthorizeService {

    @Resource
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null) {
            throw new UsernameNotFoundException("用户名不能为空");
        }
        if (username.length() < 3 || username.length() > 12) {
            throw new UsernameNotFoundException("用户名长度应该在3-10位");
        }
        Account account = userMapper.findAccountByNameOrEmail(username);
        if (account == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        // 得到用户角色
        String role = account.getRole();
        // 角色集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 角色必须以`ROLE_`开头，数据库中没有，则在这里加
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .authorities(authorities)
                .password(account.getPassword())
                .build();
    }
}
