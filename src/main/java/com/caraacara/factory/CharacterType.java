package com.caraacara.factory;

public enum CharacterType {

    ANA("Feminino", "Negro(a)", "Olhos castanhos", "Cabelos pretos", "Usa óculos"),
    CARLOS("Masculino", "Negro(a)","Olhos castanhos", "Cabelos castanhos", "Barba"),
    MARIA("Feminino", "Branco(a)","Olhos verdes", "Cabelos ruivos", "Sardas"),
    JOAO("Masculino", "Branco(a)","Olhos castanhos", "Cabelos loiro", "Sem barba");

    public final String sexo;
    public final String cor;
    public final String olho;
    public final String cabelo;
    public final String detalhe;

    CharacterType(String sexo, String cor, String olho, String cabelo, String detalhe) {
        this.sexo = sexo;
        this.cor = cor;
        this.olho = olho;
        this.cabelo = cabelo;
        this.detalhe = detalhe;
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
}
