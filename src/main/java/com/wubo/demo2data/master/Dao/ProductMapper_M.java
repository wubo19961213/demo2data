package com.wubo.demo2data.master.Dao;

import com.wubo.demo2data.Entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper_M {
    List<Product> listProduct();
}
