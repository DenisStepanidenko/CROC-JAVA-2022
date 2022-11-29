package ru.croc.task5.some_package;

public class Point {
    private double x;
    private double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void changeAbscissa(double x){
        this.x = x;
    }
    public void changeOrdinate(double y){
        this.y = y;
    }
    public double getAbscissa(){
        return x;
    }
    public double getOrdinate(){
        return y;
    }

}
