package com.ecommerce.core.services.impl;

import com.ecommerce.core.entities.Producer;
import com.ecommerce.core.entities.Product;
import com.ecommerce.core.exceptions.CategoryExistsException;
import com.ecommerce.core.exceptions.ProducerExistsException;
import com.ecommerce.core.exceptions.ProducerNotFoundException;
import com.ecommerce.core.repositories.ProducerRepository;
import com.ecommerce.core.repositories.ProductRepository;
import com.ecommerce.core.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gennt on 2/24/2017.
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Producer save(Producer p) {
        Producer producer = producerRepository.findByName(p.getName());
        if(producer != null)
            throw new ProducerExistsException("Producer " + p.getName() + " already exists!");
        return producerRepository.save(p);
    }

    @Override
    public Producer delete(Producer p) {
        if(producerRepository.findByName(p.getName()) == null)
            throw new ProducerNotFoundException("Producer not found");
        producerRepository.delete(p.getId());
        return p;
    }

    @Override
    public Producer findByName(String p) {
        Producer pr = producerRepository.findByName(p);
        System.out.println(p);
        if(pr == null)
            throw new ProducerNotFoundException("Producer not found");
        return pr;
    }

    @Override
    public Producer findById(Long id) {
        Producer p = producerRepository.findOne(id);
        if (p == null)
            throw new ProducerNotFoundException("Producer not found");
        return p;
    }


    @Override
    public List<Product> findProductsByProducer(String producerName) {

        Producer producer = this.findByName(producerName);

        List<Product> products = productRepository.findProductByProducer(producer);
        return products;
    }
}
