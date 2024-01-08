package dev.rodrigomuller.DTO.restclient;

import java.util.Objects;

public class RoleResponseDTO {
    private String id;
    private String name;
    private String description;
    private boolean composite;
    private boolean clientRole;
    private String containerId;

    public RoleResponseDTO() {
    }

    public RoleResponseDTO(String id, String name, String description, boolean composite, boolean clientRole, String containerId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.composite = composite;
        this.clientRole = clientRole;
        this.containerId = containerId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComposite() {
        return composite;
    }

    public void setComposite(boolean composite) {
        this.composite = composite;
    }

    public boolean isClientRole() {
        return clientRole;
    }

    public void setClientRole(boolean clientRole) {
        this.clientRole = clientRole;
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleResponseDTO that)) return false;
        return isComposite() == that.isComposite() && isClientRole() == that.isClientRole() && Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getContainerId(), that.getContainerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), isComposite(), isClientRole(), getContainerId());
    }

    @Override
    public String toString() {
        return "RoleResponseDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", composite=" + composite +
                ", clientRole=" + clientRole +
                ", containerId='" + containerId + '\'' +
                '}';
    }
}
