package com.caraacara.patterns.state;

import com.caraacara.model.GameCharacter;

public class ActiveState implements CharacterState {

    @Override
    public void activate(GameCharacter character) {
        System.out.println(character.getNome() + " já está ativo.");
    }

    @Override
    public void remove(GameCharacter character) {
        character.setState(new RemovedState());
        System.out.println(character.getNome() + " foi removido do jogo.");
    }

    @Override
    public boolean isActive() { return true; }

    @Override
    public boolean isRemoved() { return false; }
}