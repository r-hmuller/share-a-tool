package dev.rodrigomuller.repository;

import dev.rodrigomuller.entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
    public Optional<Customer> findByKeycloakId(String id) {
        return find("keycloakId", id).firstResultOptional();
    }
}
