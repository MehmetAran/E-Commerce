package com.ecommerce.rest.resources.asm;

import com.ecommerce.core.entities.Client;
import com.ecommerce.rest.controller.ClientController;
import com.ecommerce.rest.resources.ClientResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
/**
 * Created by gennt on 2/23/2017.
 */
public class ClientResourceAsm extends ResourceAssemblerSupport<Client, ClientResource>{

    public ClientResourceAsm() {
        super(ClientController.class, ClientResource.class);
    }

    @Override
    public ClientResource toResource(Client client) {
        ClientResource res = new ClientResource();
        res.setCountry(client.getCountry());
        res.setUsername(client.getUsername());
        res.setEmail(client.getEmail());
        res.setCity(client.getCity());
        res.setAddress(client.getAddress());
        res.setName(client.getName());
        res.setLastName(client.getLastName());
        res.setPassword(client.getPassword());
        res.setRole(client.getRole());

        Link link = linkTo(ClientController.class).slash(client.getId()).withSelfRel();
        res.add(link);

        return res;
    }
}
