package com.caraacara.patterns.state;

import com.caraacara.model.GameCharacter;

public class RemovedState implements CharacterState {

    @Override
    public void activate(GameCharacter character) {
        character.setState(new ActiveState());
        System.out.println(character.getNome() + " foi reativado no jogo.");
    }

    @Override
    public void remove(GameCharacter character) {
        System.out.println(character.getNome() + " já está removido.");
    }

    @Override
    public boolean isActive() { return false; }

    @Override
    public boolean isRemoved() { return true; }
}