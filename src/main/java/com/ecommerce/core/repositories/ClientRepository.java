package com.ecommerce.core.repositories;

import com.ecommerce.core.entities.Client;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gennt on 2/23/2017.
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{

    public List<Client> findByUsername(String username);
    public List<Client> findAll();
    public void delete(Long id);
    public Client save(Client c);
    public Client findOne(Long id);
}
