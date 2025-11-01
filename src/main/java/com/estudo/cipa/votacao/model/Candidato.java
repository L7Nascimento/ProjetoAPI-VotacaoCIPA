package com.estudo.cipa.votacao.model;

import jakarta.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidato extends Funcionario {

    private Integer numero;
    private String partido;
}
