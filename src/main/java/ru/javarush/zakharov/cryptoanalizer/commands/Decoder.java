package ru.javarush.zakharov.cryptoanalizer.commands;

import ru.javarush.zakharov.cryptoanalizer.entity.Result;

public class Decoder extends AbstractAction {

    @Override
    public Result execute(String[] parameters) {
        String sourceTextFile = parameters[0];
        String encryptedFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        return copyWithKey(sourceTextFile, encryptedFile, -1 * key);
    }
}
