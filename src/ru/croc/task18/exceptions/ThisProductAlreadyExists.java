package ru.croc.task18.exceptions;

public class ThisProductAlreadyExists extends Exception {
    @Override
    public String toString() {
        return "Товар с данным артикулом уже существует в текущей базе данных!";
    }
}
