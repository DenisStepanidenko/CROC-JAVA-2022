package ru.croc.task1;
import ru.croc.task1.some_package.Point;
import ru.croc.task1.some_package.CalculatingAreaTriangle;
import java.util.Scanner; // класс, который нужен нам для считывания данных

public class Task1 {
    public static void main(String[] args) {
        Scanner F = new Scanner(System.in); // объект, который будет считавать данные с клавиатуры
        Point point1 = new Point(); //объект point_1 будет отвечать за 1 вершину
        Point point2 = new Point(); // объект point_2 будет отвечать за 2 вершину
        Point point3 = new Point(); // объект point_3 будет отвечать за 3 вершину
        CalculatingAreaTriangle.loadingAndCheck(point1 , point2 , point3 , F); // вызываем метод для заполнения данных о значениях координат наших вершин
        double answer = CalculatingAreaTriangle.calculatingTheArea(point1 , point2 , point3);
        System.out.println("Искомый ответ - " +  answer);
        // проблема только в том,что ответы будут ненамного отличаться от правильного из-за неточности деления ):
    }
}