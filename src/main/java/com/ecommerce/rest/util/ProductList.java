package com.ecommerce.rest.util;

import com.ecommerce.core.entities.Product;
import com.ecommerce.rest.resources.ProductResource;
import com.ecommerce.rest.resources.asm.ProductResourceAsm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gennt on 3/3/2017.
 */
public class ProductList {

    private List<ProductResource> products;

    public ProductList() {
        this.products = new ArrayList<>();
    }

    public List<ProductResource> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResource> products) {
        this.products = products;
    }

    public void productToResource(List<Product> ps){
        for (Product p : ps) {
            products.add(new ProductResourceAsm().toResource(p));
        }
    }
}
