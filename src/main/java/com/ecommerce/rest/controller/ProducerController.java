package com.ecommerce.rest.controller;

import com.ecommerce.core.entities.Producer;
import com.ecommerce.core.services.ProducerService;
import com.ecommerce.rest.resources.ProducerResource;
import com.ecommerce.rest.resources.asm.ProducerResourceAsm;
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
@RequestMapping("/api/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping("/{producerName}")
    public ResponseEntity<?> getProdcerByName(@PathVariable String producerName){

        Producer p = producerService.findByName(producerName.toLowerCase());

        ProducerResource res = new ProducerResourceAsm().toResource(p);

        return new ResponseEntity<ProducerResource>(res, HttpStatus.OK);
    }

}
