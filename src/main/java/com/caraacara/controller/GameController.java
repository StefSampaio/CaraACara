package com.caraacara.controller;

import com.caraacara.model.GameCharacter;
import com.caraacara.patterns.composite.CharacterComposite;
import com.caraacara.patterns.singleton.GameManager;
import com.caraacara.view.ConsoleHelper;
import com.caraacara.view.GameView;

import java.util.*;

public class GameController {

    private GameView view;
    private GameManager gameManager;
    private CharacterComposite composite;
    private GameCharacter secretCharacter;

    public GameController() {
        this.view = new GameView();
        this.gameManager = GameManager.getInstance();
        this.composite = gameManager.getCharacterComposite();
        this.secretCharacter = gameManager.getSecretCharacter();
    }

    public void start() {
        boolean playing = true;

        while (playing) {
            if (!gameManager.canAskMoreQuestions()) {
                ConsoleHelper.clearScreen();
                System.out.println("\n⚠️  SUAS PERGUNTAS ACABARAM!");
                System.out.println("🎯 Hora do chute final obrigatório!\n");
                ConsoleHelper.waitForEnter();

                playing = handleGuess();
                break;
            }

            ConsoleHelper.clearScreen();
            view.showGameHeader();

            view.showRemainingQuestions(gameManager.getRemainingQuestions());

            List<GameCharacter> allCharacters = composite.getTodosPersonagens();
            view.showCharacters(allCharacters);

            List<GameCharacter> removed = getRemovedCharacters();
            view.showRemovedCharacters(removed);

            int activeCount = composite.getTotalAtivos();
            view.showActiveCharactersCount(activeCount);

            if (activeCount == 1) {
                System.out.println("\n🎯 Sobrou apenas 1 personagem! Hora de chutar!");
                ConsoleHelper.waitForEnter();
                playing = handleGuess();
                continue;
            }

            Set<String> attributes = getAvailableAttributes();
            view.showAvailableAttributes(attributes);

            String choice = ConsoleHelper.readLine("\n👉 Escolha uma opção (número): ");

            if (choice.equals("0")) {
                playing = handleGuess();
            } else {
                try {
                    int index = Integer.parseInt(choice);
                    if (index > 0 && index <= attributes.size()) {
                        String selectedAttribute = getAttributeByIndex(attributes, index);
                        processQuestion(selectedAttribute);
                        ConsoleHelper.waitForEnter();
                    } else {
                        view.showInvalidChoice();
                        ConsoleHelper.waitForEnter();
                    }
                } catch (NumberFormatException e) {
                    view.showInvalidChoice();
                    ConsoleHelper.waitForEnter();
                }
            }
        }
    }

    private void processQuestion(String attribute) {
        gameManager.incrementQuestions();

        boolean secretHasAttribute = checkSecretCharacterHasAttribute(attribute);
        view.showAnswer(secretHasAttribute, attribute);

        List<GameCharacter> toRemove = new ArrayList<>();

        for (GameCharacter character : composite.getPersonagensAtivos()) {
            boolean characterHasAttribute = characterHasAttribute(character, attribute);

            if (secretHasAttribute != characterHasAttribute) {
                toRemove.add(character);
            }
        }

        for (GameCharacter character : toRemove) {
            character.remove();
        }

        System.out.println("\n🗑️  " + toRemove.size() + " personagem(ns) eliminado(s)!");
    }

    private boolean handleGuess() {
        List<GameCharacter> activeCharacters = composite.getPersonagensAtivos();

        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│              🎯 HORA DO CHUTE FINAL! 🎯                │");
        System.out.println("├─────────────────────────────────────────────────────────┤");

        int count = 1;
        for (GameCharacter character : activeCharacters) {
            System.out.printf("│  %d. %-52s │%n", count++, character.getNome());
        }

        System.out.println("└─────────────────────────────────────────────────────────┘");

        String choice = ConsoleHelper.readLine("\n👉 Qual é o personagem? (número): ");

        try {
            int index = Integer.parseInt(choice);
            if (index > 0 && index <= activeCharacters.size()) {
                GameCharacter guessedCharacter = activeCharacters.get(index - 1);

                if (gameManager.checkGuess(guessedCharacter.getNome())) {
                    view.showVictory(secretCharacter.getNome());
                } else {
                    view.showDefeat(secretCharacter.getNome());
                }

                ConsoleHelper.waitForEnter();
                return false;
            } else {
                view.showInvalidChoice();
                ConsoleHelper.waitForEnter();
                return true;
            }
        } catch (NumberFormatException e) {
            view.showInvalidChoice();
            ConsoleHelper.waitForEnter();
            return true;
        }
    }

    private Set<String> getAvailableAttributes() {
        Set<String> attributes = new LinkedHashSet<>();
        List<GameCharacter> activeCharacters = composite.getPersonagensAtivos();

        Map<String, Integer> attributeCount = new HashMap<>();

        for (GameCharacter character : activeCharacters) {
            countAttribute(attributeCount, character.getSexo());
            countAttribute(attributeCount, character.getCor());
            countAttribute(attributeCount, character.getOlho());
            countAttribute(attributeCount, character.getCabelo());
            countAttribute(attributeCount, character.getDetalhe());
        }

        for (Map.Entry<String, Integer> entry : attributeCount.entrySet()) {
            if (entry.getValue() > 1) {
                attributes.add(entry.getKey());
            }
        }

        return attributes;
    }

    private void countAttribute(Map<String, Integer> map, String attribute) {
        map.put(attribute, map.getOrDefault(attribute, 0) + 1);
    }

    private String getAttributeByIndex(Set<String> attributes, int index) {
        int count = 1;
        for (String attr : attributes) {
            if (count == index) {
                return attr;
            }
            count++;
        }
        return null;
    }

    private boolean checkSecretCharacterHasAttribute(String attribute) {
        return characterHasAttribute(secretCharacter, attribute);
    }

    private boolean characterHasAttribute(GameCharacter character, String attribute) {
        return character.getSexo().equalsIgnoreCase(attribute) ||
                character.getCor().equalsIgnoreCase(attribute) ||
                character.getOlho().equalsIgnoreCase(attribute) ||
                character.getCabelo().equalsIgnoreCase(attribute) ||
                character.getDetalhe().equalsIgnoreCase(attribute);
    }

    private List<GameCharacter> getRemovedCharacters() {
        List<GameCharacter> removed = new ArrayList<>();
        for (GameCharacter character : composite.getTodosPersonagens()) {
            if (character.isRemoved()) {
                removed.add(character);
            }
        }
        return removed;
    }
}