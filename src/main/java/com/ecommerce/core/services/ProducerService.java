package com.ecommerce.core.services;

import com.ecommerce.core.entities.Producer;

/**
 * Created by gennt on 2/24/2017.
 */

public interface ProducerService {
    public Producer save(Producer c);
    public Producer delete(Producer c);
    public Producer findByName(String p);
    public Producer findById(Long id);

}
