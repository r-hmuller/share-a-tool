package dev.rodrigomuller.exception;

import java.io.Serial;
import java.io.Serializable;

public class KeycloakRoleNotFoundException extends
        RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public KeycloakRoleNotFoundException() {
    }

    public KeycloakRoleNotFoundException(String message) {
        super(message);
    }
}
