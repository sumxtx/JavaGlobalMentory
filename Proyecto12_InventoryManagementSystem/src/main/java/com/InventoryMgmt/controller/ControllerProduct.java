package com.InventoryMgmt.controller;

import com.InventoryMgmt.modelo.Product;
import com.InventoryMgmt.service.ServiceProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("inventory-app") //http://localhost:8080/inventory-app
@CrossOrigin(value="http://localhost:4200") //Allow Default Angular port to send requests to the backend
public class ControllerProduct {
    private static final Logger logger = LoggerFactory.getLogger(ControllerProduct.class);

    @Autowired
    private ServiceProduct serviceProduct;

    @GetMapping("/products") //inventory-app/products
    public List<Product> getProducts(){
        List<Product> products = this.serviceProduct.listProducts();
        logger.info("Products: ");
        products.forEach(product -> logger.info(product.toString()));
        return products;
    }

    
}
