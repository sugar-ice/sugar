package com.sugar.sugar.controller;

import com.sugar.sugar.entity.Product;
import com.sugar.sugar.entity.RestBean;
import com.sugar.sugar.services.ProductService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Resource
    ProductService productService;

    @GetMapping("/list")
    public RestBean<List<Product>> List() {
        return RestBean.success(HttpStatus.OK, "ok", productService.list());
    }

    @GetMapping("/selectOne")
    public RestBean<Product> selectOne(@RequestParam("id") int id) {
        return RestBean.success(HttpStatus.OK, "ok", productService.getById(id));
    }

    @PostMapping("/delete")
    public RestBean<String> delete(@RequestParam("id") int id) {
        if (productService.remove(id)) {
            return RestBean.success(HttpStatus.OK, "删除成功");
        }
        return RestBean.success(HttpStatus.BAD_REQUEST, "未找到该id");
    }

    @PostMapping("/insert")
    public RestBean<Product> insert(Product product) {
        if (productService.save(product)) {
            return RestBean.success(HttpStatus.OK, "插入成功", product);
        }
        return RestBean.success(HttpStatus.OK, "插入失败");
    }

    @PostMapping("/update")
    public RestBean<Product> update(Product product) {
        if (productService.update(product)) {
            return RestBean.success(HttpStatus.OK, "更新成功");
        }
        return RestBean.success(HttpStatus.OK, "更新失败");
    }
}
