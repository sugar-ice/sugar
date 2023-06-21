package com.sugar.sugar.controller;

import com.sugar.sugar.entity.RestBean;
import com.sugar.sugar.properties.DataSourceProperties;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
public class DataController {
    @Resource
    private DataSourceProperties dataSourceProperties;

    @RequestMapping("/datasource")
    public RestBean<DataSourceProperties> data(){
        return RestBean.success(HttpStatus.OK, "连接数据库的四要素", dataSourceProperties);
    }
}
