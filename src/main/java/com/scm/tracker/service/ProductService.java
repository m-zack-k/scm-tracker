package com.scm.tracker.service;

import com.scm.tracker.model.Product;
import com.scm.tracker.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public void saveProduct(Product product) {
        repository.save(product);
    }

    public void updateStock(Long id, int quantityChange) {
        Product product = repository.findById(id).orElseThrow();
        product.setStockQuantity(product.getStockQuantity() + quantityChange);
        repository.save(product);
    }
}