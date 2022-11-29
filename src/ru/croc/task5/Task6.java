package ru.croc.task5;

import ru.croc.task5.some_package.Annotation;
import ru.croc.task5.some_package.Rectangle;
import ru.croc.task5.some_package.Circle;
import ru.croc.task5.some_package.Point;

public class Task6 {
    public static void main(String[] args) {
        // проведём небольшой тест
        Rectangle rectangle = new Rectangle(new Point(100,100) , new Point(150,200));
        Circle circle = new Circle(new Point(100,100) , 10);
        Annotation testRectangle = new Annotation(rectangle , "hello rectangle");
        Annotation testCircle = new Annotation(circle , "hello circle");

        Annotation[] annotations = new Annotation[]{testRectangle , testCircle}; // массив объектов

        //немного тестов задания 5
        //System.out.println(annotations[0].toString());
        //System.out.println(annotations[1].toString());

        // немного тестов задания 6
        //тестим поиск по точке
        Annotation testDecision1 = Annotation.findByPoint(annotations , 10000 , 100);
        if(testDecision1 != null){
            System.out.println(testDecision1.toString());
        }
        else{
            System.out.println("Фигуры, которая содержит заданную точку  - нет");
        }

        //тестим поиск подстроки в подписе
        Annotation testDecision2 = Annotation.findByLabel(annotations , "tanу");
        if(testDecision2 != null){
            System.out.println(testDecision2.toString());
        }
        else{
            System.out.println("Фигуры, которая содержит в своей подписи заданную построку - нет");
        }

        System.out.println("После смещения");
        //тестим смещения , сместим объекты из нашего массива annotations на какие-нибудь величины
        rectangle.move(17 , 20);
        circle.move(22 , 90);
        //посмотрим на обновлённую инфу
        for(Annotation annotation : annotations){
            System.out.println(annotation.toString());
        }


    }
}