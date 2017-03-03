package com.ecommerce.rest.controller;

import com.ecommerce.core.entities.Client;
import com.ecommerce.core.exceptions.ClientExistsException;
import com.ecommerce.core.services.ClientService;
import com.ecommerce.rest.exceptions.ConflictException;
import com.ecommerce.rest.resources.ClientResource;
import com.ecommerce.rest.resources.asm.ClientResourceAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gennt on 3/2/2017.
 */
@Controller
@RequestMapping("/api/register")
public class RegisterClientController {

    @Autowired
    private ClientService clientService;


    @RequestMapping(value = "/client", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<ClientResource> createClient(@RequestBody ClientResource sentClient){

        try{
            Client c = sentClient.toClient();
            clientService.save(c);
            ClientResource res = new ClientResourceAsm().toResource(c);



            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            return new ResponseEntity<ClientResource>(res, HttpStatus.CREATED);
        }
        catch (ClientExistsException e){
            throw new ConflictException(e.getMessage());
        }
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ClientResource> addAdmin(@RequestBody ClientResource sentClient){

        try{
            Client c = sentClient.toClient();
            c.setRole("ROLE_ADMIN");
            clientService.save(c);
            ClientResource res = new ClientResourceAsm().toResource(c);
            return new ResponseEntity<ClientResource>(res, HttpStatus.CREATED);
        }
        catch (ClientExistsException e){
            throw new ConflictException(e.getMessage());
        }
    }




}
