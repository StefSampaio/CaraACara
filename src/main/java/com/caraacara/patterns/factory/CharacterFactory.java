package com.caraacara.patterns.factory;

import com.caraacara.model.CharacterType;
import com.caraacara.model.GameCharacter;

public class CharacterFactory {
    public static GameCharacter createCharacter(CharacterType type) {
        return new GameCharacter(
                type.name(),
                type.getSexo(),
                type.getCor(),
                type.getOlho(),
                type.getCabelo(),
                type.getDetalhe()
        );
    }
}