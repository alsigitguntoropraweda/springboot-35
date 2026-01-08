package com.unit_test.springboot_35.service.impl;

import com.unit_test.springboot_35.models.Product;
import com.unit_test.springboot_35.repository.ProductRepository;
import com.unit_test.springboot_35.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product Not Found"));
    }

    @Override
    public Product created(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product product1 = getById(id);
        return productRepository.save(product1);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
