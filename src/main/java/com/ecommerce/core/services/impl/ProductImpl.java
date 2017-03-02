package com.ecommerce.core.services.impl;

import com.ecommerce.core.entities.Product;
import com.ecommerce.core.exceptions.ProductNotFoundException;
import com.ecommerce.core.repositories.ProductRepository;
import com.ecommerce.core.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gennt on 2/24/2017.
 */
@Service
public class ProductImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findByName(String name) {
        List<Product> p = productRepository.findByName(name);
        if(p.isEmpty())
            throw new ProductNotFoundException("Product " + name + " does not exists!");
        return p.get(0);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product delete(Long id) {
        Product p = productRepository.findOne(id);

        if(p == null)
            throw new ProductNotFoundException("Product not found");
        productRepository.delete(id);
        return p;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findOne(Long id) {
        Product p = productRepository.findOne(id);
        if(p == null)
            throw new ProductNotFoundException("Product not found");
        return p;
    }
}
