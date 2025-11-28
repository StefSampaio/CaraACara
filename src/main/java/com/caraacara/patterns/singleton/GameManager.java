package com.caraacara.patterns.singleton;

import com.caraacara.model.CharacterType;
import com.caraacara.model.GameCharacter;
import com.caraacara.patterns.composite.CharacterComposite;
import com.caraacara.patterns.factory.CharacterFactory;
import com.caraacara.patterns.strategy.DifficultyStrategy;
import com.caraacara.patterns.strategy.EasyStrategy;

import java.util.Random;

public class GameManager {

    private static volatile GameManager instance;

    private boolean gameRunning;
    private CharacterComposite characterComposite;
    private GameCharacter secretCharacter;
    private DifficultyStrategy difficultyStrategy;
    private int questionsAsked;

    private GameManager() {
        this.gameRunning = false;
        this.difficultyStrategy = new EasyStrategy(); // padrão
        this.questionsAsked = 0;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            synchronized (GameManager.class) {
                if (instance == null) {
                    instance = new GameManager();
                }
            }
        }
        return instance;
    }

    public boolean startGame() {
        if (gameRunning) {
            System.out.println("⚠️  Já existe um jogo em execução!");
            return false;
        }

        gameRunning = true;
        questionsAsked = 0;
        initializeGame();
        System.out.println("✅ Jogo iniciado com sucesso!");
        System.out.println("🎯 Dificuldade: " + difficultyStrategy.getDifficultyName());

        if (!difficultyStrategy.hasUnlimitedQuestions()) {
            System.out.println("📊 Perguntas disponíveis: " + difficultyStrategy.getMaxQuestions());
        }

        return true;
    }

    private void initializeGame() {
        characterComposite = new CharacterComposite();

        for (CharacterType type : CharacterType.values()) {
            GameCharacter character = CharacterFactory.createCharacter(type);
            characterComposite.add(character);
        }

        Random random = new Random();
        CharacterType[] types = CharacterType.values();
        CharacterType secretType = types[random.nextInt(types.length)];
        secretCharacter = CharacterFactory.createCharacter(secretType);
    }

    public void endGame() {
        if (gameRunning) {
            gameRunning = false;
            characterComposite = null;
            secretCharacter = null;
            questionsAsked = 0;
            System.out.println("🏁 Jogo finalizado!");
        }
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public CharacterComposite getCharacterComposite() {
        return characterComposite;
    }

    public GameCharacter getSecretCharacter() {
        return secretCharacter;
    }

    public boolean checkGuess(String characterName) {
        return secretCharacter != null &&
                secretCharacter.getNome().equalsIgnoreCase(characterName);
    }

    public void setDifficultyStrategy(DifficultyStrategy strategy) {
        this.difficultyStrategy = strategy;
    }

    public DifficultyStrategy getDifficultyStrategy() {
        return difficultyStrategy;
    }

    public void incrementQuestions() {
        questionsAsked++;
    }

    public int getQuestionsAsked() {
        return questionsAsked;
    }

    public int getRemainingQuestions() {
        if (difficultyStrategy.hasUnlimitedQuestions()) {
            return -1; // infinito
        }
        return difficultyStrategy.getMaxQuestions() - questionsAsked;
    }

    public boolean canAskMoreQuestions() {
        if (difficultyStrategy.hasUnlimitedQuestions()) {
            return true;
        }
        return questionsAsked < difficultyStrategy.getMaxQuestions();
    }
}