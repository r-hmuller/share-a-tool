package dev.rodrigomuller.DTO.restclient;

import java.util.Objects;

public class KeycloakCredentials {
    private String type;

    private String value;

    public KeycloakCredentials() {
    }

    public KeycloakCredentials(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public KeycloakCredentials type(String type) {
        this.type = type;
        return this;
    }

    public KeycloakCredentials value(String value) {
        this.value = value;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeycloakCredentials that)) return false;
        return Objects.equals(getType(), that.getType()) && Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getValue());
    }
}
