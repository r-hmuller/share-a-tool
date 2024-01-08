package dev.rodrigomuller.DTO.restclient;

import java.util.Objects;

public class UserResponseDTO {
    private String id;
    private Long createdTimestamp;
    private String username;
    private Boolean enabled;
    private Boolean totp;
    private Boolean emailVerified;
    private String firstName;
    private String lastName;
    private String email;
    private Long notBefore;

    public UserResponseDTO() {
    }

    public UserResponseDTO(String id, Long createdTimestamp, String username, Boolean enabled, Boolean totp, Boolean emailVerified, String firstName, String lastName, String email, Long notBefore) {
        this.id = id;
        this.createdTimestamp = createdTimestamp;
        this.username = username;
        this.enabled = enabled;
        this.totp = totp;
        this.emailVerified = emailVerified;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.notBefore = notBefore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Long createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getTotp() {
        return totp;
    }

    public void setTotp(Boolean totp) {
        this.totp = totp;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNotBefore() {
        return notBefore;
    }

    public void setNotBefore(Long notBefore) {
        this.notBefore = notBefore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserResponseDTO that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCreatedTimestamp(), that.getCreatedTimestamp()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getEnabled(), that.getEnabled()) && Objects.equals(getTotp(), that.getTotp()) && Objects.equals(getEmailVerified(), that.getEmailVerified()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getNotBefore(), that.getNotBefore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreatedTimestamp(), getUsername(), getEnabled(), getTotp(), getEmailVerified(), getFirstName(), getLastName(), getEmail(), getNotBefore());
    }

    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "id='" + id + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", username='" + username + '\'' +
                ", enabled=" + enabled +
                ", totp=" + totp +
                ", emailVerified=" + emailVerified +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", notBefore=" + notBefore +
                '}';
    }
}
