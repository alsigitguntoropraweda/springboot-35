package com.unit_test.springboot_35.controller;

import com.unit_test.springboot_35.dto.BaseResponse;
import com.unit_test.springboot_35.models.Product;
import com.unit_test.springboot_35.service.ProductService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@Import(ProductControllerTest.MockConfig.class)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    ProductController controller;

    @Test
    void get_shouldReturn200() throws Exception {
        when(controller.get(1L)).thenReturn(BaseResponse.ok(new Product(1L, "Laptop",1000)));

        mockMvc.perform(get("/product/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("ok"))
                .andExpect(jsonPath("$.data.name").value("Laptop"))
                .andExpect(jsonPath("$.data.price").value(1000));
    }

    @TestConfiguration
    static class MockConfig {
    }
}