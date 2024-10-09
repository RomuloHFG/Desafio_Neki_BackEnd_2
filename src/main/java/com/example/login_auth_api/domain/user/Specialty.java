package com.example.login_auth_api.domain.user;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Data
@Entity
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "Name is required")
    private String name;
}

//A entidade Specialty é mapeada para uma tabela no banco de dados e inclui regras de
//validação para garantir que todos os dados necessários sejam fornecidos.
