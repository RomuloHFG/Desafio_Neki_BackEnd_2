package com.example.login_auth_api.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private String id;
    private String name;
    private String email;
    private String password;
}

//As anotações do Lombok são utilizadas para gerar automaticamente os métodos getters, setters e os construtores.
//As anotações JPA são utilizadas para mapear a classe User para uma tabela no banco de dados chamada users,
//com o campo id gerado automaticamente como um UUID.
