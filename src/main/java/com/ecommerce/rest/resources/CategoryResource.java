package com.ecommerce.rest.resources;

import com.ecommerce.core.entities.Category;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by gennt on 2/24/2017.
 */
public class CategoryResource extends ResourceSupport {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category toCategory(){
        Category c = new Category();
        c.setName(this.name);
        return c;
    }
}
