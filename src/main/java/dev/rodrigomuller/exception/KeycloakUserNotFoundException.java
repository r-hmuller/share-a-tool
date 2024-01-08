package dev.rodrigomuller.exception;

import java.io.Serial;
import java.io.Serializable;

public class KeycloakUserNotFoundException extends
        RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public KeycloakUserNotFoundException() {
    }

    public KeycloakUserNotFoundException(String message) {
        super(message);
    }
}
