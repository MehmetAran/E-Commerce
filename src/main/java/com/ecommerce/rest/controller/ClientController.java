package com.ecommerce.rest.controller;

import com.ecommerce.core.entities.Client;
import com.ecommerce.core.entities.Order;
import com.ecommerce.core.entities.Product;
import com.ecommerce.core.exceptions.ClientDoesNotExistException;
import com.ecommerce.core.services.ClientService;
import com.ecommerce.core.services.OrderService;
import com.ecommerce.core.services.ProductService;
import com.ecommerce.rest.exceptions.ConflictException;
import com.ecommerce.rest.resources.ClientResource;
import com.ecommerce.rest.resources.OrderResource;
import com.ecommerce.rest.resources.asm.ClientResourceAsm;
import com.ecommerce.rest.resources.asm.OrderResourceAsm;
import com.ecommerce.rest.util.OrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

/**
 * Created by gennt on 2/23/2017.
 */
@Controller
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private OrderService orderService;


    @Autowired
    private ProductService productService;

    @RequestMapping("/{clientId}/orders")
    public ResponseEntity<OrderList> getClientOrders(@PathVariable Long clientId){
        List<Order> orders = null;
        OrderList ol = new OrderList();
        try {
            orders = orderService.findOrdersByClient(clientId);
            ol.orderToResourceList(orders);
        }
        catch (ClientDoesNotExistException e){
            throw new ConflictException(e.getMessage());
        }

        return new ResponseEntity<OrderList>(ol, HttpStatus.OK);
    }

    @RequestMapping(value = "/{clientId}/orders", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@PathVariable Long clientId,
                                         @RequestParam(value = "productsId[]") Long[] productsId){
        //List<Product> products = new ArrayList<>();
        Set<Product> products = new HashSet<>();
        for (Long n : productsId) {
           // System.out.println(n);
            products.add(productService.findOne(n));
        }

        Order createdOrder = new Order();
        createdOrder.setClient(clientService.findById(clientId));
        createdOrder.setDate(new Date());
        createdOrder.setProduct(products);

        orderService.save(createdOrder);

        OrderResource res = new OrderResourceAsm().toResource(createdOrder);

        return new ResponseEntity<OrderResource>(res, HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<ClientResource> getClientById(@PathVariable Long id){
        try{
            Client client = clientService.findById(id);
            ClientResource clientResource = new ClientResourceAsm().toResource(client);
            return new ResponseEntity<ClientResource>(clientResource, HttpStatus.OK);
        }
        catch (ClientDoesNotExistException e){
            throw new ConflictException(e.getMessage());
        }
    }

    @RequestMapping
    public ResponseEntity<?> getAllClients(){
        List<Client> clients = clientService.findAll();
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }



}
