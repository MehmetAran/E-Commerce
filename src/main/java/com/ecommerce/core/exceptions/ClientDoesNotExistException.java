package com.ecommerce.core.exceptions;

/**
 * Created by gennt on 2/24/2017.
 */
public class ClientDoesNotExistException extends RuntimeException {

    public ClientDoesNotExistException() {
        super();
    }

    public ClientDoesNotExistException(String message) {
        super(message);
    }

    public ClientDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientDoesNotExistException(Throwable cause) {
        super(cause);
    }

    protected ClientDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
