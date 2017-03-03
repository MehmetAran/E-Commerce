package com.ecommerce.rest.controller;

import com.ecommerce.core.entities.Product;
import com.ecommerce.core.exceptions.ProductNotFoundException;
import com.ecommerce.core.services.CategoryService;
import com.ecommerce.core.services.ProducerService;
import com.ecommerce.core.services.ProductService;
import com.ecommerce.rest.exceptions.ConflictException;
import com.ecommerce.rest.exceptions.NotFoundException;
import com.ecommerce.rest.resources.ProductResource;
import com.ecommerce.rest.resources.asm.ProductResourceAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gennt on 2/24/2017.
 */
@Controller
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProducerService producerService;

    @RequestMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){

        ProductResource resource = null;
        try{
            Product p = productService.findOne(id);
            resource = new ProductResourceAsm().toResource(p);
        }
        catch (ProductNotFoundException e){
            throw new NotFoundException(e.getMessage());
        }

        return new ResponseEntity<ProductResource>(resource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public  ResponseEntity<ProductResource> addProduct(@RequestBody ProductResource sentProduct,
                                            @Param("producer") String producer,
                                            @Param("category") String category){

        System.out.println(producer + " " + category) ;

        Product product  = sentProduct.toProduct();
        product.setProducer(producerService.findByName(producer));
        product.setCategory(categoryService.findByName(category));

        Product saved = productService.save(product);
        ProductResource res = new ProductResourceAsm().toResource(saved);
        return new ResponseEntity<ProductResource>(res, HttpStatus.CREATED);
    }
}
