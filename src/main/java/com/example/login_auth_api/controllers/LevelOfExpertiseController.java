package com.example.login_auth_api.controllers;

import com.example.login_auth_api.domain.user.LevelOfExpertise;
import com.example.login_auth_api.repositories.LevelOfExpertiseRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/levelsofexpertise")
@SecurityRequirement(name = "jwt")
public class LevelOfExpertiseController {

    @Autowired
    private LevelOfExpertiseRepository levelOfExpertiseRepository;

    @GetMapping
    public ResponseEntity<List<LevelOfExpertise>> getAllLevelOfExpertise() {
        List<LevelOfExpertise> levelsOfExpertise = levelOfExpertiseRepository.findAll();
        return ResponseEntity.ok(levelsOfExpertise);
    }
}
