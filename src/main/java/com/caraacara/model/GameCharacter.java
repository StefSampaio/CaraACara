package com.caraacara.model;

import com.caraacara.state.CharacterState;
import com.caraacara.state.ActiveState;

public class GameCharacter {

    private String nome;
    private String sexo;
    private String cor;
    private String olho;
    private String cabelo;
    private String detalhe;

    private CharacterState state;

    public GameCharacter(String nome, String sexo, String cor, String olho, String cabelo, String detalhe) {
        this.nome = nome;
        this.sexo = sexo;
        this.cor = cor;
        this.olho = olho;
        this.cabelo = cabelo;
        this.detalhe = detalhe;
        this.state = new ActiveState(); // estado inicial
    }

    public void activate() { state.activate(this); }
    public void remove()   { state.remove(this); }

    public boolean isActive()  { return state.isActive(); }
    public boolean isRemoved() { return state.isRemoved(); }

    public void setState(CharacterState state) { this.state = state; }
    public CharacterState getState() { return this.state; }

    public String getNome() { return nome; }
    public String getSexo() { return sexo; }
    public String getCor() { return cor; }
    public String getOlho() { return olho; }
    public String getCabelo() { return cabelo; }
    public String getDetalhe() { return detalhe; }

    @Override
    public String toString() {
        return "Personagem: " + nome +
                " | Sexo: " + sexo +
                " | Cor: " + cor +
                " | Olho: " + olho +
                " | Cabelo: " + cabelo +
                " | Característica: " + detalhe +
                " | Estado: " + (isActive() ? "ATIVO" : "REMOVIDO");
    }
}
