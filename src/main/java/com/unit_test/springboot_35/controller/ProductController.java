package com.unit_test.springboot_35.controller;

import com.unit_test.springboot_35.dto.BaseResponse;
import com.unit_test.springboot_35.models.Product;
import com.unit_test.springboot_35.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("")
    public ResponseEntity<BaseResponse<Product>> created(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.created(productService.created(product)));
    }

    @PutMapping("/{id}")
    public BaseResponse<Product> update(@PathVariable Long id, @RequestBody Product product){
        return BaseResponse.ok(productService.update(id,product));
    }



    @GetMapping("/{id}")
    public BaseResponse<Product> get(@PathVariable Long id) {
        return BaseResponse.ok(productService.getById(id));
    }
}
