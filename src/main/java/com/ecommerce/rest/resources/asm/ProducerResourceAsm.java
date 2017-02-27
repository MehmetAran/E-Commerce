package com.ecommerce.rest.resources.asm;

import com.ecommerce.core.entities.Producer;
import com.ecommerce.rest.controller.ProducerController;
import com.ecommerce.rest.resources.ProducerResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by gennt on 2/26/2017.
 */
public class ProducerResourceAsm extends ResourceAssemblerSupport<Producer, ProducerResource> {

    public ProducerResourceAsm() {
        super(ProducerController.class, ProducerResource.class);
    }

    @Override
    public ProducerResource toResource(Producer producer) {
        ProducerResource res = new ProducerResource();
        res.setCountry(producer.getCountry());
        res.setName(producer.getCountry());
        res.add(linkTo(ProducerController.class).slash(producer.getName()).withSelfRel());
        return res;
    }
}
