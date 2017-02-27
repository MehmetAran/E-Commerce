package com.ecommerce.rest.resources.asm;

import com.ecommerce.core.entities.Category;
import com.ecommerce.rest.controller.CategoryController;
import com.ecommerce.rest.resources.CategoryResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
/**
 * Created by gennt on 2/26/2017.
 */
public class CategoryResourceAsm extends ResourceAssemblerSupport<Category, CategoryResource> {

    public CategoryResourceAsm() {
        super(CategoryController.class, CategoryResource.class);
    }

    @Override
    public CategoryResource toResource(Category category) {
        CategoryResource res = new CategoryResource();
        res.setName(category.getName());
        res.add(linkTo(CategoryController.class).slash(category.getName()).withSelfRel());
        return res;
    }
}
