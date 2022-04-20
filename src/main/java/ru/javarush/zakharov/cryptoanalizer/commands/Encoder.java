package ru.javarush.zakharov.cryptoanalizer.commands;

import ru.javarush.zakharov.cryptoanalizer.entity.Result;

public class Encoder extends AbstractAction {

    @Override
    public Result execute(String[] parameters) {
        String sourceTextFile = parameters[0];
        String encryptedFile = parameters[1];
        int keyInt = Integer.parseInt(parameters[2]);
        return copyWithKey(sourceTextFile, encryptedFile, keyInt);
    }
}
