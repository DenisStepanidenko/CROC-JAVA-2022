package ru.croc.task18.exceptions;

public class ThereIsNoSuchProductInDatabase extends Exception {
    @Override
    public String toString() {
        return "Вы ввели продукт, которого нет в базе данных!";
    }
}
