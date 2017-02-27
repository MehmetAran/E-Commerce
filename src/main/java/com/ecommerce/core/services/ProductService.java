package com.ecommerce.core.services;

import com.ecommerce.core.entities.Product;

import java.util.List;

/**
 * Created by gennt on 2/24/2017.
 */
public interface ProductService {
    public Product findByName(String name);
    public List<Product> findAll();
    public Product delete(Long id);
    public Product save(Product p);
    public Product findOne(Long id);

}
