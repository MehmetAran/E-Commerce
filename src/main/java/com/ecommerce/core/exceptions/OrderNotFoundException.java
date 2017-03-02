package com.ecommerce.core.exceptions;

/**
 * Created by gennt on 3/2/2017.
 */
public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException() {
    }

    public OrderNotFoundException(String message) {
        super(message);
    }
}
