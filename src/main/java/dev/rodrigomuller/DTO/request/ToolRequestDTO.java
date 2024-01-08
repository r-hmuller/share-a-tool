package dev.rodrigomuller.DTO.request;

import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.Objects;

public class ToolRequestDTO {
    @NotBlank
    private String name;
    private String description;
    @Positive
    @NotNull
    private Double price;
    @FutureOrPresent
    @NotNull
    private Date validFrom;
    @Future
    @NotNull
    private Date validTo;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToolRequestDTO that)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getPrice(), that.getPrice()) && Objects.equals(getValidFrom(), that.getValidFrom()) && Objects.equals(getValidTo(), that.getValidTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getPrice(), getValidFrom(), getValidTo());
    }

    @Override
    public String toString() {
        return "OfferResponseDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                '}';
    }
}
