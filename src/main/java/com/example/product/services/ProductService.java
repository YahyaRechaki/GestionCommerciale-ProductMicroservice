package com.example.product.services;

import com.example.product.models.Product;
import com.example.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String addProduct(Product product){
        productRepository.save(product);
        return "Product : " + product.getName() + ", is added successfully !";
    }
    /*public String deleteProduct(Product product){
        System.out.println("product : " + product);
        System.out.println("1 findByName(product.getName()) : " + findByName(product.getName()));
        System.out.println("1 product.getName() : " + product.getName());
        if(findByName(product.getName()).contains(product.getName())){
            System.out.println("findByName(product.getName()) : " + findByName(product.getName()));
            System.out.println("product.getName() : " + product.getName());
            return "No product with the name " + product.getName() + " is founded!";
        }else {
            productRepository.delete(product);
            return "Product " + product.getName() + ", is deleted successfully !";
        }
    }*/
    public String deleteProduct(Long id){
        Product product = productRepository.findById(id).orElse(null);
        if(product == null){
            return "No product with the id " + id + " is found!";
        }else {
            productRepository.delete(product);
            return "Product " + product.getName() + ", is deleted successfully !";
        }
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> findByPriceGreaterThan(Double price) {
        return productRepository.findByPriceGreaterThan(price);
    }
}
