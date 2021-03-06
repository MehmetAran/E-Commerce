package com.ecommerce.rest.controller;

import com.ecommerce.core.entities.Category;
import com.ecommerce.core.exceptions.CategoryExistsException;
import com.ecommerce.core.exceptions.CategoryNotFoundException;
import com.ecommerce.core.services.CategoryService;
import com.ecommerce.rest.exceptions.ConflictException;
import com.ecommerce.rest.exceptions.NotFoundException;
import com.ecommerce.rest.resources.CategoryResource;
import com.ecommerce.rest.resources.asm.CategoryResourceAsm;
import com.sun.org.apache.xerces.internal.util.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gennt on 2/24/2017.
 */
@Controller
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/{categoryName}", method = RequestMethod.GET)
    public ResponseEntity<CategoryResource> findCategoryByName(@PathVariable String categoryName){

        try {
            Category c = categoryService.findByName(categoryName);
            CategoryResource res = new CategoryResourceAsm().toResource(c);
            return new ResponseEntity<CategoryResource>(res, HttpStatus.OK);
        }
        catch (CategoryNotFoundException e){
            throw new NotFoundException(e.getMessage());
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<CategoryResource> createCategory(@RequestBody CategoryResource sentCategory){
        try{
            Category createdCategory = categoryService.save(sentCategory.toCategory());
            CategoryResource res = new CategoryResourceAsm().toResource(createdCategory);
            HttpHeaders header = new HttpHeaders();
            header.setLocation(java.net.URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<CategoryResource>(res,header,HttpStatus.CREATED);
        }
        catch (CategoryExistsException e){
            throw new ConflictException(e.getMessage());
        }
    }

    @RequestMapping(value = "/{categoryName}", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<CategoryResource> updateCategory(@PathVariable String categoryName,
                                                           @RequestBody CategoryResource sentCategory){
        try{
            Category updatedCategory = categoryService.update(categoryName, sentCategory.toCategory());
            CategoryResource res = new CategoryResourceAsm().toResource(updatedCategory);
            return  new ResponseEntity<CategoryResource>(res, HttpStatus.OK);
        }
        catch (CategoryNotFoundException e){
            throw new NotFoundException(e.getMessage());
        }

    }
}
