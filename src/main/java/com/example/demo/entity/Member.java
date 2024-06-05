package com.example.demo.entity;

@Entity
public class Member {
    @Id
    private String userId;
    private String password;
    private boolean isActive;

    // Getters and Setters
}
