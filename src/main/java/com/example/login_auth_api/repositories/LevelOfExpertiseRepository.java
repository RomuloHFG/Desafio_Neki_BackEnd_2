package com.example.login_auth_api.repositories;


import com.example.login_auth_api.domain.user.LevelOfExpertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelOfExpertiseRepository extends JpaRepository<LevelOfExpertise, Long> {
}