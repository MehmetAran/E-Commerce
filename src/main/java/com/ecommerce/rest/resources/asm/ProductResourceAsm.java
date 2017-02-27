package com.ecommerce.rest.resources.asm;

import com.ecommerce.core.entities.Product;
import com.ecommerce.rest.controller.CategoryController;
import com.ecommerce.rest.controller.ProducerController;
import com.ecommerce.rest.controller.ProductController;
import com.ecommerce.rest.resources.ProductResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
/**
 * Created by gennt on 2/24/2017.
 */
public class ProductResourceAsm extends ResourceAssemblerSupport<Product, ProductResource> {

    public ProductResourceAsm() {
        super(ProductController.class, ProductResource.class);
    }

    @Override
    public ProductResource toResource(Product product) {

        ProductResource res = new ProductResource();
        res.setDescription(product.getDescription());
        res.setName(product.getName());
        res.setPrice(product.getPrice());
        res.add(linkTo(ProductController.class).slash(product.getId()).withSelfRel());
        res.add(linkTo(CategoryController.class).slash(product.getCategory().getName()).withRel("category"));
        res.add(linkTo(ProducerController.class).slash(product.getProducer().getName()).withRel("producer"));

        return res;
    }
}
