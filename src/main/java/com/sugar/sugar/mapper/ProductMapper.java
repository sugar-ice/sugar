package com.sugar.sugar.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sugar.sugar.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}