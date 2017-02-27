package com.ecommerce.rest.controller;

import com.ecommerce.core.entities.Product;
import com.ecommerce.core.exceptions.ProductDoesNotExistException;
import com.ecommerce.core.services.ProductService;
import com.ecommerce.rest.exceptions.ConflictException;
import com.ecommerce.rest.resources.ProductResource;
import com.ecommerce.rest.resources.asm.ProductResourceAsm;
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
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){

        ProductResource resource = null;
        try{
            Product p = productService.findOne(id);
            resource = new ProductResourceAsm().toResource(p);
        }
        catch (ProductDoesNotExistException e){
            throw new ConflictException(e.getMessage());
        }

        return new ResponseEntity<ProductResource>(resource, HttpStatus.OK);
    }

}
