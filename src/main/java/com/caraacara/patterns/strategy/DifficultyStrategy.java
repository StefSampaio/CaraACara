package com.caraacara.patterns.strategy;

public interface DifficultyStrategy {
    int getMaxQuestions();
    String getDifficultyName();
    boolean hasUnlimitedQuestions();
}