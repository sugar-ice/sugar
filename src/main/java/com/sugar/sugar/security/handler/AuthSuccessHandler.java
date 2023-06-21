package com.sugar.sugar.security.handler;

import java.io.IOException;

import com.sugar.sugar.entity.RestBean;
import com.sugar.sugar.entity.User;
import com.sugar.sugar.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {
    @Resource
    UserMapper mapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        String username = user.getUsername();
        User userinfo =  mapper.findUserByNameOrEmail(username);
        if (request != null) {
            request.getSession().setAttribute("user-info", userinfo);
        }
        response.getWriter().write(JSONObject.toJSONString(RestBean.success(HttpStatus.OK, "登录成功！", userinfo)));
    }
}