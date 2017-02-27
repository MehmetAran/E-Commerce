package com.ecommerce.core.exceptions;

/**
 * Created by gennt on 2/24/2017.
 */
public class ProductExistsException extends RuntimeException {
    public ProductExistsException() {
        super();
    }

    public ProductExistsException(String message) {
        super(message);
    }

    public ProductExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductExistsException(Throwable cause) {
        super(cause);
    }

    protected ProductExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
