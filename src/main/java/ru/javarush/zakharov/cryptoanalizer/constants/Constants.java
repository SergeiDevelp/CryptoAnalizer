package ru.javarush.zakharov.cryptoanalizer.constants;

import java.io.File;

public class Constants {
    private static final String rusAlphabet = "абвгдеёжзийклмнопрстуфхцщшьыъэюя";
    private static final String z = "`~!@#$%^&*()_-=+\\|/[]{};:'\"<>.,№?";
    private static final String cypher = "0123456789";

    public static final String ALPHABET = rusAlphabet + z + cypher;

    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "texts" + File.separator;
}
