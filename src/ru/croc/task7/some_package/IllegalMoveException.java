package ru.croc.task7.some_package;

public class IllegalMoveException extends Exception{
    public ChessPosition start;
    public ChessPosition end;

    public IllegalMoveException(ChessPosition start , ChessPosition end){
        this.start = start;
        this.end = end;
    }

    @Override // здесь выводим информацию про то, какой ход неверен
    public String toString(){
        return "Incorrect moves for knight: " + start.toString() + "->" + end.toString();
    }
}
