package com.caraacara.compose;

import com.caraacara.model.GameCharacter;
import java.util.ArrayList;
import java.util.List;

public class CharacterCompose {

    private final List<GameCharacter> personagens = new ArrayList<>();

    public void add(GameCharacter c) { personagens.add(c); }
    public void remove(GameCharacter c) {
        c.remove();
        personagens.remove(c);
    }

    public List<GameCharacter> getPersonagensAtivos() {
        List<GameCharacter> ativos = new ArrayList<>();
        for (GameCharacter c : personagens) {
            if (c.isActive()) ativos.add(c);
        }
        return ativos;
    }
}