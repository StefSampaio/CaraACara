package com.caraacara.patterns.state;

import com.caraacara.model.GameCharacter;

public interface CharacterState {
    void activate(GameCharacter character);
    void remove(GameCharacter character);

    boolean isActive();
    boolean isRemoved();
}