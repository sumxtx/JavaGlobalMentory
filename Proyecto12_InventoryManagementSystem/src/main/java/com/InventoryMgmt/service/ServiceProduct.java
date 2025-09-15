package com.InventoryMgmt.service;

import com.InventoryMgmt.modelo.Product;
import com.InventoryMgmt.repo.RepoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceProduct implements IServiceProduct{

    @Autowired
    private RepoProduct repoProduct;

    @Override
    public List<Product> listProducts() {
        return this.repoProduct.findAll();
    }

    @Override
    public Product findProductById(Integer idProduct) {
        return this.repoProduct.findById(idProduct).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        this.repoProduct.save(product);
    }

    @Override
    public void deleteProductById(Integer idProduct) {
        this.repoProduct.deleteById(idProduct);
    }
}
