package com.caraacara.controller;

import com.caraacara.patterns.singleton.GameManager;
import com.caraacara.patterns.strategy.*;
import com.caraacara.view.ConsoleHelper;
import com.caraacara.view.MenuView;

public class MenuController {
    private MenuView view;
    private GameManager gameManager;

    public MenuController() {
        this.view = new MenuView();
        this.gameManager = GameManager.getInstance();
    }

    public void start() {
        boolean running = true;

        while (running) {
            ConsoleHelper.clearScreen();
            view.printHeader();
            view.printOptions();

            String choice = ConsoleHelper.readLine("\n👉 Escolha uma opção: ");

            switch (choice) {
                case "1":
                    chooseDifficultyAndStartGame();
                    break;
                case "2":
                    showInstructions();
                    break;
                case "3":
                    running = false;
                    view.showExitMessage();
                    break;
                default:
                    view.showInvalidOption();
                    ConsoleHelper.waitForEnter();
            }
        }

        ConsoleHelper.closeScanner();
    }

    private void chooseDifficultyAndStartGame() {
        ConsoleHelper.clearScreen();
        view.printHeader();
        view.printDifficultyOptions();

        String choice = ConsoleHelper.readLine("\n👉 Escolha a dificuldade: ");

        DifficultyStrategy strategy = null;

        switch (choice) {
            case "1":
                strategy = new EasyStrategy();
                break;
            case "2":
                strategy = new MediumStrategy();
                break;
            case "3":
                strategy = new HardStrategy();
                break;
            default:
                view.showInvalidOption();
                ConsoleHelper.waitForEnter();
                return;
        }

        gameManager.setDifficultyStrategy(strategy);
        startNewGame();
    }

    private void startNewGame() {
        ConsoleHelper.clearScreen();
        view.showGameStarting();

        if (gameManager.startGame()) {
            ConsoleHelper.waitForEnter();

            GameController gameController = new GameController();
            gameController.start();

            gameManager.endGame();
        } else {
            ConsoleHelper.waitForEnter();
        }
    }

    private void showInstructions() {
        view.showInstructions();
        ConsoleHelper.waitForEnter();
    }
}