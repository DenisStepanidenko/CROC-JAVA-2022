package ru.croc.task7;

import ru.croc.task7.some_package.ChessPosition;
import ru.croc.task7.some_package.ChessKnight;
import ru.croc.task7.some_package.IllegalMoveException;
import ru.croc.task7.some_package.IllegalPositionException;

public class Task7 {
    public static void main(String[] args) throws IllegalPositionException , IllegalMoveException {

        //ChessPosition test = new ChessPosition(4 , 80); тестим исключение
        //ChessPosition test = new ChessPosition(80 ,7); тестим исключения

        //тестим проверку на правильность ходов (тут неверный ход)

        String[] positions1 = new String[]{"g8", "e7", "e6"};
        ChessKnight.checkMovesString(positions1);


        //тестим проверку на правильность ходов( тут верный ход)
        /*
        String[] positions1 = new String[]{"g8", "e7", "c8"};
        ChessKnight.checkMovesString(positions1);
        */

        //тестим фабричный метод
        ChessPosition test = ChessPosition.parse("b2");
        //заодно и проверим метод toString и getX и getY
        System.out.println(test.toString());
        System.out.println(test.getX());
        System.out.println(test.getY());
    }
}