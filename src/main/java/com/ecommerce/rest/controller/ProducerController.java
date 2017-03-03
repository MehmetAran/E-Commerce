package com.ecommerce.rest.controller;

import com.ecommerce.core.entities.Producer;
import com.ecommerce.core.entities.Product;
import com.ecommerce.core.exceptions.ProducerExistsException;
import com.ecommerce.core.exceptions.ProducerNotFoundException;
import com.ecommerce.core.services.ProducerService;
import com.ecommerce.rest.exceptions.ConflictException;
import com.ecommerce.rest.exceptions.NotFoundException;
import com.ecommerce.rest.resources.ProducerResource;
import com.ecommerce.rest.resources.asm.ProducerResourceAsm;
import com.ecommerce.rest.util.ProductList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by gennt on 2/24/2017.
 */
@Controller
@RequestMapping("/api/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping("/{producerName}")
    public ResponseEntity<?> getProdcerByName(@PathVariable String producerName){

        try{
            Producer p = producerService.findByName(producerName.toLowerCase());
            ProducerResource res = new ProducerResourceAsm().toResource(p);
            return new ResponseEntity<ProducerResource>(res, HttpStatus.OK);
        }
        catch (ProducerNotFoundException e){
            throw new NotFoundException(e.getMessage());
        }
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProducerResource> addProducer(@RequestBody ProducerResource sentProducer){
        try{

            Producer p = sentProducer.toProducer();

            producerService.save(p);

            ProducerResource res =  new ProducerResourceAsm().toResource(p);

            return  new ResponseEntity<ProducerResource>(res, HttpStatus.CREATED);

        }
        catch (ProducerExistsException e){
            throw new ConflictException(e.getMessage());
        }
    }

    @RequestMapping(value = "/{producerName}/products")
    public ResponseEntity<?> getProducerProducts(@PathVariable String producerName){

        List<Product> products = producerService.findProductsByProducer(producerName);

        ProductList productList = new ProductList();
        productList.productToResource(products);

        return new ResponseEntity<Object>(productList, HttpStatus.OK);
    }
}
