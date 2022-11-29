package ru.croc.task5.some_package;

public class Rectangle extends  Figure{
    private Point lowerLeftPoint; // левая нижняя точка
    private Point upperRightPoint; // левая верхняя точка
    public Rectangle(Point lowerLeftPoint, Point upperRightPoint){
        this.lowerLeftPoint = lowerLeftPoint;
        this.upperRightPoint = upperRightPoint;
    }

    public String toString(){
        return "R " + "(" + lowerLeftPoint.getAbscissa() + ", " + lowerLeftPoint.getOrdinate() + "), " + "(" + upperRightPoint.getAbscissa() + ", " + upperRightPoint.getOrdinate() + ")";
    }
    @Override // переопределяем метод для проверки, входит ли заданная точка в область прямоугольника
    public boolean existenceOfPoint(int x , int y){
        if((x>=lowerLeftPoint.getAbscissa() && x<=upperRightPoint.getAbscissa()) && (y>=lowerLeftPoint.getOrdinate() && y<=upperRightPoint.getOrdinate())){
            return  true;
        }
        else{
            return  false;
        }
    }
    @Override // переопределяем метод для смещений прямоугольника на величины dx и dy
    public void move(int dx , int dy){
        lowerLeftPoint.changeAbscissa(lowerLeftPoint.getAbscissa() + dx);
        lowerLeftPoint.changeOrdinate(lowerLeftPoint.getOrdinate() + dy);
        upperRightPoint.changeAbscissa(upperRightPoint.getAbscissa() + dx);
        upperRightPoint.changeOrdinate(upperRightPoint.getOrdinate() + dy);
    }
}
