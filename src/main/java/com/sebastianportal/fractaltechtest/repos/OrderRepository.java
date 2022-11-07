package com.sebastianportal.fractaltechtest.repos;

import com.sebastianportal.fractaltechtest.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order,String> {

    Optional<Order> findByOrderNo(Long orderNo);
}
