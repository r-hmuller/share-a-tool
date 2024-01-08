package dev.rodrigomuller.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Tool {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Double price;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "valid_from")
    private Date validFrom;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "valid_to")
    private Date validTo;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany
    private Set<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Customer owner;

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tool tool)) return false;
        return Objects.equals(getId(), tool.getId()) && Objects.equals(getName(), tool.getName()) && Objects.equals(getDescription(), tool.getDescription()) && Objects.equals(getPrice(), tool.getPrice()) && Objects.equals(getValidFrom(), tool.getValidFrom()) && Objects.equals(getValidTo(), tool.getValidTo()) && Objects.equals(getCreatedAt(), tool.getCreatedAt()) && Objects.equals(getUpdatedAt(), tool.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice(), getValidFrom(), getValidTo(), getCreatedAt(), getUpdatedAt());
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
