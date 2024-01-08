package dev.rodrigomuller.DTO.restclient;

import java.util.Objects;
import java.util.Set;

public class CreateUserRequestDTO {
    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private Boolean enabled;

    private Set<String> realmRoles;

    private Set<KeycloakCredentials> credentials;

    public CreateUserRequestDTO() {
    }

    public CreateUserRequestDTO(String firstName, String lastName, String username, String email, Boolean enabled, Set<String> realmRoles, Set<KeycloakCredentials> credentials) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.realmRoles = realmRoles;
        this.credentials = credentials;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<String> getRealmRoles() {
        return realmRoles;
    }

    public void setRealmRoles(Set<String> realmRoles) {
        this.realmRoles = realmRoles;
    }

    public Set<KeycloakCredentials> getCredentials() {
        return credentials;
    }

    public void setCredentials(Set<KeycloakCredentials> credentials) {
        this.credentials = credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateUserRequestDTO that)) return false;
        return Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getEnabled(), that.getEnabled()) && Objects.equals(getRealmRoles(), that.getRealmRoles()) && Objects.equals(getCredentials(), that.getCredentials());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getUsername(), getEmail(), getEnabled(), getRealmRoles(), getCredentials());
    }
}
