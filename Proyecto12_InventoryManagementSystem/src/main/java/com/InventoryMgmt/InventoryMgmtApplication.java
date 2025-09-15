package com.InventoryMgmt;

import com.InventoryMgmt.modelo.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryMgmtApplication.class, args);

        Product product = new Product();
        product.setDescription("Pen");
        product.setPrice(2.0);
        product.setExistence(300);

        System.out.println(product);
	}

}
