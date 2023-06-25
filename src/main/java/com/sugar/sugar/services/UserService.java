package com.sugar.sugar.services;

import com.sugar.sugar.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAllUser();

    public User findUserByNameOrEmail(String text);
}
