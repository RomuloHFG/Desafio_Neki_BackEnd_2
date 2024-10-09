package com.example.login_auth_api.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Professionals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required")
    private String name;

    @ManyToOne
    @JoinColumn(name = "specialty_id", nullable = false)
    @NotNull(message = "Specialty is required")
    private Specialty specialty;

    @ManyToOne
    @JoinColumn(name = "level_of_expertise_id", nullable = false)
    @NotNull(message = "Level of Expertise is required")
    private LevelOfExpertise levelOfExpertise;

    @NotEmpty(message = "Address is required")
    private String address;

    @NotEmpty(message = "Phone is required")
    private String phone;

    @Lob
    private byte[] photo;
}

//Este código define a estrutura e as regras básicas de validação para a entidade Professionals,
//que será usada para persistir dados no banco de dados,
//incluindo relacionamentos com outras entidades (Specialty e LevelOfExpertise) e validações para assegurar que os campos
//obrigatórios sejam preenchidos corretamente.