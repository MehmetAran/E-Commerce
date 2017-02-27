package com.ecommerce.core.services;

import com.ecommerce.core.entities.Client;
import com.ecommerce.core.entities.Order;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by gennt on 2/24/2017.
 */
public interface OrderService {

    public List<Order> findAll();
    public Order findOne(Long id);
    public Order save(Order o);
    public List<Order> findOrdersByClient(Long id);

}
