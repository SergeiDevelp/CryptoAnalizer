package ru.javarush.zakharov.cryptoanalizer.commands;
import ru.javarush.zakharov.cryptoanalizer.constants.Const;
import ru.javarush.zakharov.cryptoanalizer.constants.Constants;
import ru.javarush.zakharov.cryptoanalizer.constants.PathBuilder;
import ru.javarush.zakharov.cryptoanalizer.entity.Result;
import ru.javarush.zakharov.cryptoanalizer.entity.ResultCode;
import ru.javarush.zakharov.cryptoanalizer.exceptions.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractAction implements Action {
    public Result copyWithKey(String sourceTextFile, String encryptedFile, int key) {
        Path source = PathBuilder.get(sourceTextFile);
        Path target = PathBuilder.get(encryptedFile);
        try (
                BufferedReader reader = Files.newBufferedReader(source);
                BufferedWriter writer = Files.newBufferedWriter(target)
        ) {
            int value;
            int length = Constants.ALPHABET_CHAR.length;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                character = Character.toLowerCase(character);
                if (Constants.INDEX.containsKey(character)) {
                    Integer index = Constants.INDEX.get(character);
                    index = (index + key + Math.abs(key) * length) % length;
                    writer.write(Constants.ALPHABET_CHAR[index]);
                } else if (character == '\n') {
                    writer.write(character);
                }
            }

        } catch (IOException e) {
            throw new AppException(Const.INCORRECT_FILE + e.getMessage(), e);//AppException(Constants.INCORRECT_FILE + e.getMessage(), e);
        }
        return new Result(ResultCode.OK, encryptedFile);
    }
}
