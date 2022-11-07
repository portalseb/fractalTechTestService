package com.sebastianportal.fractaltechtest.controllers;

import com.sebastianportal.fractaltechtest.models.Order;
import com.sebastianportal.fractaltechtest.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    List<Order> fecthAllOrders(){
        return orderService.getAllOrders();
    }

    @DeleteMapping(path = "/delete/{id}")
    void deleteOrder(@PathVariable("id") String id){
        orderService.delete(id);
    }

    @PostMapping(path = "/insert")
    Order insertOrder(@RequestBody Order order)
    {
        return orderService.insert(order);
    }

    @PostMapping(path ="/edit")
    Order updateOrder(@RequestBody Order order){
        return orderService.update(order);
    }

    @GetMapping(path = "{id}")
    Order fetchOrderById(@PathVariable String id){
        return orderService.getById(id);
    }

}
