package com.ecommerce.core.repositories;

import com.ecommerce.core.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by gennt on 2/24/2017.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
    public Category save(Category c);
    public void delete(Category c);
    public Category findByName(String name);
}
