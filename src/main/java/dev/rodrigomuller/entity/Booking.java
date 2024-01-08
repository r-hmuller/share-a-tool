package dev.rodrigomuller.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Tool tool;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Customer customer;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "from_date")
    private Date from;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "to_date")
    private Date to;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;

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

    public Tool getOffer() {
        return tool;
    }

    public void setOffer(Tool tool) {
        this.tool = tool;
    }

    public Customer getUser() {
        return customer;
    }

    public void setUser(Customer customer) {
        this.customer = customer;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;
        return Objects.equals(getId(), booking.getId()) && Objects.equals(getOffer(), booking.getOffer()) && Objects.equals(getUser(), booking.getUser()) && Objects.equals(getFrom(), booking.getFrom()) && Objects.equals(getTo(), booking.getTo()) && getStatus() == booking.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOffer(), getUser(), getFrom(), getTo(), getStatus());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", offer=" + tool +
                ", user=" + customer +
                ", from=" + from +
                ", to=" + to +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
