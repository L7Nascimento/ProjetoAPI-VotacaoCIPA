package com.estudo.cipa.votacao.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Candidato extends Funcionario {

    private String proposta;
    private int numero; // número de identificação na urna
}
