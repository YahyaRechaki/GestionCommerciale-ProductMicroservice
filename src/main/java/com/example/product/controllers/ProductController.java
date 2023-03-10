package com.example.product.controllers;

import com.example.product.models.Product;
import com.example.product.repositories.ProductRepository;
import com.example.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addproducts")
    public ResponseEntity<String> addListProduct(@RequestBody List<Product> products) {
        try {
            productService.addProducts(products);
            return new ResponseEntity<>("Products added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding products: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addproduct")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @GetMapping("/readproducts")
    public List<Product> readProducts(){
        return productService.findAll();
    }
    /*@DeleteMapping("/deleteproduct")
    public String deleteProduct(@RequestBody Product product){
        return productService.deleteProduct(product);
    }*/
    @DeleteMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

}
