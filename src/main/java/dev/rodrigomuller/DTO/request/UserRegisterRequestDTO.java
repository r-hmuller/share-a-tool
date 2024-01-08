package dev.rodrigomuller.DTO.request;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class UserRegisterRequestDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 255)
    private String password;

    @NotBlank
    @Size(min = 6, max = 255)
    private String passwordConfirm;

    @AssertTrue(message = "Password and password confirm must be the same")
    private boolean isValid() {
        return this.password.equals(this.passwordConfirm);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRegisterRequestDTO that)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getSurname(), that.getSurname()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getPasswordConfirm(), that.getPasswordConfirm());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getUsername(), getEmail(), getPassword(), getPasswordConfirm());
    }

    @Override
    public String toString() {
        return "UserRegisterRequestDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                '}';
    }
}
