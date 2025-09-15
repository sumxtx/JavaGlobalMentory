package com.InventoryMgmt.repo;

import com.InventoryMgmt.modelo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoProduct extends JpaRepository<Product, Integer> {

}

