package ru.javarush.zakharov.cryptoanalizer.controllers;

import ru.javarush.zakharov.cryptoanalizer.commands.*;
import ru.javarush.zakharov.cryptoanalizer.exceptions.AppException;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCE(new BruteForce()),
    ANALYZE(new Analyze()),
    EXIT(new Exit());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String actionName){
        try {
            Actions value = Actions.valueOf(actionName.toUpperCase());
            return value.action;
        } catch (IllegalArgumentException e){
            throw new AppException();
        }
    }
}
