package com.unit_test.springboot_35.service;

import com.unit_test.springboot_35.models.Product;
import com.unit_test.springboot_35.repository.ProductRepository;
import com.unit_test.springboot_35.service.impl.ProductImpl;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductImpl productService;

    @Test
    void getById_shouldReturnProduct() {
        when(productRepository.findById(1L))
                .thenReturn(Optional.of(new Product(1L, "Laptop",1000)));

        Product result = productService.getById(1L);

        assertEquals("Laptop", result.getName());

    }

    @Test
    void getById_shouldThrowException_whenNotFound() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class,
                ()->productService.getById(99L));
    }
}
