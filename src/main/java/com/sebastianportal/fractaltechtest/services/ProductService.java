package com.sebastianportal.fractaltechtest.services;

import com.sebastianportal.fractaltechtest.models.Product;
import com.sebastianportal.fractaltechtest.repos.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
