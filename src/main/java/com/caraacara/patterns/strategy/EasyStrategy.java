package com.caraacara.patterns.strategy;

public class EasyStrategy implements DifficultyStrategy {

    @Override
    public int getMaxQuestions() {
        return -1; // -1 = infinito
    }

    @Override
    public String getDifficultyName() {
        return "Fácil";
    }

    @Override
    public boolean hasUnlimitedQuestions() {
        return true;
    }
}