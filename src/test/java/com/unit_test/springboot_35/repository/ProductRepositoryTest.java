package com.unit_test.springboot_35.repository;

import com.unit_test.springboot_35.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository repository;

    @Test
    void save_shouldPersist() {
        List<Product> products = new java.util.ArrayList<>(List.of());

        List<String> names = List.of("Laptop", "Keyboard", "Mouse");

        names.forEach(name ->
                products.add(new Product(null,name,1000)));

        List<Product> saved = repository.saveAll(products);
        assertEquals(products.size(), saved.size());
        assertNotNull(saved);

    }
}
