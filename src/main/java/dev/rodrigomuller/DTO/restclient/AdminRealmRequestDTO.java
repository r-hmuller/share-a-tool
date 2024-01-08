package dev.rodrigomuller.DTO.restclient;

import jakarta.ws.rs.FormParam;

import java.util.Objects;

public class AdminRealmRequestDTO {
    @FormParam("username")
    private String username;
    @FormParam("password")
    private String password;
    @FormParam("grant_type")
    private String grant_type;
    @FormParam("client_id")
    private String client_id;

    public AdminRealmRequestDTO() {
    }

    public AdminRealmRequestDTO(String username, String password, String grant_type, String client_id) {
        this.username = username;
        this.password = password;
        this.grant_type = grant_type;
        this.client_id = client_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminRealmRequestDTO that)) return false;
        return Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getGrant_type(), that.getGrant_type()) && Objects.equals(getClient_id(), that.getClient_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword(), getGrant_type(), getClient_id());
    }

    @Override
    public String toString() {
        return "AdminRealmRequestDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", grant_type='" + grant_type + '\'' +
                ", client_id='" + client_id + '\'' +
                '}';
    }
}
