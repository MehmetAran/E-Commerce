package com.ecommerce.rest.controller;

import com.ecommerce.core.entities.Category;
import com.ecommerce.core.services.CategoryService;
import com.ecommerce.rest.resources.CategoryResource;
import com.ecommerce.rest.resources.asm.CategoryResourceAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gennt on 2/24/2017.
 */
@Controller
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/{categoryName}")
    public ResponseEntity<?> findCategoryByName(@PathVariable String categoryName){

        Category c = categoryService.findByName(categoryName);
        CategoryResource res = new CategoryResourceAsm().toResource(c);
        return new ResponseEntity<CategoryResource>(res, HttpStatus.OK);
    }

}
