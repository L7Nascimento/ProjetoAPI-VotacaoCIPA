package com.estudo.cipa.votacao.model;

public class Candidato {
    private int numero;
    private String nome;
    private String setor;
    private String foto;

    // construtor
    public Candidato( int numero, String nome, String setor, String foto){
        this.numero = numero;
        this.nome = nome;
        this.setor = setor;
        this.foto = foto;
    }
    // Getters e Setters
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }

    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }

}
