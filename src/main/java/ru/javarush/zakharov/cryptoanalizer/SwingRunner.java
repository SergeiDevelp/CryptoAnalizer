package ru.javarush.zakharov.cryptoanalizer;

import ru.javarush.zakharov.cryptoanalizer.controllers.MainController;
import ru.javarush.zakharov.cryptoanalizer.swing.MainForm;

public class SwingRunner {
    public static void main(String[] args) {
        //build swing app
        MainController controller = new MainController();
        MainForm mainForm = new MainForm(controller);

        //run swing app
        mainForm.initialization();
    }
}
