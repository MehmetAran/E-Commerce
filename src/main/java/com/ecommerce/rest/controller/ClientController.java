package com.ecommerce.rest.controller;

import com.ecommerce.core.entities.Client;
import com.ecommerce.core.entities.Order;
import com.ecommerce.core.exceptions.ClientDoesNotExistException;
import com.ecommerce.core.services.ClientService;
import com.ecommerce.core.services.OrderService;
import com.ecommerce.rest.exceptions.ConflictException;
import com.ecommerce.rest.resources.ClientResource;
import com.ecommerce.rest.resources.asm.ClientResourceAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @RequestMapping("/{clientId}/orders")
    public ResponseEntity<?> getClientOrders(@PathVariable Long clientId){
        List<Order> orders = null;

        try {
            orders = orderService.findOrdersByClient(clientId);
        }
        catch (ClientDoesNotExistException e){
            throw new ConflictException(e.getMessage());
        }

        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
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
