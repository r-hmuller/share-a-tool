package dev.rodrigomuller.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "keycloak_id")
    private String keycloakId;
    private String name;
    private String surname;
    private String email;

    @OneToMany
    private Set<Booking> bookings;

    @OneToMany
    private Set<Tool> tools;

    public Customer() {
    }

    public Customer(Long id, String keycloakId, String name, String surname, String email) {
        this.id = id;
        this.keycloakId = keycloakId;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeycloakId() {
        return keycloakId;
    }

    public void setKeycloakId(String keycloakId) {
        this.keycloakId = keycloakId;
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

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Set<Tool> getTools() {
        return tools;
    }

    public void setTools(Set<Tool> tools) {
        this.tools = tools;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(getId(), customer.getId()) && Objects.equals(getKeycloakId(), customer.getKeycloakId()) && Objects.equals(getName(), customer.getName()) && Objects.equals(getSurname(), customer.getSurname()) && Objects.equals(getEmail(), customer.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getKeycloakId(), getName(), getSurname(), getEmail());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", keycloakId='" + keycloakId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
