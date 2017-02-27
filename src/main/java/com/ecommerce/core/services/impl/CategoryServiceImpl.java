package com.ecommerce.core.services.impl;

import com.ecommerce.core.entities.Category;
import com.ecommerce.core.exceptions.CategoryExistsException;
import com.ecommerce.core.repositories.CategoryRepository;
import com.ecommerce.core.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gennt on 2/24/2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category c) {
        Category category = categoryRepository.findByName(c.getName());
        if(category != null)
            throw new CategoryExistsException("Category " + c.getName() + " already exists!");
        return categoryRepository.save(c);
    }

    @Override
    public Category delete(Category c) {
        categoryRepository.delete(c.getId());
        return c;
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
