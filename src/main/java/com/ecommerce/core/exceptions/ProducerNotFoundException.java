package com.ecommerce.core.exceptions;

/**
 * Created by gennt on 3/2/2017.
 */
public class ProducerNotFoundException extends RuntimeException {

    public ProducerNotFoundException() {
        super();
    }

    public ProducerNotFoundException(String message) {
        super(message);
    }
}
