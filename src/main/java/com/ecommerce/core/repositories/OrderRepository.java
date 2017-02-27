package com.ecommerce.core.repositories;

import com.ecommerce.core.entities.Client;
import com.ecommerce.core.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gennt on 2/23/2017.
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

    public List<Order> findAll();
    public Order findOne(Long aLong);
    public Order save(Order o);

    @Query("SELECT o FROM Order o JOIN o.client c WHERE (o.client.id = :clientId)")
    public List<Order> findOrdersByClient(@Param("clientId") Long cliendId);
}
