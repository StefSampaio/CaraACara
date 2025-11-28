package com.caraacara.view;

import java.util.Scanner;

public class ConsoleHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    public static void waitForEnter() {
        System.out.print("\n⏎ Pressione Enter para continuar...");
        scanner.nextLine();
    }

    public static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static void closeScanner() {
        scanner.close();
    }
}