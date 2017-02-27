package com.ecommerce.core.services.impl;

import com.ecommerce.core.entities.Producer;
import com.ecommerce.core.exceptions.CategoryExistsException;
import com.ecommerce.core.exceptions.ProducerExistsException;
import com.ecommerce.core.repositories.ProducerRepository;
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

    @Override
    public Producer save(Producer p) {
        List<Producer> producer = producerRepository.findByName(p.getName());
        if(producer.isEmpty())
            throw new ProducerExistsException("Producer " + p.getName() + " already exists!");
        return producerRepository.save(p);
    }

    @Override
    public Producer delete(Producer p) {
        producerRepository.delete(p.getId());
        return p;
    }

    @Override
    public Producer findByName(String p) {
        List<Producer> producers = producerRepository.findByName(p);
        return producers.get(0);
    }

    @Override
    public Producer findById(Long id) {
        Producer p = producerRepository.findOne(id);
        return p;
    }
}
