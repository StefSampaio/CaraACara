package com.caraacara.factory;

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
