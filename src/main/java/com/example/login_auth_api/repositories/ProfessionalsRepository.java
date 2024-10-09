package com.example.login_auth_api.repositories;

import com.example.login_auth_api.domain.user.Professionals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalsRepository extends JpaRepository<Professionals, Long> {
}