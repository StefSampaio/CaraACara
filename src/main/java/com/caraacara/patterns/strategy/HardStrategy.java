package com.caraacara.patterns.strategy;

public class HardStrategy implements DifficultyStrategy {

    @Override
    public int getMaxQuestions() {
        return 5;
    }

    @Override
    public String getDifficultyName() {
        return "Difícil";
    }

    @Override
    public boolean hasUnlimitedQuestions() {
        return false;
    }
}