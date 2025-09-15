package com.InventoryMgmt.service;

import com.InventoryMgmt.modelo.Product;

import java.util.List;

public interface IServiceProduct {
    List<Product> listProducts();
    Product findProductById(Integer idProduct);
    void saveProduct(Product product);
    void deleteProductById(Integer idProduct);

}
