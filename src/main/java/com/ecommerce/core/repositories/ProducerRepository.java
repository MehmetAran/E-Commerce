package com.ecommerce.core.repositories;

import com.ecommerce.core.entities.Producer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gennt on 2/24/2017.
 */
@Repository
public interface ProducerRepository extends CrudRepository<Producer, Long>{
    public Producer save(Producer c);
    public void delete(Producer c);
    public Producer findOne(Long id);
    public List<Producer> findByName(@Param("name") String name);
}
