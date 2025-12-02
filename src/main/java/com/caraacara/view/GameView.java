package com.caraacara.view;

import com.caraacara.model.GameCharacter;

import java.util.List;
import java.util.Set;

public class GameView {

    public void showGameHeader() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║                  🎮 CARA A CARA - JOGO 🎮                ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");
    }

    public void showCharacters(List<GameCharacter> characters) {
        System.out.println("┌──────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                 👥  P E R S O N A G E N S   D I S P O N Í V E I S  👥               │");
        System.out.println("├──────────────────────────────────────────────────────────────────────────────────────┤");

        System.out.printf("│ %-3s %-12s │ %-10s │ %-10s │ %-15s │ %-20s │%n", "", "Nome", "Sexo", "Cor", "Olhos", "Detalhe");
        System.out.println("├──────────────────────────────────────────────────────────────────────────────────────┤");

        for (GameCharacter c : characters) {
            String status = c.isActive() ? "✅" : "❌";

            System.out.printf("│ %-3s %-12s │ %-10s │ %-10s │ %-15s │ %-20s │%n",
                    status,
                    c.getNome(),
                    c.getSexo(),
                    c.getCor(),
                    c.getOlho(),
                    c.getDetalhe());
        }

        System.out.println("└──────────────────────────────────────────────────────────────────────────────────────┘");
    }

    public void showAvailableAttributes(Set<String> attributes) {
        System.out.println("┌─────────────────────────────────────────────────────────┐");
        System.out.println("│           🔍 CARACTERÍSTICAS DISPONÍVEIS 🔍            │");
        System.out.println("├─────────────────────────────────────────────────────────┤");

        int count = 1;
        for (String attr : attributes) {
            System.out.printf("│  %d. %-50s │%n", count++, attr);
        }

        System.out.println("│  0. 🎯 DAR UM CHUTE!                                   │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
    }

    public void showRemovedCharacters(List<GameCharacter> removed) {
        if (removed.isEmpty()) {
            return;
        }

        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│              ❌ PERSONAGENS ELIMINADOS ❌              │");
        System.out.println("├─────────────────────────────────────────────────────────┤");

        for (GameCharacter character : removed) {
            System.out.printf("│  • %-52s │%n", character.getNome());
        }

        System.out.println("└─────────────────────────────────────────────────────────┘\n");
    }

    public void showAnswer(boolean hasAttribute, String attribute) {
        if (hasAttribute) {
            System.out.println("\n✅ SIM! O personagem secreto TEM: " + attribute);
        } else {
            System.out.println("\n❌ NÃO! O personagem secreto NÃO TEM: " + attribute);
        }
    }

    public void showVictory(String characterName) {
        ConsoleHelper.clearScreen();
        System.out.println("\n");
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║                                                           ║");
        System.out.println("║              🎉🎉🎉 PARABÉNS! 🎉🎉🎉                     ║");
        System.out.println("║                                                           ║");
        System.out.println("║           VOCÊ ADIVINHOU O PERSONAGEM!                   ║");
        System.out.println("║                                                           ║");
        System.out.printf("║              O personagem era: %-22s ║%n", characterName);
        System.out.println("║                                                           ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");
    }

    public void showDefeat(String characterName) {
        ConsoleHelper.clearScreen();
        System.out.println("\n");
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║                                                           ║");
        System.out.println("║                 😢 QUE PENA! 😢                          ║");
        System.out.println("║                                                           ║");
        System.out.println("║              VOCÊ NÃO ACERTOU DESTA VEZ!                 ║");
        System.out.println("║                                                           ║");
        System.out.printf("║              O personagem era: %-22s ║%n", characterName);
        System.out.println("║                                                           ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");
    }

    public void showRemainingQuestions(int remaining) {
        if (remaining == -1) {
            System.out.println("💬 Perguntas restantes: ∞ (Ilimitadas)");
        } else {
            System.out.println("💬 Perguntas restantes: " + remaining);

            if (remaining <= 2) {
                System.out.println("⚠️  ATENÇÃO: Poucas perguntas restantes!");
            }
        }
    }

    public void showGameOver() {
        ConsoleHelper.clearScreen();
        System.out.println("\n");
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║                                                           ║");
        System.out.println("║                 ⏰ GAME OVER! ⏰                          ║");
        System.out.println("║                                                           ║");
        System.out.println("║           SUAS PERGUNTAS ACABARAM!                       ║");
        System.out.println("║                                                           ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");
    }

    public void showInvalidChoice() {
        System.out.println("\n❌ Opção inválida! Tente novamente.");
    }

    public void showActiveCharactersCount(int count) {
        System.out.println("\n📊 Personagens ainda ativos: " + count);
    }
}