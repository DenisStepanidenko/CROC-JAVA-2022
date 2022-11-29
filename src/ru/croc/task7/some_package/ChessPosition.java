package ru.croc.task7.some_package;

public class ChessPosition {
    private int x;
    private int y;

    private static final String LETTERS_CHESSBOARD = "abcdefgh";
    public ChessPosition(int x , int y) throws IllegalPositionException{ // конструктор
            setX(x);
            setY(y);
    }
    public int getX(){
        return  x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x) throws IllegalPositionException { // присваиваем значение координате х
        if(!validationCheck(x)){
            throw new IllegalPositionException(incorrectXCoordinate(x));
        }
        this.x = x;
    }

    public void setY(int y) throws  IllegalPositionException{ // присваиваем значение координате y
        if(!validationCheck(y)){
            throw new IllegalPositionException(incorrectYCoordinate(y));
        }
        this.y = y;
    }


    private boolean validationCheck(int x){ // здесь проверяем, валидная ли позиция
        return (x>=0 && x < 8);
    }

    private String incorrectXCoordinate(int x){ // выводим, если неверна введена координата х
        return "Your x, equal to " + x + " is incorrect. It must be number between 0 and 7";
    }
    private String incorrectYCoordinate(int y){ // выводим, если неверна введена координата y
        return "Your y, equal to " + y + " is incorrect. It must be number between 0 and 7";
    }

    @Override
    public  String toString(){ // выводит координаты позиции в строковом формате
        return Character.toString(LETTERS_CHESSBOARD.charAt(x)) + (y+1);
    }

    // реализуем фабричный метод
    public static ChessPosition parse(String position) throws  IllegalPositionException{
        if(position.length() != 2){
            throw new IllegalPositionException("Invalid position. It must be two characters long");
        }
        char xCoordinateChar = position.charAt(0);
        int xCoordinate = LETTERS_CHESSBOARD.indexOf(xCoordinateChar); //находим индекс символа xCoordinateChar в строке LETTERS_CHESSBOARD
        if(xCoordinate == -1){
            throw new IllegalPositionException("Invalid position. Character must be between a and h");
        }
        char yCoordinateChar = position.charAt(1);
        int yCoordinate = Character.getNumericValue(yCoordinateChar) - 1;
        if(yCoordinate >= 8){
            throw new IllegalPositionException("Invalid position. Number must be between 0 and 7");
        }

        return new ChessPosition(xCoordinate , yCoordinate);
    }

}
