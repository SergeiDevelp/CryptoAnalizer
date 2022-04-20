package ru.javarush.zakharov.cryptoanalizer.constants;

import java.nio.file.Path;

public class PathBuilder {
    private PathBuilder(){

    }

    public static Path get(String filename){
        Path path = Path.of(filename);
        return path.isAbsolute()
                ? path
                : Path.of(Constants.TXT_FOLDER + filename);
    }
}
