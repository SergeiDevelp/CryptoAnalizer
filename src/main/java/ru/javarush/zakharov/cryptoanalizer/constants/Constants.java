package ru.javarush.zakharov.cryptoanalizer.constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Constants {
    private static final String rusAlphabet = "абвгдеёжзийклмнопрстуфхцчщшьыъэюя";
    private static final String z = "`~!@#$%^&*()_ -=+\\|/[]{};:'\"<>.,№?";
    private static final String cypher = "0123456789";

    //public static final String ALPHABET1 = rusAlphabet + z + cypher;
    public static final char[] ALPHABET_CHAR = (rusAlphabet + z + cypher).toCharArray();

    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "texts" + File.separator;



    public static final Map<Character, Integer> INDEX = new HashMap<>();


    static {
        for (int i = 0; i < ALPHABET_CHAR.length; i++) {
            INDEX.put(ALPHABET_CHAR[i],i);
        }
    }

}
