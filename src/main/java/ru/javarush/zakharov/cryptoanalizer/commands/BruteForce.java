package ru.javarush.zakharov.cryptoanalizer.commands;

import ru.javarush.zakharov.cryptoanalizer.constants.Constants;
import ru.javarush.zakharov.cryptoanalizer.constants.PathBuilder;
import ru.javarush.zakharov.cryptoanalizer.entity.Result;
import ru.javarush.zakharov.cryptoanalizer.exceptions.AppException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce extends AbstractAction{
    @Override
    public Result execute(String[] parameters) {
        String encryptedFileName = parameters[0];
        String decryptedFileName = parameters[1];
        int keyInt = 0;
        char space = ' ';
        int sumRightSpace = 0;
        for (int key = 0; key < Constants.ALPHABET_CHAR.length; key++) {
            int spaceSum = findGoodSpace(encryptedFileName, key , space);
            if (spaceSum > sumRightSpace){
                sumRightSpace = spaceSum;
                keyInt = key;
            }
        }

        return copyWithKey(encryptedFileName, decryptedFileName, keyInt);
    }

    private int findGoodSpace(String encryptedFileName, int key, char space) {
        int spaceSum = 0;
        Path path = PathBuilder.get(encryptedFileName);
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)){
            int value;
            while ((value = bufferedReader.read()) > -1){
                char character = (char) value;
                if (Constants.INDEX.containsKey(character)){
                    int indexCharInAlphabet = Constants.INDEX.get(character);
                    indexCharInAlphabet = (indexCharInAlphabet + key + Constants.ALPHABET_CHAR.length) % Constants.ALPHABET_CHAR.length;
                    if (Constants.ALPHABET_CHAR[indexCharInAlphabet] == space){
                        spaceSum++;
                    }
                }
            }

        }   catch (IOException e){
            throw new AppException();//TODO write exception
        }

        return spaceSum;
    }
}
