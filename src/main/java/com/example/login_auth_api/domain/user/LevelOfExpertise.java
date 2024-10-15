package com.example.login_auth_api.domain.user;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Data
@Entity
public class LevelOfExpertise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "Name is required")
    private String name;
}

