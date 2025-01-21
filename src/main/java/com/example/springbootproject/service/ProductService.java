package com.example.springbootproject.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import com.example.springbootproject.model.Product;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    //Initializes the product list by loading data from a JSON file.
    @PostConstruct
    public void init() {
        try (InputStream is = getClass().getResourceAsStream("/products.json")) {
            ObjectMapper mapper = new ObjectMapper();
            products = mapper.readValue(is, new TypeReference<List<Product>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Retrieves the complete list of products
    public List<Product> getAllProducts() {

        return products;
    }

    //Retrieves a product by its unique ID
    public Product getProductById(Integer id) {
        return products
                .stream()
                .filter(prod -> prod.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

//Retrieves all products belonging to a specific category
    public List<Product> getProductsByCategory(String category) {
        List<Product> filtered = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                filtered.add(p);
            }
        }
        return filtered;
    }
}
