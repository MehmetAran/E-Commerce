package com.ecommerce.core.exceptions;

/**
 * Created by gennt on 2/24/2017.
 */
public class CategoryExistsException extends RuntimeException {

    public CategoryExistsException() {
    }

    public CategoryExistsException(String message) {
        super(message);
    }

    public CategoryExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryExistsException(Throwable cause) {
        super(cause);
    }

    protected CategoryExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
