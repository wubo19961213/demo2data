package com.wubo.demo2data.Controller;

import com.wubo.demo2data.Entity.Product;
import com.wubo.demo2data.master.Service.ProductServiceMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ProductControllerMaster")
public class ProductControllerMaster {

    @Autowired
    private ProductServiceMaster productServiceMaster;
    @RequestMapping(value="/listProduct",method = RequestMethod.GET)
    public List<Product> listProduct()
    {
        return productServiceMaster.listProduct();
    }
}
