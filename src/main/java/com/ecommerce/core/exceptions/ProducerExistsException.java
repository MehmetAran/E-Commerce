package com.ecommerce.core.exceptions;

/**
 * Created by gennt on 2/24/2017.
 */
public class ProducerExistsException extends RuntimeException {

    public ProducerExistsException() {
    }

    public ProducerExistsException(String message) {
        super(message);
    }

    public ProducerExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProducerExistsException(Throwable cause) {
        super(cause);
    }

    protected ProducerExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
