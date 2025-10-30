package com.estudo.cipa.votacao.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private String nome;
    private String setor;
    private String fotoUrl; // Link para a foto do candidato

    public Candidato() {}

    public Candidato(int numero, String nome, String setor, String fotoUrl) {
        this.numero = numero;
        this.nome = nome;
        this.setor = setor;
        this.fotoUrl = fotoUrl;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }

    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
}
