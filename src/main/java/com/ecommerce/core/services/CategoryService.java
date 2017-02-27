package com.ecommerce.core.services;

import com.ecommerce.core.entities.Category;

/**
 * Created by gennt on 2/24/2017.
 */

public interface CategoryService {
    public Category save(Category c);
    public Category delete(Category c);
    public Category findByName(String name);
}
