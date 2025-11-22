package com.caraacara.factory;

public class GameCharacter {

    private final String nome;
    private final String sexo;
    private final String cor;
    private final String olho;
    private final String cabelo;
    private final String detalhe;

    public GameCharacter(String nome, String sexo, String cor, String olho, String cabelo, String detalhe) {
        this.nome = nome;
        this.sexo = sexo;
        this.cor = cor;
        this.olho = olho;
        this.cabelo = cabelo;
        this.detalhe = detalhe;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCor() {
        return cor;
    }

    public String getOlho() {
        return olho;
    }

    public String getCabelo() {
        return cabelo;
    }

    public String getDetalhe() {
        return detalhe;
    }

    @Override
    public String toString() {
        return "Personagem: " + nome +
                " | Sexo: " + sexo +
                " | Cor: " + cor +
                " | Olho: " + olho +
                " | Cabelo: " + cabelo +
                " | Característica: " + detalhe;
    }
}

