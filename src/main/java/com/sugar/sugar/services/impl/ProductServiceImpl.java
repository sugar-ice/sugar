package com.sugar.sugar.services.impl;

import com.sugar.sugar.entity.Product;
import com.sugar.sugar.mapper.ProductMapper;
import com.sugar.sugar.services.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductMapper productMapper;

    @Override
    public List<Product> list() {
        return productMapper.selectList(null);
    }

    @Override
    public Product getById(int id) {
        return productMapper.selectById(id);
    }

    @Override
    public boolean save(Product product) {
        return productMapper.insert(product) > 0;
    }

    @Override
    public boolean update(Product product) {
        return productMapper.updateById(product) > 0;
    }

    @Override
    public boolean remove(int id) {
        return productMapper.deleteById(id) > 0;
    }
}

