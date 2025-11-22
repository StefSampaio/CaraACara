package com.caraacara.screens;

import com.caraacara.singleton.GameManager;

import java.util.Scanner;


public class MenuScreen {
    
    private Scanner scanner;
    private GameManager gameManager;
    
    public MenuScreen() {
        this.scanner = new Scanner(System.in);
        this.gameManager = GameManager.getInstance();
    }

    public void displayMenu() {
        boolean running = true;
        
        while (running) {
            clearScreen();
            printHeader();
            printOptions();
            
            System.out.print("\n👉 Escolha uma opção: ");
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    startNewGame();
                    break;
                case "2":
                    showInstructions();
                    break;
                case "3":
                    running = false;
                    System.out.println("\n👋 Obrigado por jogar! Até logo!");
                    break;
                default:
                    System.out.println("\n❌ Opção inválida! Tente novamente.");
                    waitForEnter();
            }
        }
        
        scanner.close();
    }
    
    /**
     * Inicia um novo jogo.
     */
    private void startNewGame() {
        clearScreen();
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║      🎮 INICIANDO NOVO JOGO 🎮      ║");
        System.out.println("╚═══════════════════════════════════════╝\n");
        
        if (gameManager.startGame()) {
            System.out.println("🚀 Preparando o jogo...\n");
            waitForEnter();
            
            // TODO: Aqui será chamada a GameScreen quando implementada
            // GameScreen gameScreen = new GameScreen();
            // gameScreen.start();
            
            System.out.println("⚠️  A tela do jogo será implementada em breve!");
            waitForEnter();
            
            gameManager.endGame();
        } else {
            waitForEnter();
        }
    }
    

    private void showInstructions() {
        clearScreen();
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║                  📖 COMO JOGAR 📖                        ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");
        
        System.out.println("🎯 OBJETIVO:");
        System.out.println("   Descubra qual personagem o sistema escolheu aleatoriamente!\n");
        
        System.out.println("📋 COMO FUNCIONA:");
        System.out.println("   1. O sistema escolhe um personagem aleatoriamente");
        System.out.println("   2. Você vê uma lista de características disponíveis");
        System.out.println("   3. Escolha uma característica para perguntar");
        System.out.println("   4. O sistema mostra os personagens removidos");
        System.out.println("   5. Continue fazendo perguntas até descobrir o personagem");
        System.out.println("   6. Quando estiver confiante, dê seu chute!\n");
        
        System.out.println("🏆 VITÓRIA:");
        System.out.println("   Se você acertar o personagem, você vence!\n");
        
        System.out.println("💡 DICA:");
        System.out.println("   Use estratégia! Escolha características que eliminem");
        System.out.println("   o maior número de personagens possível.\n");
        
        waitForEnter();
    }
    

    private void printHeader() {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║        🎮 CARA A CARA 🎮            ║");
        System.out.println("║     Adivinhe o Personagem!           ║");
        System.out.println("╚═══════════════════════════════════════╝\n");
    }
    

    private void printOptions() {
        System.out.println("┌─────────────────────────────────────┐");
        System.out.println("│  MENU PRINCIPAL                     │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1️⃣  Iniciar Novo Jogo             │");
        System.out.println("│  2️⃣  Como Jogar                     │");
        System.out.println("│  3️⃣  Sair                           │");
        System.out.println("└─────────────────────────────────────┘");
    }
    

    private void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Se não conseguir limpar, apenas imprime algumas linhas em branco
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
    

    private void waitForEnter() {
        System.out.print("\n⏎ Pressione Enter para continuar...");
        scanner.nextLine();
    }
}
