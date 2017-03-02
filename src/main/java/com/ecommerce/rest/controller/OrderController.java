package com.ecommerce.rest.controller;

import com.ecommerce.core.entities.Client;
import com.ecommerce.core.entities.Order;
import com.ecommerce.core.services.ClientService;
import com.ecommerce.core.services.OrderService;
import com.ecommerce.rest.resources.OrderResource;
import com.ecommerce.rest.resources.asm.OrderResourceAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gennt on 2/26/2017.
 */
@Controller
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    @RequestMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId){

        Order o = orderService.findOne(orderId);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Client currentUser = clientService.findByUsername(username);

        if(currentUser.getId() != o.getClient().getId())
            throw new AccessDeniedException("Access Denied");

        OrderResource res = new OrderResourceAsm().toResource(o);

        return new ResponseEntity<OrderResource>(res, HttpStatus.OK);
    }

}
