package com.example.login_auth_api.controllers;

import com.example.login_auth_api.domain.user.Specialty;
import com.example.login_auth_api.repositories.SpecialtyRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/specialties")
@SecurityRequirement(name = "jwt")
public class SpecialtyController {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @GetMapping
    public ResponseEntity<List<Specialty>> getAllSpecialties() {
        List<Specialty> specialties = specialtyRepository.findAll();
        return ResponseEntity.ok(specialties);
    }
}
