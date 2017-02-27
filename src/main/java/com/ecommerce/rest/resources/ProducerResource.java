package com.ecommerce.rest.resources;

import com.ecommerce.core.entities.Producer;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by gennt on 2/24/2017.
 */
public class ProducerResource extends ResourceSupport {

    private String name;

    private String country;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Producer toProducer(){
        Producer p = new Producer();
        p.setName(this.name);
        p.setCountry(this.country);
        return p;
    }
}
