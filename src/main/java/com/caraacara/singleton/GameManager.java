package com.caraacara.singleton;


public class GameManager {
    
    private static GameManager instance;
    
    private boolean gameRunning;
    
    private GameManager() {
        this.gameRunning = false;
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
        System.out.println("✅ Jogo iniciado com sucesso!");
        return true;
    }

    public void endGame() {
        if (gameRunning) {
            gameRunning = false;
            System.out.println("🏁 Jogo finalizado!");
        }
    }
    

    public boolean isGameRunning() {
        return gameRunning;
    }
    

    public void reset() {
        gameRunning = false;
        instance = null;
    }
}
