package com.ecommerce.core.exceptions;

/**
 * Created by gennt on 3/2/2017.
 */
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException() {
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
