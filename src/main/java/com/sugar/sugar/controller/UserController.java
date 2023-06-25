package com.sugar.sugar.controller;

import com.sugar.sugar.entity.RestBean;
import com.sugar.sugar.entity.User;
import com.sugar.sugar.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("/all")
    public RestBean<List<User>> all() {
        return RestBean.success(HttpStatus.OK, "ok", userService.findAllUser());
    }

    @GetMapping("/selectOne")
    public RestBean<User> selectOne(@RequestParam("text") String text) {
        return RestBean.success(HttpStatus.OK, "ok", userService.findUserByNameOrEmail(text));
    }
}
