package com.ecommerce.rest.controller;

import com.ecommerce.core.entities.Client;
import com.ecommerce.core.entities.Order;
import com.ecommerce.core.entities.Product;
import com.ecommerce.core.exceptions.ClientNotFoundException;
import com.ecommerce.core.services.ClientService;
import com.ecommerce.core.services.OrderService;
import com.ecommerce.core.services.ProductService;
import com.ecommerce.rest.exceptions.ConflictException;
import com.ecommerce.rest.exceptions.NotFoundException;
import com.ecommerce.rest.resources.ClientResource;
import com.ecommerce.rest.resources.OrderResource;
import com.ecommerce.rest.resources.asm.ClientResourceAsm;
import com.ecommerce.rest.resources.asm.OrderResourceAsm;
import com.ecommerce.rest.util.ClientList;
import com.ecommerce.rest.util.OrderList;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    private Client getCurrentClient(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return clientService.findByUsername(username);
    }

    public void checkAccess(Long clientId){
        Client currentClient = getCurrentClient();

        if(currentClient.getId() != clientId)
            throw new AccessDeniedException("Access Denied");
    }

    // TODO: 3/2/2017 createClient()
    
    @RequestMapping("/{clientId}/orders")
    public ResponseEntity<OrderList> getClientOrders(@PathVariable  Long clientId){

        checkAccess(clientId);

        List<Order> orders = null;

        OrderList ol = new OrderList();
        try {
            orders = orderService.findOrdersByClient(clientId);
            ol.orderToResourceList(orders);
        }
        catch (ClientNotFoundException e){
            throw new ConflictException(e.getMessage());
        }

        return new ResponseEntity<OrderList>(ol, HttpStatus.OK);
    }

    @RequestMapping(value = "/{clientId}/orders", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@PathVariable Long clientId,
                                         @RequestParam(value = "productsId[]") Long[] productsId){

        checkAccess(clientId);

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
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ClientResource> getClientById(@PathVariable Long id){

        checkAccess(id);

        try{
            Client client = clientService.findById(id);
            ClientResource clientResource = new ClientResourceAsm().toResource(client);
            return new ResponseEntity<ClientResource>(clientResource, HttpStatus.OK);
        }
        catch (ClientNotFoundException e){
            throw new NotFoundException(e.getMessage());
        }
    }

    @RequestMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ClientList> getAllClients(){
        List<Client> clients = clientService.findAll();

        ClientList clientList = new ClientList();
        clientList.clientToResource(clients);

        return new ResponseEntity<ClientList>(clientList, HttpStatus.OK);
    }



}
