package ru.javarush.zakharov.cryptoanalizer.commands;

import ru.javarush.zakharov.cryptoanalizer.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
