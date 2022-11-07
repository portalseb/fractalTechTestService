package com.sebastianportal.fractaltechtest.repos;

import com.sebastianportal.fractaltechtest.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product,String> {
    Optional<Product> findByName(String name);
}
