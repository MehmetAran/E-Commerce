package com.ecommerce.core.services.impl;

import com.ecommerce.core.entities.Client;
import com.ecommerce.core.entities.Order;
import com.ecommerce.core.exceptions.ClientNotFoundException;
import com.ecommerce.core.exceptions.OrderNotFoundException;
import com.ecommerce.core.repositories.ClientRepository;
import com.ecommerce.core.repositories.OrderRepository;
import com.ecommerce.core.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gennt on 2/24/2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Order> findOrdersByClient(Long id) {
        Client c = clientRepository.findOne(id);
        if(c == null)
            throw new ClientNotFoundException("This client does not exists!");
        return orderRepository.findOrdersByClient(id);
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    @Override
    public Order findOne(Long id) {
        Order o = orderRepository.findOne(id);
        if(o == null) throw new OrderNotFoundException("Order not found");
        return orderRepository.findOne(id);
    }

    @Override
    public Order save(Order o) {
        orderRepository.save(o);
        return o;
    }
}
