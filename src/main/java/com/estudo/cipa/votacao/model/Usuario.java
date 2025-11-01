package com.estudo.cipa.votacao.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Usuario extends Funcionario {

    private String login;
    private String senha;
    private String papel; // ex: "ADMIN" ou "GESTOR"
}
