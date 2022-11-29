package ru.croc.task5.some_package;

abstract class Figure implements  Movable{
    @Override
    public abstract String toString();
    abstract boolean existenceOfPoint(int x , int y);
}
