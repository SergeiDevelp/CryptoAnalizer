package ru.javarush.zakharov.cryptoanalizer.commands;

import ru.javarush.zakharov.cryptoanalizer.commands.Action;
import ru.javarush.zakharov.cryptoanalizer.constants.Const;
import ru.javarush.zakharov.cryptoanalizer.entity.Result;
import ru.javarush.zakharov.cryptoanalizer.entity.ResultCode;

public class Exit extends AbstractAction {
    @Override
    public Result execute(String[] parameters) {

            return new Result(ResultCode.OK, Const.APPLICATION_CLOSED);

    }
}
