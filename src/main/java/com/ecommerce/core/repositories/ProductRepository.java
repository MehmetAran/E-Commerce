package com.ecommerce.core.repositories;

import com.ecommerce.core.entities.Producer;
import com.ecommerce.core.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gennt on 2/23/2017.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

    public List<Product> findByName(String name);
    public List<Product> findAll();
    public void delete(Long id);
    public Product save(Product p);
    public Product findOne(Long id);

    public List<Product> findProductByProducer(@Param("producer") Producer producer);
}
