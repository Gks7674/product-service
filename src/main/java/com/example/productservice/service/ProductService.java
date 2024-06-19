package com.example.productservice.service;

import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ProductService {

    private static final Logger logger = Logger.getLogger(ProductService.class.getName());

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product saveProduct(Product product) {
        logger.info("Saving product: " + product);
        Product savedProduct = productRepository.save(product);
        logger.info("Saved product: " + savedProduct);
        return savedProduct;
    }

    public List<Product> getAllProducts() {
        logger.info("Retrieving all products");
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        logger.info("Retrieving product by ID: " + id);
        return productRepository.findById(id);
    }

    public void deleteProduct(Long id) {
        logger.info("Deleting product by ID: " + id);
        productRepository.deleteById(id);
    }
}
