package com.sugar.sugar.controller;

import com.sugar.sugar.entity.RestBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/aa")
    public RestBean<String> aa() {
        return RestBean.success(HttpStatus.OK,"aa真帅");
    }

    @GetMapping("/bb")
    public RestBean<String> bb() {
        return RestBean.success(HttpStatus.OK,"bb真帅");
    }

    @GetMapping("/cc")
    public RestBean<String> cc() {
        return RestBean.success(HttpStatus.OK,"cc真帅");
    }
}
