package com.ecommerce.core.exceptions;

/**
 * Created by gennt on 2/24/2017.
 */
public class ProductDoesNotExistException extends RuntimeException {

    public ProductDoesNotExistException() {
        super();
    }

    public ProductDoesNotExistException(String message) {
        super(message);
    }

    public ProductDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductDoesNotExistException(Throwable cause) {
        super(cause);
    }

    protected ProductDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
