package com.ecommerce.rest.util;

import com.ecommerce.core.entities.Product;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gennt on 2/26/2017.
 */
public class ProductSet {

    private HashSet<Product> products;

    public HashSet<Product> getProducts() {
        return products;
    }

    public void setProducts(HashSet<Product> products) {
        this.products = products;
    }
}
