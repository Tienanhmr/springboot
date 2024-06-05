package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

public class RoleId implements Serializable {
    private String userId;
    private String role;

    // Default constructor, equals and hashCode methods
    public RoleId() {}

    public RoleId(String userId, String role) {
        this.userId = userId;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleId roleId = (RoleId) o;
        return Objects.equals(userId, roleId.userId) && Objects.equals(role, roleId.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, role);
    }
}
