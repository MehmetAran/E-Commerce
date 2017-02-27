package com.ecommerce.core.services;

import com.ecommerce.core.entities.Client;

import java.util.List;

/**
 * Created by gennt on 2/24/2017.
 */
public interface ClientService {

    public Client findByUsername(String username);
    public List<Client> findAll();
    public Client delete(Long id);
    public Client save(Client c);
    public Client findById(Long id);
}
