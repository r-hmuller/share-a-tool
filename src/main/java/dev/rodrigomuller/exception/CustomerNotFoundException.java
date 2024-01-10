package dev.rodrigomuller.exception;

import java.io.Serial;
import java.io.Serializable;

public class CustomerNotFoundException extends
        RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
