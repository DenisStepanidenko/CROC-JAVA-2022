package ru.croc.task7.some_package;

public class ChessKnight {
    public static boolean moveCorrect(ChessPosition start, ChessPosition end){
        return ( Math.abs(start.getX() - end.getX()) == 1 && Math.abs(start.getY() - end.getY()) == 2 ) || ( Math.abs(start.getY() - end.getY()) == 1 && Math.abs(start.getX() - end.getX()) == 2 );
    }
    // тут мы проверяем можно ли с позиции start конём дойти до позиции end

    public static void checkMovesObject(ChessPosition[] positions) throws IllegalMoveException{ // На вход метод принимает массив объектов класса, определенных в текущей задаче
        for(int j = 0; j < positions.length - 1 ; j++){
            ChessPosition start = positions[j];
            ChessPosition end = positions[j+1];
            if(!moveCorrect(start , end)){
                throw new IllegalMoveException(start , end);
            }
        }
        System.out.println("OK");
    }

    public static void checkMovesString(String[] positions) throws IllegalPositionException, IllegalMoveException { //на вход метод принимает массив строк с помощью которых записана некоторая последовательность ходов
        // сначала создадим массив объектов которые соответствуют строковому отображению позиций
        // благо для этого у нас есть фабричный метод, который мы описали :)
        ChessPosition[] positionsObject = new ChessPosition[positions.length];
        for(int i = 0 ; i < positions.length ; i++){
            positionsObject[i] = ChessPosition.parse(positions[i]);
        }

        // теперь у нас есть массив объектов, можно проверить правильность ходов с помощью уже написанного метода
        try{
            checkMovesObject(positionsObject);
            //System.out.println("OK");
        }
        catch(IllegalMoveException e) {
            System.out.println(e);
        }

    }
}
