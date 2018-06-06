package com.wubo.demo2data.master.Service.Impl;

import com.wubo.demo2data.Entity.Product;
import com.wubo.demo2data.master.Dao.ProductMapper_M;
import com.wubo.demo2data.master.Service.ProductServiceMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceMasterImpl implements ProductServiceMaster {
    @Autowired
    private ProductMapper_M productMapper_M;
    @Override
    public List<Product> listProduct() {
        return productMapper_M.listProduct();
    }
}
