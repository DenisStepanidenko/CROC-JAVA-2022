package ru.croc.task1.some_package;

import java.util.Scanner;

public class CalculatingAreaTriangle{
    public static void loadingAndCheck(Point point1 , Point point2 , Point point3 , Scanner F){ // метод для считывания первоначальных данных
        System.out.println("Введите координату х вершины №1: ");
        point1.x = F.nextDouble();
        System.out.println("Введите координату y вершины №1: ");
        point1.y = F.nextDouble();
        System.out.println("Введите координату х вершины №2: ");
        point2.x = F.nextDouble();
        System.out.println("Введите координату y вершины №2: ");
        point2.y = F.nextDouble();
        System.out.println("Введите координату x вершины №3: ");
        point3.x = F.nextDouble();
        System.out.println("Введите координату y вершины №3: ");
        point3.y = F.nextDouble();

        double length1 = CalculatingAreaTriangle.calculatingLengths(point1.x, point1.y, point2.x, point2.y);
        double length2 = CalculatingAreaTriangle.calculatingLengths(point1.x , point1.y , point3.x , point3.y);
        double length3 = CalculatingAreaTriangle.calculatingLengths(point2.x , point2.y , point3.x , point3.y);

        while(!CalculatingAreaTriangle.check(length1 , length2 , length3)){
            System.out.println("К сожалению из данных точек нельзя составить треугольник, введите повторно значения координат ваших вершин: ");
            CalculatingAreaTriangle.loadingAndCheck(point1 , point2 , point3 , F);
            length1 = CalculatingAreaTriangle.calculatingLengths(point1.x , point1.y , point2.x , point2.y);
            length2 = CalculatingAreaTriangle.calculatingLengths(point1.x , point1.y , point3.x , point3.y);
            length3 = CalculatingAreaTriangle.calculatingLengths(point2.x , point2.y , point3.x , point3.y);
        }

    }
    public static double calculatingLengths(double x1 , double y1 , double x2 , double y2 ){ // метод для вычисления длины между точками (x1,y1) и (x2,y2)
        return Math.sqrt( (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) );


    }
    public static boolean check(double x , double y , double z){ // проверка на неравенство треугольника
        if( (x+y>z) && (x+z>y) && (y+z>x) ){
            return true;
        }
        else{
            return false;
        }
    }
    public static double calculatingTheArea(Point point1 , Point point2 , Point point3){ // метод для вычисления площади треугольника по трём сторонам
        double length1 = CalculatingAreaTriangle.calculatingLengths(point1.x , point1.y , point2.x , point2.y);
        double length2 = CalculatingAreaTriangle.calculatingLengths(point1.x , point1.y , point3.x , point3.y);
        double length3 = CalculatingAreaTriangle.calculatingLengths(point2.x , point2.y , point3.x , point3.y);
        double halfPerimetr = (length1 + length2 + length3) / 2;
        return Math.sqrt(halfPerimetr * ( halfPerimetr - length1) * (halfPerimetr -length2) * (halfPerimetr - length3));
    }

}
