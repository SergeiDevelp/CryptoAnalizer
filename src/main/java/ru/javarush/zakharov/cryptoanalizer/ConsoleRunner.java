package ru.javarush.zakharov.cryptoanalizer;

import ru.javarush.zakharov.cryptoanalizer.controllers.MainController;
import ru.javarush.zakharov.cryptoanalizer.entity.Menu;
import ru.javarush.zakharov.cryptoanalizer.entity.Result;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //encode text.txt encode.txt 12
        Menu menu = new Menu(scanner);
        MainController mainController = new MainController();

        Application application = new Application(mainController, menu);
         application.run(args);
        //System.out.println(result);
    }
}
