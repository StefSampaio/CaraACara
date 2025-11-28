package com.caraacara.model;

public enum CharacterType {
    ANA("Feminino", "Negro(a)", "Olhos castanhos", "Cabelos pretos", "Usa óculos"),
    CARLOS("Masculino", "Negro(a)", "Olhos castanhos", "Cabelos castanhos", "Barba"),
    MARIA("Feminino", "Branco(a)", "Olhos verdes", "Cabelos ruivos", "Sardas"),
    JOAO("Masculino", "Branco(a)", "Olhos castanhos", "Cabelos loiros", "Sem barba"),
    PEDRO("Masculino", "Branco(a)", "Olhos azuis", "Cabelos pretos", "Bigode"),
    JULIA("Feminino", "Branco(a)", "Olhos azuis", "Cabelos loiros", "Brincos grandes"),
    LUCAS("Masculino", "Negro(a)", "Olhos pretos", "Cabelos crespos", "Sem barba"),
    FERNANDA("Feminino", "Branco(a)", "Olhos castanhos", "Cabelos castanhos", "Batom vermelho"),
    RAFAEL("Masculino", "Branco(a)", "Olhos verdes", "Cabelos ruivos", "Barba ruiva"),
    BEATRIZ("Feminino", "Negro(a)", "Olhos castanhos", "Cabelos cacheados", "Piercing no nariz"),
    DIEGO("Masculino", "Branco(a)", "Olhos castanhos", "Cabelos grisalhos", "Cavanhaque"),
    CAMILA("Feminino", "Branco(a)", "Olhos verdes", "Cabelos pretos", "Chapéu"),
    THIAGO("Masculino", "Negro(a)", "Olhos castanhos", "Cabelos raspados", "Tatuagem no pescoço"),
    AMANDA("Feminino", "Branco(a)", "Olhos azuis", "Cabelos castanhos", "Franja"),
    GUSTAVO("Masculino", "Branco(a)", "Olhos castanhos", "Cabelos loiros", "Barba cerrada"),
    LARISSA("Feminino", "Negro(a)", "Olhos pretos", "Cabelos longos", "Colar de pérolas");

    private final String sexo;
    private final String cor;
    private final String olho;
    private final String cabelo;
    private final String detalhe;

    CharacterType(String sexo, String cor, String olho, String cabelo, String detalhe) {
        this.sexo = sexo;
        this.cor = cor;
        this.olho = olho;
        this.cabelo = cabelo;
        this.detalhe = detalhe;
    }

    public String getSexo() { return sexo; }
    public String getCor() { return cor; }
    public String getOlho() { return olho; }
    public String getCabelo() { return cabelo; }
    public String getDetalhe() { return detalhe; }
}