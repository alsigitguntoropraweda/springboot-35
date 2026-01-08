package com.unit_test.springboot_35.service;

import com.unit_test.springboot_35.models.Product;

public interface ProductService {

    Product getById(Long id);
    Product created(Product product);
    Product update(Long id, Product product);
    void delete(Long id);

}
