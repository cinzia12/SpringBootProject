package com.example.springbootproject.controller;

import com.example.springbootproject.model.Product;
import com.example.springbootproject.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")  // Base URL: http://localhost:8080/products
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * GET /products/hello
     * A simple endpoint that returns "Hello World".
     * Example: GET http://localhost:8080/products/hello
     */
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    /**
     * GET /products
     * Returns ALL products
     * Example: GET http://localhost:8080/products
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * GET /products/category/{category}
     * Returns FILTERED products by category
     * Example: GET http://localhost:8080/products/category/beauty
     */
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category) {
        return productService.getProductsByCategory(category);
    }

    /**
     * GET /products/{id}
     * Returns a single product by ID
     * Example: GET http://localhost:8080/products/3
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }
}
