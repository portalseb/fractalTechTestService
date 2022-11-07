package com.sebastianportal.fractaltechtest.services;

import com.sebastianportal.fractaltechtest.exception.ApiRequestException;
import com.sebastianportal.fractaltechtest.models.Order;
import com.sebastianportal.fractaltechtest.repos.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void delete(String id) {
        var docOrder = orderRepository.findById(id);
        if(docOrder.isPresent()){
            orderRepository.delete(docOrder.get());
        }else{
            throw new ApiRequestException("This order(" + id+") does not exist. (Maybe it was already deleted?)");
        }
    }

    public Order insert(Order order) {
        var docOrder = orderRepository.findByOrderNo(order.getOrderNo());
        if(docOrder.isPresent()){
            throw new ApiRequestException("This order number ("+order.getOrderNo()+") is already in use. Order number must be unique.");
        }
        else{
            return orderRepository.insert(order);
        }
    }

    public Order update(Order order) {
        var docOrder=orderRepository.findById(order.getId());
        if (docOrder.isPresent()){
            return orderRepository.save(order);
        }else {
            throw new ApiRequestException("Order with id" + order.getId() + " not found in our database.");
        }
    }

    public Order getById(String id) {
        var docOrder = orderRepository.findById(id);
                if(docOrder.isPresent()){
                    return docOrder.get();
                }
                else{
                    throw new ApiRequestException("No such order("+id +") found");
                    }

    }
}
