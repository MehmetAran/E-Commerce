package com.ecommerce.core.services.impl;

import com.ecommerce.core.entities.Client;
import com.ecommerce.core.exceptions.ClientDoesNotExistException;
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
        List<Client> clients = clientRepository.findByUsername(username);
        if(clients.isEmpty())
            throw new ClientExistsException("Client with " +  username + " exists!");
        return clients.get(0);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client delete(Long id) {
        Client c = clientRepository.findOne(id);
        if ( c == null)
            throw new ClientDoesNotExistException("Client: " + id + " does not exists!");
        clientRepository.delete(id);
        return c;
    }

    @Override
    public Client save(Client c) {
        if (clientRepository.findByUsername(c.getUsername()).isEmpty())
            throw new ClientDoesNotExistException("Client: " + c.getId() + " does not exists!");
        return clientRepository.save(c);
    }

    @Override
    public Client findById(Long id) {
        Client client = clientRepository.findOne(id);
        if (client == null) throw new ClientDoesNotExistException("Client: " + id + " does not exists!");
        return client;
    }
}
