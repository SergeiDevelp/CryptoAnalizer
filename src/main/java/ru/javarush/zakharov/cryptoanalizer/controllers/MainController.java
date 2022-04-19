package ru.javarush.zakharov.cryptoanalizer.controllers;

import ru.javarush.zakharov.cryptoanalizer.commands.Action;
import ru.javarush.zakharov.cryptoanalizer.entity.Result;

public class MainController {

    public Result doAction(String actionName, String[] parameters){
        //actionName == encode
        //parameters == //[text.txt encode.txt 12]
        Action action = Actions.find(actionName);
        return action.execute(parameters);
    }
}
