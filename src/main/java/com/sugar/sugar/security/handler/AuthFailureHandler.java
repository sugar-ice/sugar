/*
 * @Author: lmio
 * @Date: 2023-04-11 20:43:42
 * @LastEditTime: 2023-04-23 16:48:16
 * @FilePath: /mlib/mlib-backend/src/main/java/com/lmio/mlib/security/handler/AuthFailureHandler.java
 * @Description: 
 */
/*
 * @Author: lmio
 * @Date: 2023-04-06 21:49:39
 * @LastEditTime: 2023-04-11 20:43:34
 * @FilePath: /mlib/mlib-backend/src/main/java/com/lmio/mlib/security/AuthSuccessHandler.java
 * @Description: 登陆失败处理逻辑
 */
package com.sugar.sugar.security.handler;

import java.io.IOException;

import com.sugar.sugar.entity.RestBean;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSONObject.toJSONString(RestBean.failure(HttpStatus.UNAUTHORIZED,"账号或密码错误！")));
    }
    
}