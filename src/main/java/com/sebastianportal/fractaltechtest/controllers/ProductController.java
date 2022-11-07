package com.sebastianportal.fractaltechtest.controllers;

import com.sebastianportal.fractaltechtest.models.Product;
import com.sebastianportal.fractaltechtest.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;
    @GetMapping
    List<Product> fetchAllProducts(){
        return productService.getAllProducts();
    }
}
