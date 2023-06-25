package com.sugar.sugar.services.impl;

import com.sugar.sugar.entity.User;
import com.sugar.sugar.mapper.UserMapper;
import com.sugar.sugar.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.SelectAll();
    }

    @Override
    public User findUserByNameOrEmail(String text) {
        return userMapper.findUserByNameOrEmail(text);
    }
}
