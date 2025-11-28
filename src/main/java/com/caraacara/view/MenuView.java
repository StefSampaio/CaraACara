package com.caraacara.view;

public class MenuView {

    public void printHeader() {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║        🎮 CARA A CARA 🎮            ║");
        System.out.println("║     Adivinhe o Personagem!           ║");
        System.out.println("╚═══════════════════════════════════════╝\n");
    }

    public void printOptions() {
        System.out.println("┌─────────────────────────────────────┐");
        System.out.println("│  MENU PRINCIPAL                     │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1️⃣  Iniciar Novo Jogo             │");
        System.out.println("│  2️⃣  Como Jogar                     │");
        System.out.println("│  3️⃣  Sair                           │");
        System.out.println("└─────────────────────────────────────┘");
    }

    public void printDifficultyOptions() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│  ESCOLHA A DIFICULDADE              │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1️⃣  Fácil (Perguntas ilimitadas)  │");
        System.out.println("│  2️⃣  Médio (10 perguntas)          │");
        System.out.println("│  3️⃣  Difícil (5 perguntas)         │");
        System.out.println("└─────────────────────────────────────┘");
    }

    public void showInstructions() {
        ConsoleHelper.clearScreen();
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║                  📖 COMO JOGAR 📖                        ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");

        System.out.println("🎯 OBJETIVO:");
        System.out.println("   Descubra qual personagem o sistema escolheu aleatoriamente!\n");

        System.out.println("📋 COMO FUNCIONA:");
        System.out.println("   1. Escolha a dificuldade do jogo");
        System.out.println("   2. O sistema escolhe um personagem aleatoriamente");
        System.out.println("   3. Você vê uma lista de características disponíveis");
        System.out.println("   4. Escolha uma característica para perguntar");
        System.out.println("   5. O sistema mostra os personagens removidos");
        System.out.println("   6. Continue fazendo perguntas até descobrir o personagem");
        System.out.println("   7. Quando estiver confiante, dê seu chute!\n");

        System.out.println("🏆 VITÓRIA:");
        System.out.println("   Se você acertar o personagem, você vence!\n");

        System.out.println("🎮 DIFICULDADES:");
        System.out.println("   • Fácil: Perguntas ilimitadas");
        System.out.println("   • Médio: Apenas 10 perguntas");
        System.out.println("   • Difícil: Apenas 5 perguntas\n");

        System.out.println("💡 DICA:");
        System.out.println("   Use estratégia! Escolha características que eliminem");
        System.out.println("   o maior número de personagens possível.\n");
    }

    public void showGameStarting() {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║      🎮 INICIANDO NOVO JOGO 🎮      ║");
        System.out.println("╚═══════════════════════════════════════╝\n");
        System.out.println("🚀 Preparando o jogo...\n");
    }

    public void showExitMessage() {
        System.out.println("\n👋 Obrigado por jogar! Até logo!");
    }

    public void showInvalidOption() {
        System.out.println("\n❌ Opção inválida! Tente novamente.");
    }
}