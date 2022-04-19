package ru.javarush.zakharov.cryptoanalizer;

import ru.javarush.zakharov.cryptoanalizer.controllers.MainController;
import ru.javarush.zakharov.cryptoanalizer.entity.Menu;
import ru.javarush.zakharov.cryptoanalizer.entity.*;
import ru.javarush.zakharov.cryptoanalizer.entity.Result;
import ru.javarush.zakharov.cryptoanalizer.entity.ResultCode;
import ru.javarush.zakharov.cryptoanalizer.exceptions.AppException;

import java.util.Arrays;

@SuppressWarnings("ClassCanBeRecord")
public class Application {

    private final MainController mainController;
    private final Menu menu;

    public Application(MainController mainController,Menu menu) {
        this.mainController = mainController;
        this.menu = menu;
    }

    //encode text.txt encode.txt 12
    public void run(String[] args) {
        Result result;
        do {
            if (args.length == 0) {
                args = menu.getArgs();
            }
            result = getResult(args);
            print(result);
            args = new String[0];
        } while (result.resultCode == ResultCode.ERROR);
    }

    private void print(Result result) {
        String message = switch (result.resultCode) {
            case OK -> String.format(
                    Messages.OK_FORMAT, result.message
            );
            case ERROR -> String.format(
                    Messages.ERR_FORMAT, result.message
            );
        };
        System.out.println(message);
    }

    private Result getResult(String[] args) {
        String action = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        return mainController.doAction(action, parameters);
    }

    
}
