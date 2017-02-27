package com.ecommerce.rest.resources;

import com.ecommerce.core.entities.Product;
import org.springframework.hateoas.ResourceSupport;

import java.util.Set;

/**
 * Created by gennt on 2/24/2017.
 */
public class ProductResource extends ResourceSupport {


    private String name;

    private double price;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product toProduct(){
        Product product = new Product();

        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);

        return product;
    }
}