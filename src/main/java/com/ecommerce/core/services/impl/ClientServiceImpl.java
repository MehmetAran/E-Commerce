package com.ecommerce.core.services.impl;

import com.ecommerce.core.entities.Client;
import com.ecommerce.core.exceptions.ClientNotFoundException;
import com.ecommerce.core.exceptions.ClientExistsException;
import com.ecommerce.core.repositories.ClientRepository;
import com.ecommerce.core.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gennt on 2/24/2017.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findByUsername(String username) {
        Client c = clientRepository.findByUsername(username);
        if (c == null) throw new ClientNotFoundException("Client not found");
        return c;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client delete(Long id) {
        Client c = clientRepository.findOne(id);
        if ( c == null)
            throw new ClientNotFoundException("Client not found");
        clientRepository.delete(id);
        return c;
    }

    @Override
    public Client save(Client c) {

        if(clientRepository.findByUsername(c.getUsername()) != null)
            throw new ClientExistsException("Client with \'" + c.getUsername() + " \' username exists");

        if(c.getRole() == null) c.setRole("ROLE_USER");

        return clientRepository.save(c);
    }

    @Override
    public Client findById(Long id) {
        Client client = clientRepository.findOne(id);
        if (client == null) throw new ClientNotFoundException("Client not found");
        return client;
    }
}
