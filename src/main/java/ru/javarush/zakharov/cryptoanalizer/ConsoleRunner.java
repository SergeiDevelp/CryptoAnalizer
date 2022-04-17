package ru.javarush.zakharov.cryptoanalizer;



import ru.javarush.zakharov.cryptoanalizer.entity.Result;

import java.util.ArrayList;

public class ConsoleRunner {
    public static void main(String[] args) {
        System.out.println("Hello maven");
        //сюда можно добавить чтение файла и
        String st = "Hello maven";
        char[] strAr = st.toCharArray();
        ArrayList<Character> al = new ArrayList<>();
        for (char c : strAr) {
            al.add(c);
        }
        System.out.println(al);

        Application application = new Application();
        Result result = application.run(args);
    }
}
