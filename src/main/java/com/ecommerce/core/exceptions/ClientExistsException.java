package com.ecommerce.core.exceptions;

/**
 * Created by gennt on 2/24/2017.
 */
public class ClientExistsException extends RuntimeException {
    public ClientExistsException() {
        super();
    }

    public ClientExistsException(String message) {
        super(message);
    }

    public ClientExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientExistsException(Throwable cause) {
        super(cause);
    }

    protected ClientExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
