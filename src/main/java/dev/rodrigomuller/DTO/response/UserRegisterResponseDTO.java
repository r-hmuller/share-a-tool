package dev.rodrigomuller.DTO.response;

import java.util.Objects;

public class UserRegisterResponseDTO {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String role;

    public UserRegisterResponseDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRegisterResponseDTO that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getSurname(), that.getSurname()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getRole(), that.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getEmail(), getRole());
    }

    @Override
    public String toString() {
        return "UserRegisterResponseDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
