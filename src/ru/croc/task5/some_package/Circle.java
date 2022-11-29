package ru.croc.task5.some_package;

public class Circle extends Figure{
    private Point center;
    private int radius;
    public Circle(Point center, int radius){
        this.center = center;
        this.radius = radius;
    }

    public String toString(){
        return "C " + "(" + center.getAbscissa() + ", " + center.getOrdinate() + "), " + radius;
    }
    @Override // переопределяем метод для проверки, входит ли заданная точка в область круга
    public boolean existenceOfPoint(int x , int y){
        if((x-center.getAbscissa())*(x-center.getAbscissa()) + (y-center.getOrdinate())*(y-center.getOrdinate()) <= radius*radius ){
            return true;
        }
        else{
            return false;
        }
    }
    @Override // переопределяем метод для смещения круга на величины dx и dy
    public void move(int dx , int dy){
        center.changeOrdinate(center.getOrdinate() + dy);
        center.changeAbscissa(center.getAbscissa() + dx);
    }
}
