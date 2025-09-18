package com.InventoryMgmt.controller;

import com.InventoryMgmt.excepcion.ResourceNotFoundException;
import com.InventoryMgmt.modelo.Product;
import com.InventoryMgmt.service.ServiceProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        logger.info("Product to add: " + product);
        return this.serviceProduct.saveProduct(product);
    }

    @GetMapping("/products/{idProduct}")
    public ResponseEntity<Product> getProductById(@PathVariable int idProduct){
        Product product = this.serviceProduct.findProductById(idProduct);
        if(product != null){
            return ResponseEntity.ok(product);
        }
        else {
            throw new ResourceNotFoundException("Id Not Found: " + idProduct);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product receivedProduct){
        Product product = this.serviceProduct.findProductById(id);
        product.setDescription(receivedProduct.getDescription());
        product.setPrice(receivedProduct.getPrice());
        product.setExistence(receivedProduct.getExistence());
        System.out.println("Received Product: " + product);

        this.serviceProduct.saveProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Map<String, Boolean>>
    deleteProduct(@PathVariable int id){
        Product product = this.serviceProduct.findProductById(id);
        if(product == null){
            throw new ResourceNotFoundException("Id not Found: " + id);
        }
        this.serviceProduct.deleteProductById(product.getIdProduct());
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
