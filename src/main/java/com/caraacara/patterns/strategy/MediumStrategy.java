package com.caraacara.patterns.strategy;

public class MediumStrategy implements DifficultyStrategy {

    @Override
    public int getMaxQuestions() {
        return 10;
    }

    @Override
    public String getDifficultyName() {
        return "Médio";
    }

    @Override
    public boolean hasUnlimitedQuestions() {
        return false;
    }
}