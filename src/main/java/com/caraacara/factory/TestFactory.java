package com.caraacara.factory;

public class TestFactory {

    public static void main(String[] args) {

        GameCharacter c1 = CharacterFactory.createCharacter(CharacterType.ANA);
        GameCharacter c2 = CharacterFactory.createCharacter(CharacterType.CARLOS);
        GameCharacter c3 = CharacterFactory.createCharacter(CharacterType.MARIA);
        GameCharacter c4 = CharacterFactory.createCharacter(CharacterType.JOAO);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
    }
}
