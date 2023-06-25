package com.sugar.sugar.services;

import com.sugar.sugar.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> list();
    Product getById(int id);
    boolean save(Product product);
    boolean update(Product product);
    boolean remove(int id);
}